package com.imdnd.common.util;

import org.junit.Test;

public class MacUtilsTest {

    @Test
    public void testIp() {
        System.out.println(MacUtils.getIpAddress());
        System.out.println(MacUtils.getMacAddress());
    }
}
