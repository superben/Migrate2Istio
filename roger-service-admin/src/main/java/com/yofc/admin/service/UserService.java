package com.yofc.admin.service;

import com.yofc.dal.admin.entity.WechatUser;

import java.util.Map;

public interface UserService {

    Map<String, Object> getUserLogin(String userId);

    WechatUser getUser(String userId);
}
