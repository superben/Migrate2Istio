package com.yofc.mongo;


import com.yofc.dal.subject.entity.SubjectReadLog;
import com.yofc.dal.subject.mapper.SubjectReadLogMapperExt;
import com.yofc.mongo.entity.UserActionLog;
import com.yofc.mongo.repository.UserActionLogRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
@Component
public class SyncUserActionLogsTest {

    @Autowired
    private UserActionLogRepository userActionLogRepository;

    @Autowired
    private SubjectReadLogMapperExt subjectReadLogMapperExt;

    @Test
    public void testSyncData(){
        List<UserActionLog> list = userActionLogRepository.findAll();
        int i = 0;
        for(UserActionLog ua : list){
            i++;
            System.out.println(i);
            SubjectReadLog bean = new SubjectReadLog();
            bean.setObjectId(ua.getKeyCol());
            bean.setKeyCol(ua.getKeyCol());
            bean.setEnterDate(ua.getEnterDate());
            bean.setOutDate(ua.getOutDate());
            bean.setUserId(Integer.valueOf(ua.getUserId()));
            bean.setUserName(ua.getUserName());
            bean.setExtStr1(ua.getId().toString());
            subjectReadLogMapperExt.insertSelectiveExt(bean);
        }
    }

}
