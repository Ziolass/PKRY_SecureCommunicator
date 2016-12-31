package com.pw.pkry.crypto;

import java.math.BigInteger;
import java.util.Random;

/**
 * Created by michal.ziolkowski on 2016-12-29.
 */
public class BigRandomDecGenerator {
    public static BigInteger getBigRandomInteger(int numberOfBits){
        BigInteger b = new BigInteger(256, new Random());
        return b;
    }

}
