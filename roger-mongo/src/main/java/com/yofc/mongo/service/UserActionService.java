package com.yofc.mongo.service;


import com.yofc.mongo.entity.UserActionLog;

public interface UserActionService {

    void saveUserAction(UserActionLog logs);

    long countAction(Integer subjectId);
}
