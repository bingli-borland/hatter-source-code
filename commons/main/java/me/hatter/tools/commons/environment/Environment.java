package me.hatter.tools.commons.environment;

import java.util.ArrayList;
import java.util.List;

import me.hatter.tools.commons.log.LogUtil;

public class Environment {

    public static final String DEFAULT_SEPARATER = ",";

    public static final String USER_DIR          = System.getProperty("user.dir");
    public static final String USER_NAME         = System.getProperty("user.name");
    public static final String USER_HOME         = System.getProperty("user.home");

    // File separator ("/" on UNIX)
    public static final String FILE_SEPARATOR    = System.getProperty("file.separator");
    // Path separator (":" on UNIX)
    public static final String PATH_SEPARATOR    = System.getProperty("path.separator");
    // Line separator ("\n" on UNIX)
    public static final String LINE_SEPARATOR    = System.getProperty("line.separator");

    public static String getStrPropertyOrDie(String key) {
        String value = System.getProperty(key);
        if (value == null) {
            LogUtil.error("Property not exists: " + key);
            System.exit(-1);
        }
        LogUtil.trace("Property " + key + " is: " + value);
        return value;
    }

    public static int getIntPropertyOrDie(String key) {
        return Integer.parseInt(getStrPropertyOrDie(key));
    }

    public long getLongPropertyOrDie(String key) {
        return Long.parseLong(getStrPropertyOrDie(key));
    }

    public double getDoublePropertyOrDie(String key) {
        return Double.parseDouble(getStrPropertyOrDie(key));
    }

    public boolean getBoolPropertyOrDie(String key) {
        return Boolean.parseBoolean(getStrPropertyOrDie(key));
    }

    public static List<String> getStrPropertyList(String key, List<String> defaultValue) {
        return getStrPropertyList(key, DEFAULT_SEPARATER, defaultValue);
    }

    public static List<String> getStrPropertyList(String key, String regexSeparater, List<String> defaultValue) {
        List<String> result = getInnerStrPropertyList(key, regexSeparater);
        result = (result == null) ? defaultValue : result;
        LogUtil.trace("Property list " + key + " is: " + result);
        return result;
    }

    public static List<Integer> getIntPropertyList(String key, List<Integer> defaultValue) {
        return getIntPropertyList(key, DEFAULT_SEPARATER, defaultValue);
    }

    public static List<Integer> getIntPropertyList(String key, String regexSeparater, List<Integer> defaultValue) {
        List<String> result = getInnerStrPropertyList(key, regexSeparater);
        List<Integer> intListResult = new ArrayList<Integer>();
        if (result != null) {
            for (String v : result) {
                try {
                    Integer i = Integer.valueOf(v);
                    intListResult.add(i);
                } catch (Exception e) {
                    throw new RuntimeException("Cannot parse property key/value: " + key + " / " + v + " of: " + result);
                }
            }
        }
        intListResult = intListResult.isEmpty() ? defaultValue : intListResult;
        LogUtil.trace("Property list " + key + " is: " + intListResult);
        return intListResult;
    }

    public static List<Long> getLongPropertyList(String key, List<Long> defaultValue) {
        return getLongPropertyList(key, DEFAULT_SEPARATER, defaultValue);
    }

    public static List<Long> getLongPropertyList(String key, String regexSeparater, List<Long> defaultValue) {
        List<String> result = getInnerStrPropertyList(key, regexSeparater);
        List<Long> longListResult = new ArrayList<Long>();
        if (result != null) {
            for (String v : result) {
                try {
                    Long l = Long.valueOf(v);
                    longListResult.add(l);
                } catch (Exception e) {
                    throw new RuntimeException("Cannot parse property key/value: " + key + " / " + v + " of: " + result);
                }
            }
        }
        longListResult = longListResult.isEmpty() ? defaultValue : longListResult;
        LogUtil.trace("Property list " + key + " is: " + longListResult);
        return longListResult;
    }

    public static List<Double> getDoublePropertyList(String key, List<Double> defaultValue) {
        return getDoublePropertyList(key, DEFAULT_SEPARATER, defaultValue);
    }

    public static List<Double> getDoublePropertyList(String key, String regexSeparater, List<Double> defaultValue) {
        List<String> result = getInnerStrPropertyList(key, regexSeparater);
        List<Double> doubleListResult = new ArrayList<Double>();
        if (result != null) {
            for (String v : result) {
                try {
                    Double d = Double.valueOf(v);
                    doubleListResult.add(d);
                } catch (Exception e) {
                    throw new RuntimeException("Cannot parse property key/value: " + key + " / " + v + " of: " + result);
                }
            }
        }
        doubleListResult = doubleListResult.isEmpty() ? defaultValue : doubleListResult;
        LogUtil.trace("Property list " + key + " is: " + doubleListResult);
        return doubleListResult;
    }

    public static String getStrProperty(String key, String defaultValue) {
        String value = System.getProperty(key);
        String s = (value == null) ? defaultValue : value;
        LogUtil.trace("Property " + key + " is: " + s);
        return s;
    }

    public static int getIntProperty(String key, int defaultValue) {
        String value = System.getProperty(key);
        int i = (value == null) ? defaultValue : Integer.parseInt(value);
        LogUtil.trace("Property " + key + " is: " + i);
        return i;
    }

    public static long getLongProperty(String key, long defaultValue) {
        String value = System.getProperty(key);
        long l = (value == null) ? defaultValue : Long.parseLong(value);
        LogUtil.trace("Property " + key + " is: " + l);
        return l;
    }

    public static double getDoubleProperty(String key, double defaultValue) {
        String value = System.getProperty(key);
        double d = (value == null) ? defaultValue : Double.parseDouble(value);
        LogUtil.trace("Property " + key + " is: " + d);
        return d;
    }

    public static boolean getBoolProperty(String key, boolean defaultValue) {
        String value = System.getProperty(key);
        boolean b = (value == null) ? defaultValue : Boolean.parseBoolean(value);
        LogUtil.trace("Property " + key + " is: " + b);
        return b;
    }

    private static List<String> getInnerStrPropertyList(String key, String regexSeparater) {
        String value = System.getProperty(key);
        if (value == null) {
            return null;
        }
        String[] vals = value.split(regexSeparater);
        List<String> result = new ArrayList<String>();
        for (String v : vals) {
            v = v.trim();
            if (!v.isEmpty()) {
                result.add(v);
            }
        }
        return result.isEmpty() ? null : result;
    }
}
