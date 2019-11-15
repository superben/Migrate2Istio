package com.yofc.subject.controller;

import com.yofc.common.bean.MessageJson;
import com.yofc.common.util.SignatureUtil;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/subject/signature/")
public class SignatureController {
    @ResponseBody
    @GetMapping(value = "validate", produces = {"application/json;charset=UTF-8"})
    public MessageJson validate(@RequestParam("signature") String signature,
                                @RequestParam("nonce") String nonce,
                                @RequestParam("key") String key
    ) {
        MessageJson message = new MessageJson();
        try {
            String newSignature = SignatureUtil.validate(signature, nonce, key);
            message.setData(newSignature);
            message.setSuccess(true);
            message.setMsg(MessageJson.SUCCESS);
        } catch (Exception ex) {
            message.setMsg(ex.getMessage());
            message.setSuccess(false);
            ex.printStackTrace();
        }
        return message;
    }
}
