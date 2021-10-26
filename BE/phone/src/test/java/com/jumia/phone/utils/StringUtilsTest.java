package com.jumia.phone.utils;

import org.junit.Assert;
import org.junit.Test;

public class StringUtilsTest {

    @Test
    public void testIsBlank_Contains_value() {
        Assert.assertFalse(StringUtils.isBlank("test"));
    }

    @Test
    public void testIsBlank_null() {
        Assert.assertTrue(StringUtils.isBlank(null));
    }

    @Test
    public void testIsBlank_empty() {
        Assert.assertTrue(StringUtils.isBlank(""));
    }


    @Test
    public void testIsNotBlank_Contains_value() {
        Assert.assertTrue(StringUtils.isNotBlank("test"));
    }

    @Test
    public void testIsNotBlank_null() {
        Assert.assertFalse(StringUtils.isNotBlank(null));
    }

    @Test
    public void testIsNotBlank_empty() {
        Assert.assertFalse(StringUtils.isNotBlank(""));
    }
}
