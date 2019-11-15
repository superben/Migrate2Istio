package com.yofc.vote.remote.impl;

import com.yofc.vote.remote.SampleRemoteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class SampleRemoteHystrixServiceImpl implements SampleRemoteService {

    private static final Logger log = LoggerFactory.getLogger(SampleRemoteHystrixServiceImpl.class);

    @Override
    public String getStatus() {
        log.error("【roger】【Hystrix】/api/subject/public/sample/status");
        return "【roger】【vote module call subject module】【Hystrix】/api/subject/public/sample/status";
    }

}
