package com.yofc.subject.service;

public interface SendMessageService {
    void sendMessage(Integer id, String optName, String receiver, String title, String type);
}
