package com.yofc.subject.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.yofc.common.util.CommonMapUtils;
import com.yofc.dal.subject.entity.Task;
import com.yofc.common.enums.NitificationTypeEnum;
import com.yofc.common.enums.TaskScheduledStatusEnum;
import com.yofc.dal.subject.mapper.SubjectMapperExt;
import com.yofc.subject.properties.WeXinMessageProperty;
import com.yofc.subject.service.AbstractTaskService;
import com.yofc.subject.service.PushSubjectTaskService;
import org.apache.commons.collections4.MapUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Service
public class PushSubjectTaskServiceImpl extends AbstractTaskService implements PushSubjectTaskService {

    protected static final Logger logger = LoggerFactory.getLogger(PushSubjectTaskServiceImpl.class);

    @Autowired
    private SubjectMapperExt subjectMapperExt;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private WeXinMessageProperty weXinMessageProperty;

    @Override
    public List<Task> doTaskDelegate(List<Task> taskList) {
        for (Task task : taskList) {
            Map<String, Object> requestBody = (Map<String, Object>) JSONObject.parse(task.getRequestBody());
            try{
                if(!beforeDoTaskDelegate(requestBody, task)){
                    return taskList;
                }
                if(weXinMessageProperty.getDebug()){
                    task.setStatus(TaskScheduledStatusEnum.debug.name());
                    task.setRemark("debug");
                    return taskList;
                }
                logger.info("[push subject] begin to push subject. subjectId" + requestBody.get("subjectId"));
                ResponseEntity<String> response = send(requestBody, NitificationTypeEnum.all);
                if(response.getStatusCode().value() == 200){
                    task.setStatus(TaskScheduledStatusEnum.success.name());
                }else{
                    task.setStatus(TaskScheduledStatusEnum.fail.name());
                }
                task.setRemark(response.getBody());
            }catch (Exception ex){
                logger.error("[push subject] fail. subjectId" + MapUtils.getInteger(requestBody, "keyProperty"));
                ex.printStackTrace();
                task.setStatus(TaskScheduledStatusEnum.fail.name());
                task.setRemark(ex.getMessage());
            }
        }
        return taskList;
    }

    @Override
    public ResponseEntity<String> send(Map<String, Object> requestBody, NitificationTypeEnum type){
        try{
            requestBody.put("url", weXinMessageProperty.getWeburl() + requestBody.get("url"));
            logger.debug("[push subject] " + JSONObject.toJSONString(requestBody));
            String url = type.name().equals(NitificationTypeEnum.dept.name()) ? weXinMessageProperty.getRemoteUrl4Dept() : weXinMessageProperty.getRemoteUrl();
            if(weXinMessageProperty.getDebug()){
                logger.info("[wei xin] send message in debug mode." + JSONObject.toJSONString(requestBody));
                return null;
            }
            return restTemplate.getForEntity(url, String.class, requestBody);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    protected boolean beforeDoTaskDelegate(Map<String, Object> requestBody, Task task){
        if(CommonMapUtils.isBlankByKey(requestBody, "userid")){
            task.setStatus(TaskScheduledStatusEnum.termination.name());
            task.setRemark("userid is required");
            return false;
        }else if(CommonMapUtils.isBlankByKey(requestBody, "title")){
            task.setStatus(TaskScheduledStatusEnum.termination.name());
            task.setRemark("title is required");
            return false;
        }else if(CommonMapUtils.isBlankByKey(requestBody, "description")){
            task.setStatus(TaskScheduledStatusEnum.termination.name());
            task.setRemark("description is required");
            return false;
        }else if(CommonMapUtils.isBlankByKey(requestBody, "url")){
            task.setStatus(TaskScheduledStatusEnum.termination.name());
            task.setRemark("url is required");
            return false;
        }
        logger.info("[push subject] " + weXinMessageProperty.getWeburl() + requestBody.get("url"));
        return  true;
    }
}
