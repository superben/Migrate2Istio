package com.yofc.mongo.repository;

import com.yofc.mongo.entity.UserActionLog;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface  UserActionLogRepository extends MongoRepository<UserActionLog, Long> {

}
