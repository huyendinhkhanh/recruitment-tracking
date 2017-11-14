package com.cmc.recruitment.controller;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import com.cmc.recruitment.model.User;
import com.cmc.recruitment.service.user.UserService;
import com.cmc.recruitment.service.user.UserServiceImpl;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE })
@RequestMapping("/user")
public class UserRestController {
	@Autowired
	UserService userService;
	UserServiceImpl userServiceImpl;
	User user;
	List<String> files = new ArrayList<String>();
	
	@RequestMapping(value = "/{userId}", method = RequestMethod.GET)
	public ResponseEntity<User> getDetail(@PathVariable long userId) {
		user = userService.findUserById(userId);
		return user == null ? 
				new ResponseEntity<User>(HttpStatus.NOT_FOUND) 
				: 
				new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/update/change-password", method = RequestMethod.POST)
	public ResponseEntity<User> changePassword(@RequestBody User user) {
		userService.updateUser(user);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
		
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ResponseEntity<List<User>> getAllUsers() {
		
		return userService.getAllUsers().isEmpty() ? 
				new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT) 
				: 
				new ResponseEntity<List<User>>(userService.getAllUsers(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/post-image", method = RequestMethod.POST)
	public ResponseEntity<String> handleFileUpload(@RequestParam("file") MultipartFile file) {
		String message = "";
		try {
			userServiceImpl.store(file);
			files.add(file.getOriginalFilename());

			message = "You successfully uploaded " + file.getOriginalFilename() + "!";
			return ResponseEntity.status(HttpStatus.OK).body(message);
		} catch (Exception e) {
			message = "FAIL to upload " + file.getOriginalFilename() + "!";
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
		}
	}

	@RequestMapping(value = "/get-all-images", method = RequestMethod.GET)
	public ResponseEntity<List<String>> getListFiles(Model model) {
		List<String> fileNames = files
				.stream().map(fileName -> MvcUriComponentsBuilder
						.fromMethodName(UserRestController.class, "getFile", fileName).build().toString())
				.collect(Collectors.toList());

		return ResponseEntity.ok().body(fileNames);
	}

	@RequestMapping(value = "/images/files/{filename:.+}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Resource> getFile(@PathVariable String filename) {
		Resource file = userServiceImpl.loadFile(filename);
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
				.body(file);
	}

}
