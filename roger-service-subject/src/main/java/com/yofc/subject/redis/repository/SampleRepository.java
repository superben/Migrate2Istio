package com.yofc.subject.redis.repository;

import com.yofc.subject.redis.entity.SampleUser;
import org.springframework.data.repository.CrudRepository;

public interface SampleRepository extends CrudRepository<SampleUser, String> {
}
