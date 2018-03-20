package jarvast.app.jobs.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity(name = "Locations")
public class Location extends BaseEntity {

    @Column(name = "location_name")
    private String locationName;
    
    @ManyToMany(mappedBy = "locations", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Worker> worker = new ArrayList<Worker>();
    
    @OneToMany(
        mappedBy = "location", 
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    @JsonIgnore
    private List<User> users;

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public List<Worker> getWorker() {
        return worker;
    }

    public void setWorker(List<Worker> worker) {
        this.worker = worker;
    }

    
    
    /*public List<Worker> getWorker() {
        return worker;
    }
    

    public void setWorker(List<Worker> worker) {
        this.worker = worker;
    }*/

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    /*public String getLocation() {
        return locationName;
    }

    public void setLocation(String location) {
        this.locationName = location;*/
    //}

    @Override
    public String toString() {
        return locationName;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.locationName);
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
        final Location other = (Location) obj;
        if (!Objects.equals(this.locationName, other.locationName)) {
            return false;
        }
        return true;
    }

}
