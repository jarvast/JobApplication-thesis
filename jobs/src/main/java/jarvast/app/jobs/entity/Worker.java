package jarvast.app.jobs.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity(name = "Worker")
@DiscriminatorValue("Worker")
public class Worker extends BaseUser {

    @Column
    private String email;

    @Column
    private String name;

    @Column
    private String phoneNum;
    
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "workers_locations",
            joinColumns = {
                @JoinColumn(name = "worker_id")},
            inverseJoinColumns = {
                @JoinColumn(name = "locations_id")}
    )
    @JsonIgnore
    private List<Location> locations = new ArrayList<Location>();

    
    @ManyToOne(targetEntity = Category.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id")
    private Category category;

    @Column
    private String description;
    
    @Transient
    private double rating;

    @OneToMany(
            mappedBy = "worker",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JsonIgnore
    private List<Task> tasks = new ArrayList<Task>();

    @ManyToMany(mappedBy = "favorites", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<User> userList = new ArrayList<User>();

    @OneToMany(
            mappedBy = "receiver",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JsonIgnore
    private List<Rating> ratings = new ArrayList<Rating>();

    public Worker(String email, String name, String phoneNum, Category category, String description, Double rating) {
        this.email = email;
        this.name = name;
        this.phoneNum = phoneNum;
        this.category = category;
        this.description = description;
        this.rating =rating;
    }

    public Worker() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
    
    public List<Location> getLocations() {
        return locations;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }

    @Override
    public String toString() {
        return "Worker{id"+ this.id + "email=" + email + ", name=" + name + ", phoneNum=" + phoneNum + ", locations=" + locations + ", category=" + category + ", description=" + description ;//+ ", tasks=" + tasks + ", userList=" + userList + ", ratings=" + ratings + '}';
    }

    
}
