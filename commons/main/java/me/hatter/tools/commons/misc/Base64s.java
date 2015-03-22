package me.hatter.tools.commons.misc;

import me.hatter.tools.commons.string.StringUtil;

public class Base64s {

    public static enum Base64Type {
        NORMAL, URI_COMPATIBLE, URI_COMPATIBLE_WITH_E;
    }

    public static class Base64Encoder {

        private Base64Type base64Type;

        public Base64Encoder(Base64Type base64Type) {
            this.base64Type = base64Type;
        }

        public byte[] decode(String s) {
            if (base64Type == Base64Type.NORMAL) {
                return Base64.base64ToByteArray(s);
            } else {
                return Base64.base64ToByteArray(base64FromURICompatible(s));
            }
        }

        public String encode(byte[] a) {
            if (base64Type == Base64Type.NORMAL) {
                return Base64.byteArrayToBase64(a);
            } else if (base64Type == Base64Type.URI_COMPATIBLE) {
                return base64ToURICompatible(Base64.byteArrayToBase64(a), false);
            } else {
                return base64ToURICompatible(Base64.byteArrayToBase64(a), true);
            }
        }
    }

    public static Base64Encoder normal() {
        return new Base64Encoder(Base64Type.NORMAL);
    }

    public static Base64Encoder uriCompatible() {
        return new Base64Encoder(Base64Type.URI_COMPATIBLE);
    }

    public static Base64Encoder uriCompatibleWithE() {
        return new Base64Encoder(Base64Type.URI_COMPATIBLE_WITH_E);
    }

    // http://stackoverflow.com/questions/1228701/code-for-decoding-encoding-a-modified-base64-url
    private static String base64ToURICompatible(String str, boolean withE) {
        if (str == null) {
            return null;
        }
        str = str.replace('+', '-').replace('/', '_');
        if (!withE) {
            str = str.replace("=", "");
        }
        return str;
    }

    private static String base64FromURICompatible(String str) {
        if (str == null) {
            return null;
        }
        str = str.replace('-', '+').replace('_', '/');
        str += StringUtil.repeat("=", ((str.length() % 4) == 0) ? 0 : (4 - (str.length() % 4)));
        System.out.println(str);
        return str;
    }
}
