package com.api.apiproject.service;

import com.api.apiproject.authentication.AuthenticationStrategy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class LoginServiceImpl implements LoginService {

    @Override
    public boolean isUserValid(String username, String password, AuthenticationStrategy authenticationStrategy) {
        log.info("isUserValid, username:{}, authenticationStrategy: {}", username, authenticationStrategy.getClass());
        return authenticationStrategy.isValid(username, password);
    }
}
