package com.movie.info.service.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class UserInformation implements UserDetailsService {
    // class for user related information

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return usersInfo(s);
    }

    private User usersInfo(String userID){
        Map<String ,String> userInfo= new HashMap<>();
        userInfo.put("arnab1", "{noop}passwd1");
        userInfo.put("arnab2", "{noop}passwd2");

        return new User(userID, userInfo.get(userID), new ArrayList<>());
    }
}

