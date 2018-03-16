package jarvast.app.jobs.repository;

import jarvast.app.jobs.entity.Task;
import jarvast.app.jobs.entity.Worker;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<Task, Long> {

    public List<Task> findByWorker(Worker worker);

}
