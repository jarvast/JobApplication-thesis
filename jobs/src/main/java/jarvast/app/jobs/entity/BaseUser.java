package jarvast.app.jobs.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "UserType")
@JsonIgnoreProperties(ignoreUnknown = true, value = {"password"}, allowSetters = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "roletype")
@JsonSubTypes({
    @JsonSubTypes.Type(value = User.class, name = "User"),

    @JsonSubTypes.Type(value = Worker.class, name = "Worker"),

    @JsonSubTypes.Type(value = Admin.class, name = "Admin")}
)
public abstract class BaseUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(columnDefinition = "varchar(40) default 'default.jpg'")
    private String image;

    @Column(columnDefinition = "datetime default CURRENT_TIMESTAMP")
    private Timestamp lastLogin;

    @OneToMany(
            mappedBy = "sender",
            cascade = CascadeType.REFRESH,
            orphanRemoval = true
    )
    @JsonIgnore
    private List<Message> senderMessages = new ArrayList<>();

    @OneToMany(
            mappedBy = "receiver",
            cascade = CascadeType.REFRESH,
            orphanRemoval = true
    )
    @JsonIgnore
    private List<Message> receiverMessages = new ArrayList<>();

    @JoinColumn
    @ManyToOne(targetEntity = Role.class, optional = false, cascade = CascadeType.PERSIST)
    private Role role;

    public BaseUser() {
    }

    public BaseUser(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getImgName() {
        return image;
    }

    public void setImgName(String imgName) {
        this.image = imgName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Message> getSenderMessages() {
        return senderMessages;
    }

    public void setSenderMessages(List<Message> senderMessages) {
        this.senderMessages = senderMessages;
    }

    public List<Message> getReceiverMessages() {
        return receiverMessages;
    }

    public void setReceiverMessages(List<Message> receiverMessages) {
        this.receiverMessages = receiverMessages;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Timestamp getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Timestamp lastLogin) {
        this.lastLogin = lastLogin;
    }

    @Override
    public String toString() {
        return "User{" + "username=" + username + image + "iiii" + ", password=" + password + ", roles=" + role.getRole() + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 13 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 13 * hash + Objects.hashCode(this.username);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final BaseUser other = (BaseUser) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        return true;
    }

}
