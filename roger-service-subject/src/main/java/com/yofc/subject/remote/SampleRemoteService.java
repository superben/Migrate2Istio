package com.yofc.subject.remote;

import com.yofc.subject.remote.impl.SampleRemoteHystrixServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@FeignClient(name = "roger-service-admin", fallback = SampleRemoteHystrixServiceImpl.class, url = "${feign.adminServiceUrl}")
public interface SampleRemoteService {

    @ResponseBody
    @GetMapping(value = "/api/admin/public/sample/status", produces = {"application/json;charset=UTF-8"})
    String getStatus();

}