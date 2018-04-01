package jarvast.app.jobs.service;

import jarvast.app.jobs.entity.Rating;
import jarvast.app.jobs.entity.User;
import jarvast.app.jobs.entity.Worker;
import jarvast.app.jobs.repository.RatingRepository;
import java.sql.Timestamp;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RatingService {

    @Autowired
    private RatingRepository repository;
    
    //@Autowired
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
    
    
    

    public double calculateRating(Worker worker) {
        List<Rating> rates = repository.findByReceiver(worker);
        double average = 0.0;
        for (Rating rate : rates) {
            average += rate.getRating();
        }
        average = (double) average / rates.size();
        return average;
    }

    public List<Rating> getAllRatingsByWorker(Worker worker) {
        return repository.findByReceiver(worker);
    }
    public Rating newRating(Rating rating){
        rating.setSender((User) userService.getLoggedInUser());
        rating.setTimestamp(new Timestamp(System.currentTimeMillis()));
        return repository.save(rating);
    }

}
