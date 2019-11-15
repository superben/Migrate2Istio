package com.yofc.subject.redis.service;

import com.yofc.dal.subject.entity.SubjectReadLog;
import com.yofc.subject.redis.entity.SubjectReadAmount;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface ISubjectReadRedisService {

    @Autowired
    /**
     * 加载所有主题 阅读数，后续阅读次数再redis中完成计算
     * */
    void initSubjectReadAmount();

    void save(SubjectReadLog log);

    void saveToRedis(SubjectReadLog log);

    void updateAmount(Integer objectId, String type, int num);

    void saveSubjectReadLogFromRedis();

    SubjectReadAmount countAction(Integer subjectId);

    List<SubjectReadAmount> summary(Integer objectId);

}
