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

    @Column(length = 1000)
    private String content;
    
    @Column
    private String subject;

    @Column
    private Timestamp sendTimestamp;

    @Column
    private Boolean isSeen;
    
    @Column
    private Boolean isRatingRequest;

    public Message(BaseUser sender, BaseUser receiver, String content,String subject, Timestamp sendTimestamp, Boolean isSeen, Boolean isRatingRequest) {
        this.sender = sender;
        this.receiver = receiver;
        this.content = content;
        this.subject = subject;
        this.sendTimestamp = sendTimestamp;
        this.isSeen = isSeen;
        this.isRatingRequest = isRatingRequest;
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

    public Boolean isIsSeen() {
        return isSeen;
    }

    public void setIsSeen(Boolean isSeen) {
        this.isSeen = isSeen;
    }

    public Boolean isIsRatingRequest() {
        return isRatingRequest;
    }

    public void setIsRatingRequest(Boolean isRatingRequest) {
        this.isRatingRequest = isRatingRequest;
    }
    

}
