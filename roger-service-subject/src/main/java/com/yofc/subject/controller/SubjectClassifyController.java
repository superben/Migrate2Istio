package com.yofc.subject.controller;

import com.yofc.common.bean.MessageJson;
import com.yofc.dal.subject.entity.SubjectClassify;
import com.yofc.subject.service.SubjectClassifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/api/subject/subjectClassify")
public class SubjectClassifyController {

    @Autowired
    private SubjectClassifyService subjectClassifyService;

    @ResponseBody
    @RequestMapping(value = "/all/{userId}", produces = {"application/json;charset=UTF-8"})
    public MessageJson list(@PathVariable("userId") String userId){
        MessageJson message = new MessageJson();
        try{
            List<SubjectClassify> classifies = subjectClassifyService.list(userId);
            message.setData(classifies);
            message.setSuccess(true);
            message.setMsg(MessageJson.SUCCESS);
        }catch (Exception ex){
            message.setMsg("查询社区异常！" + ex.getMessage());
            message.setSuccess(false);
            ex.printStackTrace();
        }
        return message;
    }

}
