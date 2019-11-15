package com.yofc.subject.service;

import com.yofc.common.bean.ValidationException;
import com.yofc.dal.subject.entity.SubjectFrom;
import com.yofc.dal.vote.entity.Vote;
import com.yofc.common.enums.ActionsType;
import org.springframework.cache.annotation.Cacheable;

public interface SubjectFromService {

    @Cacheable(value = "cache.voteFrom.subject.bean", key = "#id")
    SubjectFrom findBySubjectId(Integer id);

    SubjectFrom findVoteId(Integer id);

    void saveCbSubject(Vote vote, ActionsType type);

    void deleteSubjectByVoteId(Integer voteId) throws ValidationException;
}
