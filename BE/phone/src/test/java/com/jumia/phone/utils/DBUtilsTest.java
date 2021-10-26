package com.jumia.phone.utils;

import com.jumia.phone.enums.CountryCodeEnum;
import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

public class DBUtilsTest {


    @Test
    public void test_getCountyFilterCodeQuery_Cameroon() {
        Assert.assertEquals("(237)%",DBUtils.getCountyFilterCodeQuery("Cameroon"));
    }

    @Test
    public void test_getCountyFilterCodeQuery_Ethiopia() {
        Assert.assertEquals("(251)%",DBUtils.getCountyFilterCodeQuery("Ethiopia"));
    }

    @Test
    public void test_getCountyFilterCodeQuery_Morocco() {
        Assert.assertEquals("(212)%",DBUtils.getCountyFilterCodeQuery("Morocco"));
    }

    @Test
    public void test_getCountyFilterCodeQuery_Mozambique() {
        Assert.assertEquals("(258)%",DBUtils.getCountyFilterCodeQuery("Mozambique"));
    }

    @Test
    public void test_getCountyFilterCodeQuery_Uganda() {
        Assert.assertEquals("(256)%",DBUtils.getCountyFilterCodeQuery("Uganda"));
    }

}
