package jarvast.app.jobs.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class Role extends BaseEntity {

    @Column(unique = true, nullable = false)
    private String roleName;

    @OneToMany(targetEntity = BaseUser.class, mappedBy = "role", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<BaseUser> users;

    public String getRole() {
        return roleName;
    }

    public void setRole(String role) {
        this.roleName = role;
    }

    public List<BaseUser> getUsers() {
        return users;
    }

    public void setUsers(List<BaseUser> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Role{" + "role=" + roleName + '}';
    }

}
