package com.practice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.practice.dto.UserRequestDto;
import com.practice.service.UserService;

@RestController

public class UserController {
	
	private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
	
	@PostMapping("/user")
	public ResponseEntity<UserRequestDto> saveUser(@RequestBody UserRequestDto userData) {
		
		 userData = userService.saveUser(userData);
		
		return ResponseEntity.ok(userData);
	}
	
	
}
