package com.yofc.subject.remote;

import com.yofc.common.bean.MessageJson;
import com.yofc.subject.remote.impl.UserRemoteHystrixServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@FeignClient(name = "roger-service-admin", fallback = UserRemoteHystrixServiceImpl.class, url = "${feign.adminServiceUrl}")
public interface UserRemoteService {

    @ResponseBody
    @GetMapping(value = "/api/admin/public/user/{userId}", produces = {"application/json;charset=UTF-8"})
    MessageJson getUser(@PathVariable("userId") String userId);

}
