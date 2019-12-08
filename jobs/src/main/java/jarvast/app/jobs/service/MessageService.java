package jarvast.app.jobs.service;

import jarvast.app.jobs.entity.BaseUser;
import jarvast.app.jobs.entity.Message;
import jarvast.app.jobs.entity.Worker;
import jarvast.app.jobs.repository.MessageRepository;
import jarvast.app.jobs.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    public Message sendMessage(Message message) {
        message.setSender(userService.getLoggedInUser());
        message.setSendTimestamp(new Timestamp(System.currentTimeMillis()));
        return messageRepository.save(message);
    }

    public List<Message> getSentMessagesById(Long id) {
        Timestamp old = new Timestamp(System.currentTimeMillis());
        ZonedDateTime zonedDateTime = old.toInstant().atZone(ZoneId.of("UTC"));
        Timestamp aMonthLess = Timestamp.from(zonedDateTime.minus(31, ChronoUnit.DAYS).toInstant());

        BaseUser sender = this.userRepository.findPeopleById(id);
        List<Message> sentMessages = sender.getSenderMessages();
        sentMessages.removeIf(message -> message.isIsRatingRequest() != null || message.getSendTimestamp().before(aMonthLess));
        return sentMessages;
    }

    public List<Message> getReports() {
        List<Message> messages = messageRepository.findAll();
        List<Message> reports = new ArrayList<>();
        for (Message message : messages) {
            if (message.getIsReport() != null) {
                reports.add(message);
            }
        }
        return reports;
    }

    public List<Message> getReceivedMessagesById(Long id) {
        Timestamp old = new Timestamp(System.currentTimeMillis());
        ZonedDateTime zonedDateTime = old.toInstant().atZone(ZoneId.of("UTC"));
        Timestamp aMonthLess = Timestamp.from(zonedDateTime.minus(31, ChronoUnit.DAYS).toInstant());

        BaseUser recipient = this.userRepository.findPeopleById(id);
        List<Message> receivedMessages = recipient.getReceiverMessages();

        receivedMessages.removeIf(message -> message.getSendTimestamp().before(aMonthLess));

        return receivedMessages;
    }

    public Message seeMessage(Long messageId) {
        Message seenMessage = this.messageRepository.findById(messageId).orElseThrow(NoSuchElementException::new);
        seenMessage.setIsSeen(true);
        return messageRepository.save(seenMessage);
    }

    public List<Message> newMessages(Long id) {
        BaseUser sender = this.userRepository.findPeopleById(id);
        List<Message> newMessages = sender.getReceiverMessages();
        newMessages.removeIf(Message::isIsSeen);
        return newMessages;
    }

    public Message requestRating(Long id) throws UserNotFoundException {
        Worker requester = (Worker) userService.getLoggedInUser();
        BaseUser raterUser = userRepository.findById(id).orElseThrow(()-> new UserNotFoundException("No user found with id: " + id));
        String subject = "A(z) " + requester.getName() + " nevű felhasználó szeretné, ha értékelné";
        String content = "Kérjük értékelje a szakembert az 5 fokozatú skálán, illetve megadhat szöveges értékelést is. A minőség fenntartása érdekében kérjük reális értékelést adjon meg az elvégzett munka alapján!";
        Message requestRatingMessage = new Message(requester, raterUser, content, subject, new Timestamp(System.currentTimeMillis()), false, true, false, false);
        return messageRepository.save(requestRatingMessage);
    }

    public void delete(Long id) {
        messageRepository.deleteById(id);
    }
}
