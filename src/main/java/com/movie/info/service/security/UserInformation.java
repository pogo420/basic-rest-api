package com.movie.info.service.security;

import com.movie.info.service.bean.UserInfo;
import com.movie.info.service.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

@Configuration
public class UserInformation implements UserDetailsService {
    // class for user related information retrieval and validation

    @Autowired
    UserRepository userData;

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        return usersValidation(userId);
    }

    private Optional<UserInfo> getUserInfo(String userId) {
        return userData.findById(userId);
    }

    private User usersValidation(String userId){
        Optional<UserInfo> user = getUserInfo(userId);
        if(!user.isPresent()){
            return new User(userId, passEncode(""), new ArrayList<>());
        }
        return new User(user.get().getUser(), passEncode(user.get().getPassword()), Arrays.asList(
                new SimpleGrantedAuthority("ROLE_"+user.get().getRoles())));
    }

    private String passEncode(String pass){
        return "{noop}"+pass;
    }
}


