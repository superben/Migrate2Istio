package com.yofc.vote.controller;

import com.github.pagehelper.PageInfo;
import com.yofc.common.bean.MessageJson;
import com.yofc.framework.config.WebConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

public abstract class BaseController {

    @Autowired
    private WebConfig webConfig;

    /**
     * 查询所有投票主题
     * @param pageNum pageNum
     * @param queryParam queryParam
     * @return MessageJson
     */
    @PostMapping(value = "list/{pageNum}")
    @ResponseBody
    public MessageJson list(@PathVariable("pageNum") Integer pageNum, @RequestBody Map<String, Object> queryParam){
        MessageJson message = new MessageJson();
        try{
            if(pageNum < 1){
                pageNum = 1;
            }
            Map<String, Object> finalRs = new HashMap<>();
            PageInfo<Map<String, Object>> rs = listQuery(queryParam, pageNum, webConfig.getPageSize());
            listOther(message, queryParam, rs);
            finalRs.put("pageObj", rs);
            message.setData(rs);
            message.setSuccess(true);
            message.setMsg(MessageJson.SUCCESS);
        }catch (Exception ex){
            message.setMsg("查询投票接口异常！" + ex.getMessage());
            message.setSuccess(false);
            ex.printStackTrace();
        }
        return message;
    }

    abstract PageInfo<Map<String, Object>> listQuery(Map<String, Object> queryParam, Integer pageNum, Integer pageSize);

    abstract void listOther(MessageJson message, Map<String, Object> queryParam, PageInfo<Map<String, Object>> rs);
}
