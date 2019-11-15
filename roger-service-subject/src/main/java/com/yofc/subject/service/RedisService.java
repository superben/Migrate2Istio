package com.yofc.subject.service;

public interface RedisService<T> {

    T findByKeys(Integer id);

    long countByParent(Integer id);

    T save(T bean);

    T update(T bean);

    void delete(T bean);

}
