package com.imdnd.common.util;

import java.util.Optional;

public class RegexUtils {

    // 强密码验证表达式
    private static final String STRONG_PASSWORD_PATTERN = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}";

    /**
     * 强密码验证
     */
    public static boolean isStrongPassword(String input) {
        Optional<String> password = Optional.ofNullable(input);
        return password.isPresent() && password.get().matches(STRONG_PASSWORD_PATTERN);
    }


}
