package com.yofc.vote.controller.outward;

import com.yofc.common.bean.MessageJson;
import com.yofc.vote.remote.SampleRemoteService;
import com.yofc.vote.remote.SubjectFromRemoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/vote/public/sample")
public class SampleController {

    @Autowired
    private SampleRemoteService sampleRemoteService;

    @Autowired
    private SubjectFromRemoteService subjectFromRemoteService;

    @RequestMapping("/status")
    public String status(){
        return "roger-service-vote is running";
    }

    @RequestMapping("/subject_status")
    public String subjectStatus(){
        return sampleRemoteService.getStatus();
    }

    @ResponseBody
    @GetMapping(value= "/subject/from/{subjectId}",  produces = {"application/json;charset=UTF-8"})
    public MessageJson findBySubjectId(@PathVariable("subjectId") Integer subjectId){
        return subjectFromRemoteService.findBySubjectId(subjectId);
    }
}
