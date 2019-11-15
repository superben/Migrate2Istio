package com.yofc.subject.controller.outward;

import com.yofc.subject.remote.SampleRemoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/subject/public/sample")
public class SampleController {

    @Autowired
    private SampleRemoteService sampleRemoteService;

    @RequestMapping("/status")
    public String status(){
        return "roger-service-subject is running";
    }

    @RequestMapping("/admin_status")
    public String adminStatus(){
        return sampleRemoteService.getStatus();
    }
}
