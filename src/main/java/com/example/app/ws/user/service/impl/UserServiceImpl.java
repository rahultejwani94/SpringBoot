package com.example.app.ws.user.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.ws.shared.Utils;
import com.example.app.ws.ui.model.request.UserDetailsRequestModel;
import com.example.app.ws.ui.model.response.UserRest;
import com.example.app.ws.user.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	Map<String, UserRest> usersMap;
	
	Utils utils;
	
	public UserServiceImpl() {}
	
	@Autowired
	public UserServiceImpl(Utils utils) {
		this.utils = utils;
	}
	@Override
	public UserRest createUser(UserDetailsRequestModel userDetails) {
		UserRest userRest = new UserRest();
		userRest.setEmail(userDetails.getEmail());
		userRest.setFirstName(userDetails.getFirstName());
		userRest.setLastName(userDetails.getLastName());
		
		String userId = utils.getUserId();
		userRest.setUserId(userId);
		
		if(usersMap == null) {
			usersMap = new HashMap<>();
			usersMap.put(userId, userRest);
		}
		return userRest;
	}

}
