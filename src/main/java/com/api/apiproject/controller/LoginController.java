package com.api.apiproject.controller;

import com.api.apiproject.authentication.AuthenticationStrategy;
import com.api.apiproject.authentication.JwtService;
import com.api.apiproject.authentication.LocalAuthenticationStrategy;
import com.api.apiproject.service.LoginService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
public class LoginController {

    private final LoginService loginService;
    private final AuthenticationStrategy localAuthenticationStrategy;
    private final JwtService jwtService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String username, @RequestParam String password) {
        log.info("login, username: {}", username);
        if (loginService.isUserValid(username, password, localAuthenticationStrategy)) {
            return new ResponseEntity<>(jwtService.generateToken(username), HttpStatus.OK); // Return JWT
        }

        return new ResponseEntity<>("Invalid username or password", HttpStatus.UNAUTHORIZED);
    }
}
