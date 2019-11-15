package com.yofc.admin.service;

import com.yofc.common.enums.NitificationTypeEnum;
import com.yofc.dal.subject.entity.Task;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface PushSubjectTaskService {

    List<Task> doTaskDelegate(List<Task> taskList);

    public ResponseEntity<String> send(Map<String, Object> requestBody, NitificationTypeEnum type);
}
