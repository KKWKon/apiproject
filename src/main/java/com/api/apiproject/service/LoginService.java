package com.api.apiproject.service;

import com.api.apiproject.authentication.AuthenticationStrategy;

public interface LoginService {

    boolean isUserValid(String username, String password, AuthenticationStrategy authenticationStrategy);

}
