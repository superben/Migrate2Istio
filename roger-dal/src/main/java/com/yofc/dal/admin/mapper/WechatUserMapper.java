package com.yofc.dal.admin.mapper;

import com.yofc.dal.admin.entity.WechatUser;
import com.yofc.dal.admin.entity.WechatUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WechatUserMapper {
    long countByExample(WechatUserExample example);

    int deleteByExample(WechatUserExample example);

    int deleteByPrimaryKey(Integer userId);

    int insert(WechatUser record);

    int insertSelective(WechatUser record);

    List<WechatUser> selectByExample(WechatUserExample example);

    WechatUser selectByPrimaryKey(Integer userId);

    int updateByExampleSelective(@Param("record") WechatUser record, @Param("example") WechatUserExample example);

    int updateByExample(@Param("record") WechatUser record, @Param("example") WechatUserExample example);

    int updateByPrimaryKeySelective(WechatUser record);

    int updateByPrimaryKey(WechatUser record);
}