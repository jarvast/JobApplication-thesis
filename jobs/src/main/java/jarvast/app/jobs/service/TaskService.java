package jarvast.app.jobs.service;

import jarvast.app.jobs.entity.Task;
import jarvast.app.jobs.entity.Worker;
import jarvast.app.jobs.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getTasksByWorker(Worker worker) {
        return taskRepository.findByWorkert(worker);
    }

    public Task updateTask(Task task) {
        Task oldTask = taskRepository.findById(task.getId()).orElseThrow(NoSuchElementException::new);

        oldTask.setTaskName(task.getTaskName());
        oldTask.setTaskPrices(task.getTaskPrices());
        return taskRepository.save(oldTask);
    }

    public Task createTask(Worker worker, Task task) {
        task.setWorker(worker);
        return taskRepository.save(task);
    }

    public void delete(Long id) {
        taskRepository.deleteById(id);
    }
}
