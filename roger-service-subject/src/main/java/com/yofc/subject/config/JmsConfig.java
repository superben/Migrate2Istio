package com.yofc.subject.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JmsConfig {

    @Value("${cbJms.enable}")
    private boolean enable;

    @Value("${cbJms.messageTopic}")
    private String messageTopic;

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public String getMessageTopic() {
        return messageTopic;
    }

    public void setMessageTopic(String messageTopic) {
        this.messageTopic = messageTopic;
    }
}
