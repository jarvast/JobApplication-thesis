package jarvast.app.jobs.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "Tasks")
public class Task extends BaseEntity {

    @Column(name = "task_name")
    private String taskName;

    @Column(name = "task_prices")
    private String taskPrices;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "worker_id")
    @JsonIgnore
    private Worker worker;

    public Task(String taskName, String taskPrices, Worker worker) {
        this.taskName = taskName;
        this.taskPrices = taskPrices;
        this.worker = worker;
    }

    public Task() {
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskPrices() {
        return taskPrices;
    }

    public void setTaskPrices(String taskPrices) {
        this.taskPrices = taskPrices;
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

}
