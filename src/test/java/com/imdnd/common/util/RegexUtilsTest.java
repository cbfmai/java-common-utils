package com.imdnd.common.util;

import org.junit.Assert;
import org.junit.Test;

public class RegexUtilsTest {

    @Test
    public void testStrongPassword() {
        Assert.assertFalse(RegexUtils.isStrongPassword(null));
    }


}
