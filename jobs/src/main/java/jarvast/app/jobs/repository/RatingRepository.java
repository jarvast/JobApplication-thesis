package jarvast.app.jobs.repository;

import jarvast.app.jobs.entity.Rating;
import jarvast.app.jobs.entity.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Long> {

    List<Rating> findByReceiver(Worker worker);

}
