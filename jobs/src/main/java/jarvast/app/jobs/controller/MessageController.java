/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jarvast.app.jobs.controller;

import jarvast.app.jobs.entity.Message;
import jarvast.app.jobs.service.MessageService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author TomiPC
 */
@RestController
@RequestMapping("/api/messages")
public class MessageController {
    
    @Autowired
    private MessageService messageService;
    
    @GetMapping("/{id}")
    private ResponseEntity<List<Message>> getMessagesById(@PathVariable (value = "id") Long id){
        return ResponseEntity.ok(messageService.getMessagesById(id));
    }
    
}
