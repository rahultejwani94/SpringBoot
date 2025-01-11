package com.example.app.ws.user.service.impl;

import com.example.app.ws.ui.model.request.UserDetailsRequestModel;
import com.example.app.ws.ui.model.response.UserRest;
import com.example.app.ws.user.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl2 implements UserService {
    @Override
    public UserRest createUser(UserDetailsRequestModel userDetails) {
        return null;
    }

    @Override
    public String doSomething() {
        return "UserServiceImpl2";
    }
}
