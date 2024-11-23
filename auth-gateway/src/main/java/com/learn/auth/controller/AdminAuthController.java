package com.learn.auth.controller;


import com.learn.auth.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/admin/auth")
public class AdminAuthController {


    @Autowired
    @Qualifier("adminAuthManager")
    AuthenticationManager adminAuthManager;

    @PostMapping(path = "/login")
    public ResponseEntity<String> loginController(@RequestBody Account admin){

        System.out.println(admin.getUsername());
        System.out.println(admin.getPassword());
        Authentication adminAuthentication = new UsernamePasswordAuthenticationToken(admin.getUsername(),admin.getPassword());
        Authentication authenticationResponse = adminAuthManager.authenticate(adminAuthentication);
        return ResponseEntity.status(HttpStatus.OK).body("check");
    }

    @GetMapping(path = "/test")
    public ResponseEntity<String> testController(){
        return ResponseEntity.status(HttpStatus.OK).body("testing");
    }
}
