package jarvast.app.jobs.controller;

import jarvast.app.jobs.entity.Task;
import jarvast.app.jobs.entity.Worker;
import jarvast.app.jobs.service.TaskService;
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

    @PostMapping("/update")
    private ResponseEntity<Task> updateTask(@RequestBody Task task) {
        return ResponseEntity.ok(taskService.updateTask(task));
    }

    @PostMapping("/create/{workerid}")
    private ResponseEntity<Task> createTask(@PathVariable(value = "workerid") Long workerId, @RequestBody Task task) {
        Worker worker = userService.getWorker(workerId);
        return ResponseEntity.ok(taskService.createTask(worker, task));
    }

    @DeleteMapping("/delete/{taskId}")
    private ResponseEntity deleteTask(@PathVariable(value = "taskId") Long taskId) {
        taskService.delete(taskId);
        return ResponseEntity.ok(204);
    }
}
