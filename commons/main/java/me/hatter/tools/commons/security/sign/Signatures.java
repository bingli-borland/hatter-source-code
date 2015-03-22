package me.hatter.tools.commons.security.sign;

import me.hatter.tools.commons.security.sign.Signature.SignatureType;

public class Signatures {

    public static Signature hmac() {
        return hmacSHA256();
    }

    public static Signature hmacSHA256() {
        return new Signature(SignatureType.HMAC_SHA256);
    }
}
