package com.example.app.ws.factory;

import com.example.app.ws.user.service.UserService;
import com.example.app.ws.user.service.impl.UserServiceImpl;
import com.example.app.ws.user.service.impl.UserServiceImpl2;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class UserServiceFactory {

    private final UserServiceImpl userServiceImpl;
    private final UserServiceImpl2 userServiceImpl2;


    public UserService getService(String type){
        if(type.equalsIgnoreCase("a")){
            return userServiceImpl;
        }
        else{
            return userServiceImpl2;
        }
    }
}
