package com.enjin.coin.sdk.util;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class UtilsTest {

    @Test
    public void testConstructor() {
        Utils utils = new Utils();
        assertThat(utils).isNotNull();
    }

    @Test
    public void testGenerateRandomId_InTestMode() {
        String randomId = Utils.generateRandomId(true);
        assertThat(randomId).isNotNull();
    }

    @Test
    public void testGenerateRandomId_NotInTestMode() {
        String randomId = Utils.generateRandomId(false);
        assertThat(randomId).isNotNull();
    }

    @Test
    public void testGenerateRandomInt_1() {
        int min = 1;
        int max = 10;
        Integer randomInt = Utils.generateRandomInt(min, max);
        assertThat(randomInt).isNotNull();
    }

    @Test
    public void testGenerateRandomInt_2() {
        int min = 99;
        int max = 1000;
        Integer randomInt = Utils.generateRandomInt(min, max);
        assertThat(randomInt).isNotNull();
    }

}
