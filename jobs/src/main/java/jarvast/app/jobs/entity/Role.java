package jarvast.app.jobs.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class Role extends BaseEntity{
    
    @Column(unique = true, nullable = false)
    private String role;
    
    @OneToMany(targetEntity = User.class, mappedBy = "role")
    @JsonIgnore
    private List<User> users;
    
    
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
    

    @Override
    public String toString() {
        return "Role{" + "role=" + role + '}';
    }
    
}
