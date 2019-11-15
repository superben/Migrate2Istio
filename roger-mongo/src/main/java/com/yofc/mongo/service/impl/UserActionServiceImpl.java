package com.yofc.mongo.service.impl;

import com.yofc.mongo.entity.UserActionLog;
import com.yofc.mongo.repository.UserActionLogRepository;
import com.yofc.mongo.service.UserActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

@Service
public class UserActionServiceImpl implements UserActionService {

    @Autowired
    private UserActionLogRepository userActionLogRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void saveUserAction(UserActionLog log){
        userActionLogRepository.save(log);
    }

    @Override
    public long countAction(Integer subjectId){
        //TODO 此处有性能问题， 后续调优
        return mongoTemplate.count(Query.query(Criteria.where("keyCol").is(subjectId)), UserActionLog.class);
    }

}
