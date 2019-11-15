package com.yofc.subject.controller;

import com.github.pagehelper.PageInfo;
import com.yofc.common.bean.MessageJson;
import com.yofc.subject.config.WebConfig;
import com.yofc.subject.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(value = "/api/subject/message")
public class MessageController {

    @Autowired
    private WebConfig webConfig;

    @Autowired
    private MessageService messageService;

    @PostMapping(value = "/list/{pageNum}")
    @ResponseBody
    public MessageJson list(@PathVariable("pageNum") Integer pageNum, @RequestBody Map<String, Object> queryParam){
        MessageJson message = new MessageJson();
        try{
            if(pageNum < 1){
                pageNum = 1;
            }
            PageInfo<Map<String, Object>> list = messageService.list(queryParam, pageNum, webConfig.getPageSize());
            message.setData(list);
            message.setSuccess(true);
            message.setMsg(MessageJson.SUCCESS);
        }catch (Exception ex){
            message.setMsg("查询主题接口异常！" + ex.getMessage());
            message.setSuccess(false);
            ex.printStackTrace();
        }
        return message;
    }

    /*@ResponseBody
    @PostMapping(value= "/",  produces = {"application/json;charset=UTF-8"})
    public MessageJson saveMessage(@RequestBody Message bean){
        MessageJson message = new MessageJson();
        try{
            if(jmsConfig.isEnable()){
                messageService.insertSelectiveExt(bean);
            }else{
                messageService.insertSelectiveExt(bean);
            }
            message.setSuccess(true);
            message.setMsg(MessageJson.SUCCESS);
        }catch (Exception ex){
            message.setMsg(ex.getMessage());
            message.setSuccess(false);
            ex.printStackTrace();
        }
        return message;
    }*/

    @ResponseBody
    @PostMapping(value= "/{msgId}",  produces = {"application/json;charset=UTF-8"})
    public MessageJson updateMessage(@PathVariable("msgId") Integer msgId){
        MessageJson message = new MessageJson();
        try{
            messageService.updateReadable(msgId);
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
    @PostMapping(value= "/u/{userId}",  produces = {"application/json;charset=UTF-8"})
    public MessageJson countMessage(@PathVariable("userId") String userId){
        MessageJson message = new MessageJson();
        try{
            Long hasNewMessage = messageService.countMessage(userId);
            message.setData(hasNewMessage);
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
