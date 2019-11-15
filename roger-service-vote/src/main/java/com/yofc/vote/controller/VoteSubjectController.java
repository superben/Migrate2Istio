package com.yofc.vote.controller;

import com.github.pagehelper.PageInfo;
import com.yofc.common.bean.MessageJson;
import com.yofc.framework.config.WebConfig;
import com.yofc.dal.vote.entity.Vote;
import com.yofc.vote.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(value = "/api/vote/voteSubject")
public class VoteSubjectController extends BaseController{

    @Autowired
    private WebConfig webConfig;

    @Autowired
    private VoteService voteSubjectService;

    PageInfo<Map<String, Object>> listQuery(Map<String, Object> queryParam, Integer pageNum, Integer pageSize){
        return voteSubjectService.list(queryParam, pageNum, webConfig.getPageSize());
    }

    @Override
    void listOther(MessageJson message, Map<String, Object> queryParam, PageInfo<Map<String, Object>> rs) {

    }

    /**
     * 新增投票主题
     * @param bean
     * @return
     */
    @ResponseBody
    @PostMapping(value= "",  produces = {"application/json;charset=UTF-8"})
    public MessageJson save(@RequestBody Vote bean)  {
        MessageJson message = new MessageJson();
        try{
            voteSubjectService.save(bean);
            message.setSuccess(true);
            message.setMsg(MessageJson.SUCCESS);
        }catch (Exception ex){
            message.setMsg(ex.getMessage());
            message.setSuccess(false);
            ex.printStackTrace();
        }
        return message;
    }

}
