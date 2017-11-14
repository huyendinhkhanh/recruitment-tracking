package com.cmc.recruitment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cmc.recruitment.model.Department;
import com.cmc.recruitment.service.department.DepartmentService;

//Only for crossing origin

@RestController
@CrossOrigin(origins = "*")
public class DepartmentRestController {
	
	@Autowired
	DepartmentService departmentService;

	@RequestMapping(value = "/departments", method = RequestMethod.GET)
	public ResponseEntity<List<Department>> getAllDepartments() {
		
		return departmentService.getAllDepartments().isEmpty() ? 
				new ResponseEntity<List<Department>>(HttpStatus.NO_CONTENT) 
				: 
				new ResponseEntity<List<Department>>(departmentService.getAllDepartments(), HttpStatus.OK);
	}
	
	
}
