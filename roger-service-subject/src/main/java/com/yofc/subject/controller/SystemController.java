package com.yofc.subject.controller;

import com.yofc.common.bean.MessageJson;
import com.yofc.dal.subject.entity.SubjectReadLog;
import com.yofc.subject.redis.entity.SubjectReadAmount;
import com.yofc.subject.redis.service.ISubjectReadRedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/subject/sys")
public class SystemController {

    @Autowired
    private ISubjectReadRedisService subjectReadService;

    @PostMapping(value = "/action/log", produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public MessageJson userInfo(@RequestBody SubjectReadLog subjectReadLog) {
        MessageJson message = new MessageJson();
        try {
            subjectReadService.saveToRedis(subjectReadLog);
            message.setData(null);
            message.setSuccess(true);
            message.setMsg(MessageJson.SUCCESS);
        } catch (Exception ex) {
            message.setMsg("登录接口异常！" + ex.getMessage());
            message.setSuccess(false);
            ex.printStackTrace();
        }
        return message;
    }

    @GetMapping(value = "/action/log/summary", produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public MessageJson summary(@RequestParam("objectId") Integer objectId) {
        MessageJson message = new MessageJson();
        try {
            List<SubjectReadAmount> data = subjectReadService.summary(objectId);
            message.setData(data);
            message.setSuccess(true);
            message.setMsg(MessageJson.SUCCESS);
        } catch (Exception ex) {
            message.setMsg("登录接口异常！" + ex.getMessage());
            message.setSuccess(false);
            ex.printStackTrace();
        }
        return message;
    }
}
