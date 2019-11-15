package com.yofc.dal.admin.mapper;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Resource
public interface WechatUserMapperExt extends WechatUserMapper {
    List<Map<String, Object>> queryById(String userId);
}