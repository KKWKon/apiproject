package com.api.apiproject.util;

import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

@Slf4j
public class CommonUtil {

    private CommonUtil() {
    }

    public static boolean isInteger(String input) {
        boolean isInteger = Optional.ofNullable(input)
                .map(p -> input.matches("\\d+"))
                .orElse(false);
        log.debug("input: {}, isInteger: {}", input, isInteger);
        return isInteger;
    }

    public static Integer getIntegerIfValid(String input) {
        return isInteger(input) ? Integer.parseInt(input) : null;
    }
}
