package jarvast.app.jobs.repository;

import jarvast.app.jobs.entity.Appointment;
import jarvast.app.jobs.entity.Worker;
import java.io.Serializable;
import java.util.List;
import org.springframework.data.repository.CrudRepository;


public interface AppointmentRepository extends CrudRepository<Appointment, Long>{
    
    public List<Appointment> findByWorker(Worker worker);
    
}
