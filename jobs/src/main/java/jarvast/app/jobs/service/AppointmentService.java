package jarvast.app.jobs.service;

import jarvast.app.jobs.entity.Appointment;
import jarvast.app.jobs.entity.Worker;
import jarvast.app.jobs.repository.AppointmentRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointmentService {
    
    @Autowired
    private AppointmentRepository appointmentRepository;
    
    public List<Appointment> getAppointmentsByWorker(Worker worker){
        return appointmentRepository.findByWorker(worker);
    }
}
