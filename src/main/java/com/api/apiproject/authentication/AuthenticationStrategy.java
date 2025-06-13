package com.api.apiproject.authentication;

public interface AuthenticationStrategy {

    boolean isValid(String username, String password);
}
