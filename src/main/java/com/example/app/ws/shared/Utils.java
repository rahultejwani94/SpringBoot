package com.example.app.ws.shared;

import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class Utils {

	
	public String getUserId() {
		return UUID.randomUUID().toString(); 
	}
}
