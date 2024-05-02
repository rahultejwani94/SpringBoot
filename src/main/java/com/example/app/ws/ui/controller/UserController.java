package com.example.app.ws.ui.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.app.ws.ui.model.response.UserRest;

@RestController
@RequestMapping("users")
public class UserController {

	@GetMapping
	public String getUser(@RequestParam(value = "page", defaultValue = "1", required = false) int page, @RequestParam(value = "limit", defaultValue = "50") int limit,
			@RequestParam(value = "sort", defaultValue = "asc", required = false) String sort
			) {
		return "get user called with page = " + page + " and limit = " + limit + " sort = " + sort;
	}

	@GetMapping(path = "/{userId}", 
			produces = {
					MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE
			})
	public ResponseEntity<UserRest> getUser(@PathVariable String userId) {
		UserRest userRest = new UserRest();
		userRest.setEmail("abc@gmail.com");
		userRest.setFirstName("abc");
		userRest.setLastName("xyz");
		userRest.setUserId("1");
		return new ResponseEntity<UserRest>(userRest, HttpStatus.OK);
	}

	@PostMapping
	public String createUser() {
		return "create user was called";
	}

	@PutMapping
	public String updateUser() {
		return "update user was called";
	}

	@DeleteMapping
	public String deleteUser() {
		return "delete user was called";
	}
}
