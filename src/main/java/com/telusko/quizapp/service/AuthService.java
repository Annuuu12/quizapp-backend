package com.telusko.quizapp.service;

import com.telusko.quizapp.dao.UserDao;
import com.telusko.quizapp.model.QuizUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.telusko.quizapp.model.LoginRequest;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

@Service
public class AuthService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public ResponseEntity<String> registerUser(QuizUser user){
        user.setRole("USER");
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userDao.save(user);
        return new ResponseEntity<>("User Registered Successfully", HttpStatus.CREATED);
    }

    public ResponseEntity<String> loginUser(LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginRequest.getUsername(), loginRequest.getPassword()));
        if(authentication.isAuthenticated()) {
            String token = jwtService.generateToken(loginRequest.getUsername());
            return new ResponseEntity<>(token, HttpStatus.OK);
        }
        return new ResponseEntity<>("Invalid Credentials", HttpStatus.UNAUTHORIZED);
    }

}