package com.cmc.recruitment.controller;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cmc.recruitment.model.Image;
import com.cmc.recruitment.model.User;
import com.cmc.recruitment.service.user.UserService;
import com.cmc.recruitment.service.user.UserServiceImpl;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE })
@RequestMapping("/user")
public class UserRestController {
	@Autowired
	UserService userService;
	
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
	
	@RequestMapping(value = "/update/change-avatar")
	public ResponseEntity<User> changeAvatar(@RequestBody User user) {
		System.out.println(user.getAvatar());
		userService.updateUser(user);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
}