package jarvast.app.jobs.service;

import jarvast.app.jobs.entity.BaseUser;
import jarvast.app.jobs.entity.Message;
import jarvast.app.jobs.entity.User;
import jarvast.app.jobs.entity.Worker;
import jarvast.app.jobs.repository.MessageRepository;
import jarvast.app.jobs.repository.UserRepository;
import java.sql.Timestamp;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        Timestamp monthless = Timestamp.from(zonedDateTime.minus(31, ChronoUnit.DAYS).toInstant());

        BaseUser sender = this.userRepository.findPeopleById(id);
        List<Message> sentMessages = sender.getSenderMessages();
        for (Iterator<Message> it = sentMessages.iterator(); it.hasNext();) {
            Message mess = it.next();
            if (mess.isIsRatingRequest() != null || mess.getSendTimestamp().before(monthless)) {
                it.remove();
            }
        }
        return sentMessages;
    }

    public List<Message> getReports() {
        List<Message> messages = (List<Message>) messageRepository.findAll();
        List<Message> reports = new ArrayList<>();
        for (int i = 0; i < messages.size(); i++) {
            if (messages.get(i).getIsReport() != null) {
                reports.add(messages.get(i));
            }
        }
        return reports;
    }

    public List<Message> getReceivedMessagesById(Long id) {
        Timestamp old = new Timestamp(System.currentTimeMillis());
        ZonedDateTime zonedDateTime = old.toInstant().atZone(ZoneId.of("UTC"));
        Timestamp monthless = Timestamp.from(zonedDateTime.minus(31, ChronoUnit.DAYS).toInstant());

        BaseUser recipient = this.userRepository.findPeopleById(id);
        List<Message> receivedMessages = recipient.getReceiverMessages();

        for (Iterator<Message> it = receivedMessages.iterator(); it.hasNext();) {
            Message mess = it.next();
            if (mess.getSendTimestamp().before(monthless)) {
                it.remove();
            }
        }

        return receivedMessages;
    }

    public Message seeMessage(Long messageId) {
        Message seenMessage = this.messageRepository.findOne(messageId);
        seenMessage.setIsSeen(true);
        return messageRepository.save(seenMessage);
    }

    public List<Message> newMessages(Long id) {
        BaseUser sender = this.userRepository.findPeopleById(id);
        List<Message> newMessages = sender.getReceiverMessages();
        for (Iterator<Message> it = newMessages.iterator(); it.hasNext();) {
            if (it.next().isIsSeen()) {
                it.remove();
            }
        }
        return newMessages;
    }

    public Message requestRating(Long id) {
        Worker requester = (Worker) userService.getLoggedInUser();
        User raterUser = userRepository.findById(id);
        String subject = "A(z) " + requester.getName() + " nevű felhasználó szeretné, ha értékelné";
        String content = "Kérjük értékelje a szakembert az 5 fokozatú skálán, illetve megadhat szöveges értékelést is. A minőség fenntartása érdekében kérjük reális értékelést adjon meg az elvégzett munka alapján!";
        Message requestRatingMessage = new Message(requester, raterUser, content, subject, new Timestamp(System.currentTimeMillis()), false, true, false, false);
        return messageRepository.save(requestRatingMessage);
    }

    public void delete(Long id) {
        messageRepository.delete(id);
    }
}
