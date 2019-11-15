package com.yofc.subject.remote.impl;

import com.yofc.subject.remote.SampleRemoteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class SampleRemoteHystrixServiceImpl implements SampleRemoteService {

    private static final Logger log = LoggerFactory.getLogger(SampleRemoteHystrixServiceImpl.class);

    @Override
    public String getStatus() {
        log.error("【roger】【Hystrix】/api/admin/public/sample/status");
        return "【Hystrix】【subject module call admin module】 /api/admin/public/sample/status";
    }

}
