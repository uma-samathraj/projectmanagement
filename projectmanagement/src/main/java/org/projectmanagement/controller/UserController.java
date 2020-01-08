package org.projectmanagement.controller;

import org.projectmanagement.model.User;
import org.projectmanagement.service.UserService;
import org.projectmanagement.util.ApiResponse;
import org.projectmanagement.util.SignInRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/pm/user")
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping(path="/signup")
	public ApiResponse signUp(@RequestBody User user) {
		return userService.createNewUser(user);
	}

	@PostMapping(path="/signin")
	public ApiResponse signIn(@RequestBody SignInRequest request) {
		return userService.signIn(request);
	}
	
	
}

