package jarvast.app.jobs.entity;

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

@Entity(name = "User")
@DiscriminatorValue("User")
public class User extends BaseUser {

    @Column
    private String email;

    @Column
    private String name;

    @Column
    private String phoneNum;

    @Column
    private String location;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_favorites",
            joinColumns = {
                @JoinColumn(name = "user_id")},
            inverseJoinColumns = {
                @JoinColumn(name = "worker_id")}
    )
    private List<Worker> favorites = new ArrayList<Worker>();

    public User(String email, String name, String phoneNum, String location) {
        this.email = email;
        this.name = name;
        this.phoneNum = phoneNum;
        this.location = location;
    }

    public User() {
    }

    //private String imgUrl;*/
    ;

    public List<Worker> getFavorites() {
        return favorites;
    }

    public void setFavorites(List<Worker> favorites) {
        this.favorites = favorites;
    }

    //private String imgUrl;*/
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "User{" + "email=" + email + ", name=" + name + ", phoneNum=" + phoneNum + ", location=" + location + "" + this.getUsername() + " " +  "}";
    }

}
