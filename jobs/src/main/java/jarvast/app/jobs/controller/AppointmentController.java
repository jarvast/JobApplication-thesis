package jarvast.app.jobs.controller;

import jarvast.app.jobs.entity.Appointment;
import jarvast.app.jobs.entity.Worker;
import jarvast.app.jobs.service.AppointmentService;
import jarvast.app.jobs.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private UserService userService;

    @GetMapping("/{workerId}")
    private ResponseEntity<List<Appointment>> getAppointmentsByWorker(@PathVariable(value = "workerId") Long workerId) {
        Worker worker = userService.getWorker(workerId);
        return ResponseEntity.ok(appointmentService.getAppointmentsByWorker(worker));
    }

    @GetMapping("/occupied/{workerId}")
    private ResponseEntity<List<Appointment>> getOccupiedByWorker(@PathVariable(value = "workerId") Long workerId) {
        Worker worker = userService.getWorker(workerId);
        return ResponseEntity.ok(appointmentService.getOccupiedByWorker(worker));
    }

    @DeleteMapping("/{id}")
    private ResponseEntity reserve(@PathVariable(value = "id") Long id) {
        appointmentService.reserve(id);
        return ResponseEntity.ok(204);
    }
    @DeleteMapping("/delete/{id}")
    private ResponseEntity delete(@PathVariable(value = "id") Long id) {
        appointmentService.delete(id);
        return ResponseEntity.ok(204);
    }

    @PostMapping("/{workerid}")
    private ResponseEntity<Appointment> createAppointment(@PathVariable(value = "workerid") Long workerId, @RequestBody Appointment appointment) {
        Worker worker = userService.getWorker(workerId);
        return ResponseEntity.ok(appointmentService.createAppointment(worker, appointment));
    }
}
