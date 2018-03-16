package jarvast.app.jobs.service;

import jarvast.app.jobs.entity.Task;
import jarvast.app.jobs.entity.Worker;
import jarvast.app.jobs.repository.TaskRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getTasksByWorker(Worker worker) {
        return taskRepository.findByWorker(worker);
    }
}
