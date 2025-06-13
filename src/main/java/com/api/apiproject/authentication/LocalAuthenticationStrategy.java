package com.api.apiproject.authentication;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class LocalAuthenticationStrategy implements AuthenticationStrategy {

    private static final Map<String, String> HARDCODED_CREDENTIALS = Map.of(
            "admin", "abcd1234"
    );

    @Override
    public boolean isValid(String username, String password) {

        if (StringUtils.isAnyBlank(username, password)) {
            return false;
        }

        return HARDCODED_CREDENTIALS.entrySet().stream()
                .anyMatch(p -> StringUtils.equals(username, p.getKey()) && StringUtils.equals(password, p.getValue()));
    }

}
