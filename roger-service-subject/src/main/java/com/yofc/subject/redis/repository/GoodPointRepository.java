package com.yofc.subject.redis.repository;

import com.yofc.subject.redis.entity.GoodPointAmount;
import org.springframework.data.repository.CrudRepository;

public interface GoodPointRepository extends CrudRepository<GoodPointAmount, String> {
}
