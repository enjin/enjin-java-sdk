package com.enjin.coin.sdk.util;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class UtilsTest {


    @Test
    public void testConstructor() {
        Utils utils = new Utils();
        assertNotNull(utils);
    }

    @Test
    public void testGenerateRandomId_InTestMode() {
        String randomId = Utils.generateRandomId(true);
        assertNotNull(randomId);
    }


    @Test
    public void testGenerateRandomId_NotInTestMode() {
        String randomId = Utils.generateRandomId(false);
        assertNotNull(randomId);
    }

    @Test
    public void testGenerateRandomInt_1() {
        int min = 1;
        int max = 10;
        Integer randomInt = Utils.generateRandomInt(min, max);
        assertNotNull(randomInt);
    }

    @Test
    public void testGenerateRandomInt_2() {
        int min = 99;
        int max = 1000;
        Integer randomInt = Utils.generateRandomInt(min, max);
        assertNotNull(randomInt);
    }
}
