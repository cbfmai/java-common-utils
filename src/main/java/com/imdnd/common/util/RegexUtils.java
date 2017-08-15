package com.imdnd.common.util;

import java.util.Optional;

/**
 * Common Regex Utils include password, email, ID card validation and so on
 */
public class RegexUtils {

    // Strong password pattern
    private static final String STRONG_PASSWORD_PATTERN = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}";


    /**
     * Verify the input whether is a strong password
     *
     * @param input null is accepted
     * @return
     */
    public static boolean isStrongPassword(String input) {
        Optional<String> password = Optional.ofNullable(input);
        return password.isPresent() && password.get().matches(STRONG_PASSWORD_PATTERN);
    }


}
