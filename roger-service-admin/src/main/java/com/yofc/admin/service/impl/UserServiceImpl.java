package com.yofc.admin.service.impl;

import com.yofc.admin.service.UserService;
import com.yofc.dal.admin.entity.WechatUser;
import com.yofc.dal.admin.entity.WechatUserExample;
import com.yofc.dal.admin.mapper.WechatUserMapperExt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private WechatUserMapperExt wechatUserMapperExt;

    @Override
    @Cacheable(value = "cache.wexin.user.map", key = "#userId")
    public Map<String, Object> getUserLogin(String userId){
        List<Map<String, Object>> users = wechatUserMapperExt.queryById(userId);
        if(users != null && users.size()>0){
            //TODO do something for token
            return users.get(0);
        }
        return null;
    }

    @Override
    @Cacheable(value = "cache.wexin.user", key = "#userId")
    public WechatUser getUser(String userId){
        WechatUserExample example = new WechatUserExample();
        example.createCriteria().andUserIdEqualTo(Integer.valueOf(userId));
        List<WechatUser> list = wechatUserMapperExt.selectByExample(example);
        if(list.isEmpty()){
            return null;
        }
        return list.get(0);
    }

}
