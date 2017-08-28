package com.dzr.common.util;

import org.apache.commons.lang3.StringUtils;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class KeyUtils {
    private static final Pattern pattern = Pattern.compile("(?<=\\$\\{).*?(?=\\})");
    private static final String regex = "\\$\\{|\\}";

    public static String replaceKey(String tmpl, Map<String, String> param) {
        Matcher m = pattern.matcher(tmpl);
        String buffer = tmpl;
        while (m.find()) {
            String macherParamKey = m.group(0);
            String value = param.get(macherParamKey);
            buffer = StringUtils.replace(buffer, macherParamKey, value).intern();
        }
        return buffer.replaceAll(regex, "").intern();
    }

}
