/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jarvast.app.jobs.service;

import jarvast.app.jobs.entity.Rating;
import jarvast.app.jobs.entity.Worker;
import jarvast.app.jobs.repository.RatingRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 *
 * @author TomiPC
 */
@Service
public class RatingService {
    
    @Autowired
    private RatingRepository repository;

    public double calculateRating(Worker worker) {
        List<Rating> rates = repository.findByReceiver(worker);
        double sum= 0.0;
        for (Rating rate : rates){
            sum += rate.getRating();
        }
        sum = (double) sum / rates.size();
        return sum;
    }
    public List<Rating> getAllRatingsByWorker(Worker worker){
        return repository.findByReceiver(worker);
    }
    
}
