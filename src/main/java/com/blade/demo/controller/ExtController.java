package com.blade.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blade.demo.bean.User;
import com.blade.demo.bean.Users;
import com.blade.demo.services.IDemoDataService;

@RestController
public class ExtController {
	@Autowired
	IDemoDataService demoDataService;
	
	@GetMapping("/user")
	public ResponseEntity<Object> entitycall() {
		User response = demoDataService.RestTempl();
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@GetMapping("/allusers")
	public ResponseEntity<Object> getAllUsers() {
		User[] response = demoDataService.allUsers();
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
