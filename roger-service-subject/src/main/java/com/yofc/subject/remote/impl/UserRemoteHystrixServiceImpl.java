package com.yofc.subject.remote.impl;

import com.yofc.common.bean.MessageJson;
import com.yofc.subject.remote.UserRemoteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class UserRemoteHystrixServiceImpl implements UserRemoteService {

    private static final Logger log = LoggerFactory.getLogger(UserRemoteHystrixServiceImpl.class);

    @Override
    public MessageJson getUser(String userId) {
        MessageJson messageJson = new MessageJson();
        log.error("【roger】【Hystrix】/api/admin/public/user/{userId}");
        messageJson.setMsg("error remote call");
        messageJson.setSuccess(false);
        messageJson.setData("【Hystrix】/api/admin/public/user/{userId}");
        return messageJson;
    }
}
