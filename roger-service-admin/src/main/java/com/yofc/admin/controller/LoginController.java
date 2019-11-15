package com.yofc.admin.controller;

import com.yofc.admin.service.UserService;
import com.yofc.common.bean.BusinessException;
import com.yofc.common.bean.MessageJson;
import com.yofc.common.util.CommonMapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/admin/user")
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/login", produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public MessageJson login(@RequestBody Map<String, Object> queryParam) {
        MessageJson message = new MessageJson();
        Map<String, Object> loginMap = new HashMap<>();
        try {
            if (CommonMapUtils.isBlankByKey(queryParam, "userId")) {
                loginMap.put("code", "loginFail");
                message.setMsg("userId is Required");
                message.setSuccess(true);
                message.setData(loginMap);
                return message;
            }
            String userId = (String) queryParam.get("userId");
            Map<String, Object> user = userService.getUserLogin(userId);
            //TODO need add token future
            if (user == null || user.isEmpty()) {
                loginMap.put("code", "loginFail");
                message.setMsg("can not find the user by " + userId);
                message.setSuccess(true);
                message.setData(loginMap);
                return message;
            }
            loginMap.put("code", "loginSuccess");
            loginMap.put("user", user);
            message.setData(loginMap);
            message.setSuccess(true);
            message.setMsg(MessageJson.SUCCESS);
        } catch (Exception ex) {
            loginMap.put("code", "loginFail");
            message.setMsg("登录接口异常！" + ex.getMessage());
            message.setSuccess(false);
            ex.printStackTrace();
        }
        return message;
    }
}
