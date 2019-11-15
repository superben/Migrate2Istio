package com.yofc.subject.controller;

import com.github.pagehelper.PageInfo;
import com.yofc.common.bean.BusinessException;
import com.yofc.common.bean.MessageJson;
import com.yofc.subject.config.WebConfig;
import com.yofc.dal.subject.entity.SubjectFollowReply;
import com.yofc.subject.service.SubjectReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping(value = "/api/subject/reply")
public class ReplyController {

    @Autowired
    private WebConfig webConfig;

    @Autowired
    private SubjectReplyService subjectReplyService;


    /**
     * 查询所有跟帖
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
            PageInfo<Map<String, Object>> replys = subjectReplyService.list(queryParam, pageNum, webConfig.getPageSize());
            message.setData(replys);
            message.setSuccess(true);
            message.setMsg(MessageJson.SUCCESS);
        }catch (Exception ex){
            message.setMsg("查询主题接口异常！" + ex.getMessage());
            message.setSuccess(false);
            ex.printStackTrace();
        }
        return message;
    }

    /**
     * 新增回复
     * @param bean
     * @return
     */
    @ResponseBody
    @PostMapping(value= "",  produces = {"application/json;charset=UTF-8"})
    public MessageJson save(@RequestBody SubjectFollowReply bean)  {
        MessageJson message = new MessageJson();
        try{
            subjectReplyService.insertSelectiveExt(bean);
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
     * NOT USED
     * 修改回复
     * @param replyId replyId
     * @param bean bean
     * @return
     */
    @PostMapping(value= "/{replyId}", produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public MessageJson updateReply(@PathVariable("replyId") Integer replyId, @RequestBody SubjectFollowReply bean)  {
        MessageJson message = new MessageJson();
        try{
            bean.setFollowId(replyId);
            subjectReplyService.updateReply(bean);
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
     * 删除回复
     * @param subjectFollowReply subjectFollowReply
     * @return
     */
    @ResponseBody
    @PostMapping(value= "/d", produces = {"application/json;charset=UTF-8"})
    public MessageJson deleteReply(@RequestBody SubjectFollowReply subjectFollowReply)  {
        MessageJson message = new MessageJson();
        try{
            if(subjectFollowReply == null || subjectFollowReply.getReplyId() == null){
                throw new BusinessException("replyId is Required");
            }
            subjectReplyService.deleteByReplyId(subjectFollowReply.getReplyId());
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
