package com.ngs.util;

public class StringUtil {

    public static boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    public static String nvl(String str, String valueIfNull) {
        return str != null ? str : valueIfNull;
    }
}
