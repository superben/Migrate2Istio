package com.yofc.subject.redis.util;

public class RedisIdsUtils {

    public static String getSubjectSummaryId(Integer objectId){
        return "subject_summary_" + objectId;
    }

}
