package com.ngs.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ngs.entity.Application;

public class StringUtil {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    public static String nvl(String str, String valueIfNull) {
        return str != null ? str : valueIfNull;
    }

    public static String toJsonString(Object object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
