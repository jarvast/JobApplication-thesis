package jarvast.app.jobs.service;

import jarvast.app.jobs.entity.Appointment;
import jarvast.app.jobs.entity.Worker;
import jarvast.app.jobs.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    public List<Appointment> getAppointmentsByWorker(Worker worker) {
        List<Appointment> apps = appointmentRepository.findByWorker(worker);
        apps.removeIf(appointment -> !appointment.getIsFree());
        return apps;
    }

    public List<Appointment> getOccupiedByWorker(Worker worker) {
        List<Appointment> apps = appointmentRepository.findByWorker(worker);
        apps.removeIf(Appointment::getIsFree);
        return apps;
    }

    public void reserve(Long id) {
        Appointment app = appointmentRepository.findById(id).orElseThrow(NoSuchElementException::new);
        app.setIsFree(Boolean.FALSE);
        appointmentRepository.save(app);
    }
    public void delete(Long id){
        appointmentRepository.deleteById(id);
    }

    public Appointment createAppointment(Worker worker, Appointment appointment) {
        appointment.setIsFree(Boolean.TRUE);
        appointment.setWorker(worker);
        return appointmentRepository.save(appointment);
    }
}
