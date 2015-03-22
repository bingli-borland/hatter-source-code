package me.hatter.tools.commons.totp;

public class TOTPs {

    public static class TOTPGenerator {

        private String crypto;
        private byte[] key;
        private int    digits;

        public TOTPGenerator(String crypto) {
            this.crypto = crypto;
        }

        public TOTPGenerator key(byte[] key) {
            this.key = key;
            return this;
        }

        public TOTPGenerator digits(int digits) {
            this.digits = digits;
            return this;
        }

        public String generate(long seed) {
            return TOTP.generateTOTP(key, Long.toHexString(seed), String.valueOf(digits), crypto);
        }

        public String[] generates(long... seeds) {
            String[] results = new String[seeds.length];
            for (int i = 0; i < seeds.length; i++) {
                results[i] = generate(seeds[i]);
            }
            return results;
        }

        public String generateNow() {
            long nowIn30Sec = System.currentTimeMillis() / 1000 / 30;
            return generate(nowIn30Sec);
        }

        public String[] generateNow3() {
            long nowIn30Sec = System.currentTimeMillis() / 1000 / 30;
            return generates(nowIn30Sec - 1, nowIn30Sec, nowIn30Sec + 1);
        }
    }

    public static TOTPGenerator defaultInstance() {
        return hmacSHA1().digits(6);
    }

    public static TOTPGenerator defaultInstance(byte[] key) {
        return hmacSHA1().digits(6).key(key);
    }

    public static TOTPGenerator hmacSHA1() {
        return new TOTPGenerator("HmacSHA1");
    }

    public static TOTPGenerator hmacSHA256() {
        return new TOTPGenerator("HmacSHA256");
    }

    public static TOTPGenerator hmacSHA512() {
        return new TOTPGenerator("HmacSHA512");
    }
}
