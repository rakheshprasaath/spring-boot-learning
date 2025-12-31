package com.rakhesh.jobApp;

import com.rakhesh.jobApp.model.User;
import com.rakhesh.jobApp.service.JwtService;
import com.rakhesh.jobApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    public UserService userService;

    @Autowired
    public AuthenticationManager authenticationManager;

    @Autowired
    public JwtService jwtService;

    @PostMapping("registerUser")
    public ResponseEntity<String> registerUser(User user) {
        try {
            userService.saveUser(user);
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
        return new ResponseEntity<>("successfully added", HttpStatus.CREATED);
    }

    @PostMapping("login")
    public ResponseEntity<String> loginUSer(@RequestBody User user)
    {
        Authentication authentication= authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));

        if(authentication.isAuthenticated())
            return new ResponseEntity<>(jwtService.generateToken(user.getUsername()), HttpStatus.CREATED);
        else
            return new ResponseEntity<>(HttpStatus.CREATED);

    }

}
