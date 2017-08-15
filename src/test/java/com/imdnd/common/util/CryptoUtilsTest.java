package com.imdnd.common.util;

import org.junit.Assert;
import org.junit.Test;

public class CryptoUtilsTest {

    @Test
    public void testEncryption() {
        Assert.assertEquals("j8ocI4oPjob79d8xn2CeOw==", CryptoUtils.encrypt("password"));
        Assert.assertNull(CryptoUtils.encrypt(null));
        Assert.assertEquals("password", CryptoUtils.decrypt("j8ocI4oPjob79d8xn2CeOw=="));
    }

}
