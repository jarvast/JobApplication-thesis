package jarvast.app.jobs.repository;

import jarvast.app.jobs.entity.Task;
import jarvast.app.jobs.entity.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByWorkert(Worker worker);

}
