package me.hatter.tools.commons.misc;

import me.hatter.tools.commons.security.digest.Digests;

public class ETags {

    public static interface ETag {

        String calc(byte[] a);
    }

    public static ETag simple() {
        return new ETag() {

            @Override
            public String calc(byte[] a) {
                a = (a == null) ? new byte[0] : a;
                return Integer.toHexString(a.length) + "_" + Base64s.normal().encode(Digests.md5().digest(a));
            }
        };
    }
}
