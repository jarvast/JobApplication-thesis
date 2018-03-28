package jarvast.app.jobs.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "Messages")
public class Message extends BaseEntity {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "sender_id")
    private BaseUser sender;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "recipient_id")
    private BaseUser receiver;

    @Column
    private String content;
    
    @Column
    private String subject;

    @Column
    private Timestamp sendTimestamp;

    @Column
    private boolean isSeen;

    public Message(BaseUser sender, BaseUser receiver, String content,String subject, Timestamp sendTimestamp, boolean isSeen) {
        this.sender = sender;
        this.receiver = receiver;
        this.content = content;
        this.subject = subject;
        this.sendTimestamp = sendTimestamp;
        this.isSeen = isSeen;
    }

    public Message() {
    }

    public BaseUser getSender() {
        return sender;
    }

    public void setSender(BaseUser sender) {
        this.sender = sender;
    }

    public BaseUser getReceiver() {
        return receiver;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
    

    public void setReceiver(BaseUser receiver) {
        this.receiver = receiver;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getSendTimestamp() {
        return sendTimestamp;
    }

    public void setSendTimestamp(Timestamp sendTimestamp) {
        this.sendTimestamp = sendTimestamp;
    }

    public boolean isIsSeen() {
        return isSeen;
    }

    public void setIsSeen(boolean isSeen) {
        this.isSeen = isSeen;
    }

}
