package jarvast.app.jobs.controller;

import jarvast.app.jobs.entity.Task;
import jarvast.app.jobs.entity.Worker;
import jarvast.app.jobs.service.TaskService;
import jarvast.app.jobs.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private UserService userService;

    @GetMapping("/{userId}")
    private ResponseEntity<List<Task>> getTasksByUser(@PathVariable(value = "userId") Long userId) {
        Worker worker = userService.getWorker(userId);
        return ResponseEntity.ok(taskService.getTasksByWorker(worker));
    }
}
