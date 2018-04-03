package jarvast.app.jobs.controller;
//
import jarvast.app.jobs.entity.Message;
import jarvast.app.jobs.service.MessageService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/messages")
public class MessageController {
    
    @Autowired
    private MessageService messageService;
    
    @PostMapping("/send")
    private ResponseEntity<Message> sendMessage(@RequestBody Message message){
        return ResponseEntity.ok(messageService.sendMessage(message));
    }
    
    @GetMapping("/{id}")
    private ResponseEntity<List<Message>> getSentMessagesById(@PathVariable (value = "id") Long id){
        return ResponseEntity.ok(messageService.getSentMessagesById(id));
    }
    @GetMapping("/reports")
    private ResponseEntity<List<Message>> getReports(){
        return ResponseEntity.ok(messageService.getReports());
    }
    @DeleteMapping("/{id}")
    private ResponseEntity deleteMessage(@PathVariable (value = "id") Long id){
        messageService.delete(id);
        return ResponseEntity.ok(204);
    }
    @GetMapping("/received/{id}")
    private ResponseEntity<List<Message>> getReceivedMessagesById(@PathVariable (value = "id") Long id){
        return ResponseEntity.ok(messageService.getReceivedMessagesById(id));
    }
    @GetMapping("/see/{id}")
    private ResponseEntity<Message> seeMessage(@PathVariable (value = "id") Long id){
        return ResponseEntity.ok(messageService.seeMessage(id));
    }
    @GetMapping("/new/{id}")
    private ResponseEntity<List<Message>> newMessages(@PathVariable (value = "id") Long id){
        return ResponseEntity.ok(messageService.newMessages(id));
    }
    @GetMapping("/rating/{id}")
    private ResponseEntity<Message> requestRating(@PathVariable (value = "id") Long id){
        return ResponseEntity.ok(messageService.requestRating(id));
    }
    
}
