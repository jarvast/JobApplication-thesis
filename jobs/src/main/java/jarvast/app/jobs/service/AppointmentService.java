package jarvast.app.jobs.service;

import jarvast.app.jobs.entity.Appointment;
import jarvast.app.jobs.entity.Worker;
import jarvast.app.jobs.repository.AppointmentRepository;
import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    public List<Appointment> getAppointmentsByWorker(Worker worker) {
        List<Appointment> apps = appointmentRepository.findByWorker(worker);
        for (Iterator<Appointment> it = apps.iterator(); it.hasNext();) {
            if (!it.next().getIsFree()) {
                it.remove();
            }
        }
        return apps;
    }

    public List<Appointment> getOccupiedByWorker(Worker worker) {
        List<Appointment> apps = appointmentRepository.findByWorker(worker);
        for (Iterator<Appointment> it = apps.iterator(); it.hasNext();) {
            if (it.next().getIsFree()) {
                it.remove();
            }
        }
        return apps;
    }

    public void reserve(Long id) {
        Appointment app = appointmentRepository.findOne(id);
        app.setIsFree(Boolean.FALSE);
        appointmentRepository.save(app);
    }

    public Appointment createAppointment(Worker worker, Appointment appointment) {
        appointment.setIsFree(Boolean.TRUE);
        appointment.setWorker(worker);
        return appointmentRepository.save(appointment);
    }
}
