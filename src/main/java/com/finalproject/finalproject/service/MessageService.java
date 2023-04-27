package com.finalproject.finalproject.service;

import com.finalproject.finalproject.domain.Message;
import com.finalproject.finalproject.repo.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    @Autowired
    MessageRepo messageRepo;

    public void saveMsg(Message msg) {
        messageRepo.save(msg);

    }

    public List<Message> getAllMsgs(long id) {
        return messageRepo.findOwnerMsgs(id);
    }
}
