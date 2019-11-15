package com.yofc.subject.kafka.producer;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class MessageProducer {

    protected static final Logger logger = LoggerFactory.getLogger(MessageProducer.class);

    @Autowired(required = false)
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String messageTopic, String message){
        logger.debug(messageTopic, message);
        kafkaTemplate.send(messageTopic, message);
    }

}
