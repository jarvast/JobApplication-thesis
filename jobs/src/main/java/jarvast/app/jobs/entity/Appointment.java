package jarvast.app.jobs.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity(name = "Appointments")
public class Appointment extends BaseEntity {

    @Column(name = "appdate")
    private Date appDate;

    @Column(name = "apptime")
    private String appTime;

    @Column
    private Boolean isFree;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "worker_id")
    @JsonIgnore
    private Worker worker;

    @OneToMany(
            mappedBy = "appointment",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JsonIgnore
    private List<Message> messages = new ArrayList<>();

    public Appointment() {
    }

    public Appointment(Date appDate, String appTime, Worker worker, Boolean isFree) {
        this.appDate = appDate;
        this.appTime = appTime;
        this.worker = worker;
        this.isFree = isFree;
    }

    public Date getAppDate() {
        return appDate;
    }

    public void setAppDate(Date appDate) {
        this.appDate = appDate;
    }

    public String getAppTime() {
        return appTime;
    }

    public void setAppTime(String appTime) {
        this.appTime = appTime;
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public Boolean getIsFree() {
        return isFree;
    }

    public void setIsFree(Boolean isFree) {
        this.isFree = isFree;
    }

    @Override
    public String toString() {
        return "Appointment{" + "date=" + appDate + ", time=" + appTime + '}';
    }

}
