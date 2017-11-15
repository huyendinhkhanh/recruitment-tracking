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
import com.cmc.recruitment.service.image.ImageService;
import com.cmc.recruitment.service.user.UserService;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE })
@RequestMapping("/user")
public class ImageRestController {
	@Autowired
	ImageService imageService;
	
	Image image;
	List<String> files = new ArrayList<String>();
	
	@RequestMapping(value = "/avatar-image/{imageId}", method = RequestMethod.GET)
	public ResponseEntity<Image> findImageById(@PathVariable long imageId) {
		image = imageService.findImageById(imageId);
		return image == null ? 
				(ResponseEntity<Image>) new ResponseEntity<Image>(HttpStatus.NOT_FOUND) 
				: 
				(ResponseEntity<Image>) new ResponseEntity<Image>(image, HttpStatus.OK);
	}
	@RequestMapping(value = "/all/images", method = RequestMethod.GET)
	public ResponseEntity<List<Image>> getAllImages() {
		
		return imageService.getAllImages().isEmpty() ? 
				new ResponseEntity<List<Image>>(HttpStatus.NO_CONTENT) 
				: 
				new ResponseEntity<List<Image>>(imageService.getAllImages(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/all/avatar-images", method = RequestMethod.GET)
	public ResponseEntity<List<Image>> getAllAvatarImages() {
		List<Image> avatarImages = imageService.getAllImages();
		for (int i = 0; i < avatarImages.size(); i++) {
			if (!avatarImages.get(i).getDescription().equals("avatar-user")) {
				avatarImages.remove(i);
			}
		}
		return avatarImages.isEmpty() ? 
				new ResponseEntity<List<Image>>(HttpStatus.NO_CONTENT) 
				: 
				new ResponseEntity<List<Image>>(avatarImages, HttpStatus.OK);
	}
}