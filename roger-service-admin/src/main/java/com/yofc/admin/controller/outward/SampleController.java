package com.yofc.admin.controller.outward;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin/public/sample")
public class SampleController {

    @RequestMapping("/status")
    public String status(){
        return "roger-service-admin is running";
    }

}
