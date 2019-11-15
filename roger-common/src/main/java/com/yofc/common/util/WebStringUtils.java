package com.yofc.common.util;

import org.apache.commons.lang3.StringUtils;

public class WebStringUtils {

    public static String formatTextDecode(String inStr){
        inStr = new String(org.apache.commons.codec.binary.Base64.decodeBase64(inStr));
        inStr = StringUtils.replace(inStr, "\\n", "<br>");
        inStr = StringUtils.replace(inStr, "\\r\\n", "<br>");
        return inStr;
    }

}
