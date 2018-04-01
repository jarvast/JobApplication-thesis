package jarvast.app.jobs.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "Appointments")
public class Appointment extends BaseEntity{
    
    
    @Column(name = "appdate")
    private Date appDate;

    @Column(name = "apptime")
    private String appTime;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "worker_id")
    @JsonIgnore
    private Worker worker;

    public Appointment(Date date, String time, Worker worker) {
        this.appDate = date;
        this.appTime = time;
        this.worker = worker;
    }

    public Date getDate() {
        return appDate;
    }

    public void setDate(Date date) {
        this.appDate = date;
    }

    public String getTime() {
        return appTime;
    }

    public void setTime(String time) {
        this.appTime = time;
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    @Override
    public String toString() {
        return "Appointment{" + "date=" + appDate + ", time=" + appTime + '}';
    }
    
}
