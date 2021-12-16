package com.revature.project2.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.revature.project2.entity.User;
import com.revature.project2.repository.UserRepository;

import java.util.ArrayList;

@Service
public class UserServiceImpl implements UserService, UserDetailsService{

    @Autowired
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder=new BCryptPasswordEncoder();

    @Override
    public void register(User user) {
        String bcryptHashString = passwordEncoder.encode(user.getPassword());
        user.setPassword(bcryptHashString);
        userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=userRepository.findByUsername(username);
        if(user==null)throw  new UsernameNotFoundException(username);


        UserDetails userDetails=new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),new ArrayList<>());
        return userDetails;
    }
}
