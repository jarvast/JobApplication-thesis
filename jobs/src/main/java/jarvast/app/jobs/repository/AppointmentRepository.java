package jarvast.app.jobs.repository;

import jarvast.app.jobs.entity.Appointment;
import jarvast.app.jobs.entity.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    List<Appointment> findByWorker(Worker worker);

}
