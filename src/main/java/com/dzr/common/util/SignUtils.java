package com.dzr.common.util;

import org.apache.commons.codec.binary.Hex;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.function.Function;


public class SignUtils {

    private static final Logger log = LoggerFactory.getLogger(SignUtils.class);

    public static byte[] hmacsha256(String data, String secret) {
            return hmacsha256(data, secret, bytes -> bytes);
    }

    public static String hmacsha256String(String data, String secret) {
        return hmacsha256(data, secret, Hex::encodeHexString);
    }

    private static <T> T hmacsha256(String data, String secret, Function<byte[], T> function) {
        try {
            Mac mac = Mac.getInstance("HmacSHA256");
            SecretKeySpec secretKey = new SecretKeySpec(secret.getBytes("UTF-8"), "HmacSHA256");
            mac.init(secretKey);
            return function == null ? null : function.apply(mac.doFinal(data.getBytes("UTF-8")));
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException | InvalidKeyException e) {
            log.error("Sign data failed.", e);
        }
        return null;
    }
}
