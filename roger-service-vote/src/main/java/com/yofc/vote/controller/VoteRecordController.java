package com.yofc.vote.controller;

import com.github.pagehelper.PageInfo;
import com.yofc.common.bean.MessageJson;
import com.yofc.dal.vote.entity.VoteRecord;
import com.yofc.vote.service.VoteDetailService;
import com.yofc.vote.service.VoteRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/vote/voteRecord")
public class VoteRecordController{

    @Autowired
    private VoteDetailService voteDetailService;
    
    @Autowired
    private VoteRecordService voteRecordService;

    /**
     * 查询投票
     * @param
     * @return
     */
    @ResponseBody
    @PostMapping(value= "/{voteId}",  produces = {"application/json;charset=UTF-8"})
    public MessageJson detail(@PathVariable("voteId") Integer voteId, @RequestBody Map<String, Object> param)  {
        MessageJson message = new MessageJson();
        try{
            voteDetailService.saveVoteRecord(voteId, param);
            message.setSuccess(true);
            message.setMsg(MessageJson.SUCCESS);
        }catch (Exception ex){
            message.setMsg(ex.getMessage());
            message.setSuccess(false);
            ex.printStackTrace();
        }
        return message;
    }


    @ResponseBody
    @GetMapping(value= "/{voteId}/{userId}",  produces = {"application/json;charset=UTF-8"})
    public MessageJson queryFilledVote(@PathVariable("voteId") Integer voteId, @PathVariable("userId") String userId)  {
        MessageJson message = new MessageJson();
        try{
            Map<String, Object> data = voteDetailService.queryFilledVote(voteId, userId);
            message.setData(data);
            message.setSuccess(true);
            message.setMsg(MessageJson.SUCCESS);
        }catch (Exception ex){
            message.setMsg(ex.getMessage());
            message.setSuccess(false);
            ex.printStackTrace();
        }
        return message;
    }

    @ResponseBody
    @GetMapping(value= "/{voteId}",  produces = {"application/json;charset=UTF-8"})
    public MessageJson queryEmptyVote(@PathVariable("voteId") Integer voteId)  {
        MessageJson message = new MessageJson();
        try{
            Map<String, Object> data = voteDetailService.queryEmptyVote(voteId);
            message.setData(data);
            message.setSuccess(true);
            message.setMsg(MessageJson.SUCCESS);
        }catch (Exception ex){
            message.setMsg(ex.getMessage());
            message.setSuccess(false);
            ex.printStackTrace();
        }
        return message;
    }

    @ResponseBody
    @GetMapping(value= "/history/{voteId}/{pageNumber}",  produces = {"application/json;charset=UTF-8"})
    public MessageJson queryEmptyVote(@PathVariable("voteId") Integer voteId, @PathVariable("pageNumber") Integer pageNumber)  {
        MessageJson message = new MessageJson();
        try{
            PageInfo<Map<String, Object>> data = voteRecordService.selectHistory(voteId, pageNumber, 20);
            message.setData(data);
            message.setSuccess(true);
            message.setMsg(MessageJson.SUCCESS);
        }catch (Exception ex){
            message.setMsg(ex.getMessage());
            message.setSuccess(false);
            ex.printStackTrace();
        }
        return message;
    }

    @ResponseBody
    @GetMapping(value= "/summary/{voteId}",  produces = {"application/json;charset=UTF-8"})
    public MessageJson summary(@PathVariable("voteId") Integer voteId)  {
        MessageJson message = new MessageJson();
        try{
            List<Map<String, Object>> data = voteDetailService.countVoteSubject4Summary(voteId);
            message.setData(data);
            message.setSuccess(true);
            message.setMsg(MessageJson.SUCCESS);
        }catch (Exception ex){
            message.setMsg(ex.getMessage());
            message.setSuccess(false);
            ex.printStackTrace();
        }
        return message;
    }


    @GetMapping(value = "/others/{voteId}/{voteSubjectId}/{pageNum}")
    @ResponseBody
    public MessageJson others(@PathVariable("voteId") Integer voteId, @PathVariable("voteSubjectId") Integer voteSubjectId, @PathVariable("pageNum") Integer pageNum){
        MessageJson message = new MessageJson();
        try{
            PageInfo<VoteRecord> data = voteRecordService.selectOthers(voteId, voteSubjectId, pageNum, 20);
            message.setData(data);
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
