/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jarvast.app.jobs.service;

import jarvast.app.jobs.entity.BaseUser;
import jarvast.app.jobs.entity.Message;
import jarvast.app.jobs.entity.User;
import jarvast.app.jobs.entity.Worker;
import jarvast.app.jobs.repository.MessageRepository;
import jarvast.app.jobs.repository.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author TomiPC
 */
@Service
public class MessageService {
    
    @Autowired
    private MessageRepository messageRepository;
    
    @Autowired
    private UserRepository userRepository;
    
    public List<Message> getMessagesById(Long id){
        BaseUser sender = this.userRepository.findPeopleById(id);
        List<Message> sentMessages = sender.getSenderMessages();
        return sentMessages;
    }
}
