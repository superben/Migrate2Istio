package com.yofc.admin.controller.outward;

import com.yofc.admin.service.UserService;
import com.yofc.common.bean.BusinessException;
import com.yofc.common.bean.MessageJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/admin/public/user")
public class SystemUserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/{userId}", produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public MessageJson userInfo(@PathVariable("userId") String userId) {
        MessageJson message = new MessageJson();
        try {
            if(StringUtils.isEmpty(userId)){
                throw new BusinessException("请求参数为空[userIs]");
            }
            System.out.println("=================roger debug :" + userId);
            Map<String, Object> user = userService.getUserLogin(userId);
            if (user == null || user.isEmpty()) {
                message.setMsg("can not find the user by " + userId);
                message.setSuccess(true);
                return message;
            }
            message.setData(user);
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
