package com.example.app.ws.ui.controller;

import java.util.HashMap;
import java.util.Map;

import com.example.app.ws.factory.UserServiceFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.app.ws.exceptions.CustomException;
import com.example.app.ws.ui.model.request.UpdateUserDetailsRequestModel;
import com.example.app.ws.ui.model.request.UserDetailsRequestModel;
import com.example.app.ws.ui.model.response.UserRest;
import com.example.app.ws.user.service.UserService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("users")
public class UserController {

	Map<String, UserRest> usersMap;

	@Autowired
	private UserServiceFactory userServiceFactory;

	@Autowired
	@Qualifier("UserServiceImpl")
	UserService userService;
	
	@GetMapping
	public String getUsers(@RequestParam(value = "page", defaultValue = "1") int page, @RequestParam(value = "limit", defaultValue = "50") int limit,
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
//		if(true)
//			throw new CustomException("custom exception thrown");
//		String firstName = null;
//		int len = firstName.length();
		if(usersMap.containsKey(userId)) {
			return new ResponseEntity<>(usersMap.get(userId), HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}

	@PostMapping(
			consumes = {
					MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE
	},
			produces = {
					MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE
			}
			)
	public ResponseEntity<UserRest> createUser(@Valid @RequestBody UserDetailsRequestModel userDetails) {
		UserRest userRest = userService.createUser(userDetails);
		if(usersMap == null) {
			usersMap = new HashMap<>();
		}
		usersMap.put(userRest.getUserId(), userRest);
		return new ResponseEntity<UserRest>(userRest, HttpStatus.OK);
	}

	@PutMapping(path = "{userId}",
			consumes = {
					MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE
	},
			produces = {
					MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE
			})
	public ResponseEntity<UserRest> updateUser(@PathVariable String userId,@Valid @RequestBody UpdateUserDetailsRequestModel userDetails) {
		if(usersMap.containsKey(userId)) {
			UserRest storedUserDetails = usersMap.get(userId);
			storedUserDetails.setFirstName(userDetails.getFirstName());
			storedUserDetails.setLastName(userDetails.getLastName());
			
			usersMap.put(userId, storedUserDetails);
			return new ResponseEntity<>(storedUserDetails, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping(path = "/{userId}")
	public ResponseEntity<String> deleteUser(@PathVariable String userId) {
		if(usersMap.containsKey(userId)) {
			usersMap.remove(userId);
			return new ResponseEntity<>("userId: "+ userId + " is deleted", HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>("userId: "+ userId + " doesn't exist", HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/factory/{type}")
	public ResponseEntity<String> getFactoryService(@PathVariable String type){
		String value = userServiceFactory.getService(type).doSomething();
		return new ResponseEntity<>(value, HttpStatus.OK);
	}
}
