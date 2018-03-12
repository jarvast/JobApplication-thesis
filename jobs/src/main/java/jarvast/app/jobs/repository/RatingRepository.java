package jarvast.app.jobs.repository;

import jarvast.app.jobs.entity.Category;
import jarvast.app.jobs.entity.Rating;
import jarvast.app.jobs.entity.Worker;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface RatingRepository extends CrudRepository<Rating, Long>{
    
    public List<Rating> findByReceiver(Worker worker);
    
}
