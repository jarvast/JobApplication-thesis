/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jarvast.app.jobs.repository;

import jarvast.app.jobs.entity.Location;
import jarvast.app.jobs.entity.Task;
import jarvast.app.jobs.entity.Worker;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author TomiPC
 */
public interface TaskRepository extends CrudRepository<Task, Long>{
    
    public List<Task> findByWorker(Worker worker);
    
}