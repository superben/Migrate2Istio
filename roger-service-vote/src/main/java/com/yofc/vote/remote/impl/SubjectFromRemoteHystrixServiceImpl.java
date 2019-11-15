package com.yofc.vote.remote.impl;

import com.yofc.common.bean.MessageJson;
import com.yofc.common.bean.ValidationException;
import com.yofc.dal.vote.entity.Vote;
import com.yofc.vote.remote.SubjectFromRemoteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class SubjectFromRemoteHystrixServiceImpl implements SubjectFromRemoteService {

    private static final Logger log = LoggerFactory.getLogger(SubjectFromRemoteHystrixServiceImpl.class);

    @Override
    public MessageJson findBySubjectId(Integer subjectId) {
        log.error("【roger】【Hystrix】/api/subject/public/subject/from/{subjectId}");
        return null;
    }

    @Override
    public MessageJson saveCbSubject(Vote vote) {
        log.error("【roger】【Hystrix】/api/subject/public/subject");
        return null;
    }

    @Override
    public MessageJson deleteSubjectByVoteId(Integer voteId) throws ValidationException {
        log.error("【roger】【Hystrix】/d/{voteId}");
        return null;
    }
}
