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
	
	@RequestMapping(value = "/fileUpload", method = RequestMethod.POST)
	@Produces(MediaType.APPLICATION_JSON) 
	public Data continueFileUpload(HttpServletRequest request, HttpServletResponse response){
	        MultipartHttpServletRequest mRequest;
	String filename = "upload.xlsx";
	try {
	   mRequest = (MultipartHttpServletRequest) request;
	   mRequest.getParameterMap();
	   Iterator itr = mRequest.getFileNames();
	   while (itr.hasNext()) {
	        MultipartFile mFile = mRequest.getFile(itr.next());
	        String fileName = mFile.getOriginalFilename();
	        System.out.println(fileName);
	        java.nio.file.Path path = Paths.get("C:/Data/DemoUpload/" + filename);
	        Files.deleteIfExists(path);
	        InputStream in = mFile.getInputStream();
	        Files.copy(in, path);
	 }
	   } catch (Exception e) {
	        e.printStackTrace();
	   }
	return null;
	}}
