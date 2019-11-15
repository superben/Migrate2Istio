package com.yofc.vote.remote;

import com.yofc.common.bean.MessageJson;
import com.yofc.common.bean.ValidationException;
import com.yofc.dal.vote.entity.Vote;
import com.yofc.vote.remote.impl.SubjectFromRemoteHystrixServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@FeignClient(name= "roger-service-subject", fallback = SubjectFromRemoteHystrixServiceImpl.class, url = "${feign.subjectServiceUrl}")
public interface SubjectFromRemoteService {

    @ResponseBody
    @GetMapping(value= "/api/subject/public/subject/from/{subjectId}",  produces = {"application/json;charset=UTF-8"})
    MessageJson findBySubjectId(@PathVariable("subjectId") Integer subjectId);

    @ResponseBody
    @PostMapping(value= "/api/subject/public/subject",  produces = {"application/json;charset=UTF-8"})
    MessageJson saveCbSubject(Vote vote);

    @ResponseBody
    @PostMapping(value= "/api/subject/public/subject/d/{voteId}",  produces = {"application/json;charset=UTF-8"})
    MessageJson deleteSubjectByVoteId(@PathVariable("voteId") Integer voteId) throws ValidationException;
}
