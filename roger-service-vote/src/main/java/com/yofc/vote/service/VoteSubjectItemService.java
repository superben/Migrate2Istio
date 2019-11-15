package com.yofc.vote.service;

import com.yofc.dal.vote.entity.VoteSubjectItem;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

public interface VoteSubjectItemService {
    void saveOrUpdate(VoteSubjectItem voteSubjectItem);

    @Cacheable(value = "cache.voteSubjectItem.list", key = "#pid")
    List<VoteSubjectItem> findByParentKeys(Integer pid);

    void deleteOthers(Integer subjectId);
}
