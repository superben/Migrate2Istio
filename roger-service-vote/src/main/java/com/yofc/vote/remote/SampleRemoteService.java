package com.yofc.vote.remote;

import com.yofc.vote.remote.impl.SampleRemoteHystrixServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@FeignClient(name = "roger-service-subject", fallback = SampleRemoteHystrixServiceImpl.class, url = "${feign.subjectServiceUrl}")
public interface SampleRemoteService {

    @ResponseBody
    @GetMapping(value = "/api/subject/public/sample/status", produces = {"application/json;charset=UTF-8"})
    String getStatus();

}