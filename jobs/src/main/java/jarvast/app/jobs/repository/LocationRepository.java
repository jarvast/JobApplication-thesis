package jarvast.app.jobs.repository;

import jarvast.app.jobs.entity.Location;
import jarvast.app.jobs.entity.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {

    List<Location> findByWorker(Worker worker);

    List<Location> findPeopleDistinctByLocationNameContainingAllIgnoreCase(String str);

    List<Location> findAll();

}
