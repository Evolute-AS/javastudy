package com.qdc.demoeurekaauto_server.service.impl;

import com.qdc.demoeurekaauto_server.pojo.User;
import com.qdc.demoeurekaauto_server.pojo.Role;
import com.qdc.demoeurekaauto_server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=userService.getUser(username);
        if (user ==null || user.getId() < 1){
            throw new UsernameNotFoundException("Username not found:"+username);
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),
                true,true,true,true,getGrantAuhtoritest(user));

    }

    private Collection<? extends GrantedAuthority> getGrantAuhtoritest(User user){
        Set<GrantedAuthority> authorities=new HashSet<>();

        for (Role role:user.getRoles()){
            authorities.add(new SimpleGrantedAuthority("ROLE"+ role.getName()));
            System.out.println(role);
        }
        return authorities;
    }
}
