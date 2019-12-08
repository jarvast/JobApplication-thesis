package jarvast.app.jobs.controller;

import jarvast.app.jobs.entity.Appointment;
import jarvast.app.jobs.entity.Worker;
import jarvast.app.jobs.service.AppointmentService;
import jarvast.app.jobs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private UserService userService;

    public AppointmentController(AppointmentService appointmentService, UserService userService) {
        this.appointmentService = appointmentService;
        this.userService = userService;
    }

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

    @PostMapping("/create/{workerid}")
    private ResponseEntity<Appointment> createAppointment(@PathVariable(value = "workerid") Long workerId, @RequestBody Appointment appointment) {
        Worker worker = userService.getWorker(workerId);
        return ResponseEntity.ok(appointmentService.createAppointment(worker, appointment));
    }
}
