package jarvast.app.jobs.repository;

import jarvast.app.jobs.entity.Location;
import jarvast.app.jobs.entity.Worker;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface LocationRepository extends CrudRepository<Location, Long> {

    public List<Location> findByWorker(Worker worker);

    public List<Location> findPeopleDistinctBylocationNameContainingAllIgnoreCase(String str);
    
    public List<Location> findAll();


}
