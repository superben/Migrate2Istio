package com.yofc.common.util;

import org.apache.commons.collections4.MapUtils;
import org.springframework.util.StringUtils;

import java.util.Map;

public class CommonMapUtils {

    public static <K> Boolean isBlankByKey(Map<? super K, ?> map, K key){
        String obj =  MapUtils.getString(map, key);
        if(obj == null){
            return true;
        }
        if(StringUtils.isEmpty(obj)){
            return true;
        }
        return false;
    }
}
