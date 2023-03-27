package com.harshini.hibernate.hibernateExcersise.controller;

import com.harshini.hibernate.hibernateExcersise.dto.AuthRequest;
import com.harshini.hibernate.hibernateExcersise.entity.UserInfo;
import com.harshini.hibernate.hibernateExcersise.service.JwtService;
import com.harshini.hibernate.hibernateExcersise.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.metamodel.mapping.ValueMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/new")
    public String addNewUser(@RequestBody UserInfo userInfo)
    {
        return userService.addUser(userInfo);
    }

    @PostMapping("/authenticate")
    public String authenticateAndGetToken(@RequestBody AuthRequest authRequest)
    {
        log.info("entering the authentication method");
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword()));
        if(authenticate.isAuthenticated()) {
            return jwtService.generateToken(authRequest.getUserName());
        }else
        {
            throw  new UsernameNotFoundException("Invalid Credentials provided! Please check");
        }
    }
}
