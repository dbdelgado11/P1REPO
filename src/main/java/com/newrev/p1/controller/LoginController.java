package com.newrev.p1.controller;

import com.newrev.p1.model.LoginTemplate;
import com.newrev.p1.model.User;
import com.newrev.p1.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

	@Autowired
	private UserService userService;
	
	
	@PostMapping("/login")//localhost:8087/login
	public ResponseEntity<User> login(@RequestBody LoginTemplate loginTemplate) {
		
		return ResponseEntity.ok(userService.login(loginTemplate.getUsername(), loginTemplate.getPassword()));
	}
	
	@PostMapping("/logout")//localhost:8087/logout
	public ResponseEntity<Void> logout() {
		userService.logout();
		
		return ResponseEntity.accepted().build();
	}
}
