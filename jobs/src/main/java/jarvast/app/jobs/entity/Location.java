package jarvast.app.jobs.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "Locations")
public class Location extends BaseEntity {

    @Column(name = "location_name")
    private String locationName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "worker_id")
    @JsonIgnore
    private Worker worker;

    public String getLocation() {
        return locationName;
    }

    public void setLocation(String location) {
        this.locationName = location;
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

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
