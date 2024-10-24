package com.project.security_service.service;

import com.netflix.discovery.converters.Auto;
import com.project.security_service.dao.UserCredentialsDao;
import com.project.security_service.entity.UserCredentialsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserCredentialsService {

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserCredentialsDao userCredentialsDao;

    @Autowired
    private PasswordEncoder passwordEncoder;
    public UserCredentialsEntity register(UserCredentialsEntity user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userCredentialsDao.save(user);
    }
    public String generateToken(String name) {
        return jwtService.generateToken(name);
    }
    public boolean verifyToken(String token) {
        jwtService.validateToken(token);
        return true;
    }
}
