package com.harshini.hibernate.hibernateExcersise.service;

import com.harshini.hibernate.hibernateExcersise.config.UserInfoUserDetails;
import com.harshini.hibernate.hibernateExcersise.dao.UserInfoRepository;
import com.harshini.hibernate.hibernateExcersise.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserInfoUserDetailsService implements UserDetailsService {

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserInfo> user = userInfoRepository.findByName(username);
        return user.map(UserInfoUserDetails::new)
                   .orElseThrow(()->new UsernameNotFoundException("User not found"+username));

    }
}
