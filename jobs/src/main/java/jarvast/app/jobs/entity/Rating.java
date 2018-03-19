package jarvast.app.jobs.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity(name = "Ratings")
public class Rating extends BaseEntity {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "sender_id")
    private User sender;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "recipient_id")
    @JsonIgnore
    private Worker receiver;

    @Column(columnDefinition = "varchar(250) default 'A felhasználó nem adott meg szöveges értékelést.'")
    private String content;

    @Column
    private Timestamp timestamp;

    @Column
    @Max(5)
    @Min(1)
    private int rating;

    public Rating() {
    }
    
    

    public Rating(User sender, Worker receiver, String content, Timestamp timestamp, int rating) {
        this.sender = sender;
        this.receiver = receiver;
        this.content = content;
        this.timestamp = timestamp;
        this.rating = rating;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public Worker getReceiver() {
        return receiver;
    }

    public void setReceiver(Worker receiver) {
        this.receiver = receiver;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Rating{" + "sender=" + sender + ", receiver=" + receiver + ", content=" + content + ", timestamp=" + timestamp + ", rating=" + rating + '}';
    }

    
}
