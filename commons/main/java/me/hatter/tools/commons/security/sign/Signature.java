package me.hatter.tools.commons.security.sign;

import me.hatter.tools.commons.io.IOUtil;
import me.hatter.tools.commons.security.hmac.HMacs;

public class Signature {

    public static enum SignatureType {
        HMAC_SHA256, SHA256_RSA;
    }

    private SignatureType signatureType;
    private byte[]        key;

    public Signature(SignatureType signatureType) {
        this.signatureType = signatureType;
    }

    public Signature key(byte[] key) {
        this.key = key;
        return this;
    }

    public Signature key(String key) {
        this.key(IOUtil.bytes(key));
        return this;
    }

    public byte[] sign(byte[] bytes) {
        if (signatureType == SignatureType.HMAC_SHA256) {
            return HMacs.sha256(this.key).sign(bytes);
        }
        throw new RuntimeException("Not supported signature alg: " + signatureType);
    }

    public byte[] sign(String str) {
        return sign(IOUtil.bytes(str));
    }
}
