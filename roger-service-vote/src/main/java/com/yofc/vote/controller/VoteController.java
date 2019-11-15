package com.yofc.vote.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageInfo;
import com.yofc.common.bean.MessageJson;
import com.yofc.framework.config.WebConfig;
import com.yofc.dal.subject.entity.SubjectFrom;
import com.yofc.dal.vote.entity.VoteRecord;
import com.yofc.vote.remote.SubjectFromRemoteService;
import com.yofc.vote.service.VoteDetailService;
import com.yofc.vote.service.VoteRecordService;
import com.yofc.vote.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/vote")
public class VoteController extends BaseController{

    @Autowired
    private WebConfig webConfig;

    @Autowired
    private VoteService voteService;

    @Autowired
    private VoteDetailService voteDetailService;

    @Autowired
    private SubjectFromRemoteService subjectFromRemoteService;

    @Autowired
    private VoteRecordService voteRecordService;

    PageInfo<Map<String, Object>> listQuery(Map<String, Object> queryParam, Integer pageNum, Integer pageSize){
        return voteService.list(queryParam, pageNum, webConfig.getPageSize());
    }

    @Override
    void listOther(MessageJson message, Map<String, Object> queryParam, PageInfo<Map<String, Object>> rs) {

    }

    /**
     * 新增投票
     * @param
     * @return
     */
    @ResponseBody
    @PostMapping(value= "",  produces = {"application/json;charset=UTF-8"})
    public MessageJson save(@RequestBody Map<String, Object> param)  {
        MessageJson message = new MessageJson();
        try{
            voteService.save(param);
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
    @GetMapping(value= "/emptyVote/{voteId}",  produces = {"application/json;charset=UTF-8"})
    public MessageJson getVote(@PathVariable("voteId") Integer voteId)  {
        MessageJson message = new MessageJson();
        try{
            Map<String, Object> result = voteDetailService.queryEmptyVote(voteId);
            message.setData(result);
            message.setSuccess(true);
            message.setMsg(MessageJson.SUCCESS);
        }catch (Exception ex){
            message.setMsg(ex.getMessage());
            message.setSuccess(false);
            ex.printStackTrace();
        }
        return message;
    }

    /**
     * 查询投票
     * @param
     * @return
     */
    @ResponseBody
    @PostMapping(value= "/detail/{voteId}",  produces = {"application/json;charset=UTF-8"})
    public MessageJson detail(@PathVariable("voteId") Integer voteId, @RequestBody Map<String, Object> param)  {
        MessageJson message = new MessageJson();
        try{
            Map<String, Object> rs = voteService.queryDetail(voteId, param);
            message.setData(rs);
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
    @GetMapping(value= "/shortSummary/{subjectId}/{userId}",  produces = {"application/json;charset=UTF-8"})
    public MessageJson shortSummary(@PathVariable("subjectId") Integer subjectId, @PathVariable("userId") String userId)  {
        MessageJson message = new MessageJson();
        try{
            Map<String, Object> result = new HashMap<>();
            ObjectMapper mapper = new ObjectMapper();
            SubjectFrom from = mapper.convertValue(subjectFromRemoteService.findBySubjectId(subjectId).getData(), SubjectFrom.class);
            if(from != null){
                result.put("vote", voteService.findByKeys(from.getKeyId()));
                result.put("list", voteService.countVoteSubject4Summary(from.getKeyId()));
                List<VoteRecord> records = voteRecordService.queryVoteRecordDetail(from.getKeyId(), userId);
                result.put("hadVote", !records.isEmpty());
            }else{
                result.put("hadVote", false);
            }
            message.setData(result);
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
    @PostMapping(value= "/d/{voteId}",  produces = {"application/json;charset=UTF-8"})
    public MessageJson shortSummary(@PathVariable("voteId") Integer voteId, @RequestBody Map<String, Object> param)  {
        MessageJson message = new MessageJson();
        try{
            voteService.delteVoteAndSubject(voteId);
            message.setData(null);
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
