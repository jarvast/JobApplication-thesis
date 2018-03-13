/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jarvast.app.jobs.repository;

import jarvast.app.jobs.entity.Location;
import jarvast.app.jobs.entity.Rating;
import jarvast.app.jobs.entity.Worker;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author TomiPC
 */
public interface LocationRepository extends CrudRepository<Location, Long>{
    
    public List<Location> findByWorker(Worker worker);
    
}