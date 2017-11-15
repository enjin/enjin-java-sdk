package com.enjin.coin.sdk.util;

import java.util.Random;
/**
 * <p>Any utility Functionality required for the sdk</p>
 * @author damien
 *
 */
public class Utils {

    /**
     * Method to generate a randomId
     *
     * @param inTestMode - whether we are in testmode or not
     * @return - a randomId
     */
    public static String generateRandomId(boolean inTestMode) {
        //If in test mode - send the test mode id - otherwise create an id
        if (inTestMode) {
            return Constants.testModeId;
        }

        int randomInt1 = generateRandomInt(Constants.ONE_THOUSAND, Constants.ONE_HUNDRED_THOUSAND);
        int randomInt2 = generateRandomInt(Constants.ONE_THOUSAND, Constants.ONE_HUNDRED_THOUSAND);

        String randomId = "" + randomInt1 + System.currentTimeMillis() + randomInt2;

        return randomId;
    }

    /**
     * Returns a psuedo-random number between min and max, inclusive.
     * The difference between min and max can be at most
     * <code>Integer.MAX_VALUE - 1</code>.
     *
     * @param min Minimum value
     * @param max Maximum value.  Must be greater than min.
     * @return Integer between min and max, inclusive.
     * @see java.util.Random#nextInt(int)
     */
    public static int generateRandomInt(int min, int max) {
        // Usually this can be a field rather than a method variable
        Random rand = new Random();

        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        int randomNum = rand.nextInt((max - min) + 1) + min;

        return randomNum;
    }

}

