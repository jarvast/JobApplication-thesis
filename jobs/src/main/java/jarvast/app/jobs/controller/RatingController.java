/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jarvast.app.jobs.controller;

import jarvast.app.jobs.entity.Worker;
import jarvast.app.jobs.service.RatingService;
import jarvast.app.jobs.service.UserService;
import java.util.Collections;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author TomiPC
 */
@RestController
@RequestMapping("/api/ratings")
public class RatingController {
    
    @Autowired
    private RatingService ratingService;
    
    @Autowired
    private UserService userService;
    
    @GetMapping("/{userId}")
    private ResponseEntity<FullRating> getRatingByUser(@PathVariable(value = "userId") Long userId){
        System.out.println(userId + "boob");
        Worker worker = userService.getOne(userId);
        FullRating rating = new FullRating(ratingService.calculateRating(worker));
        return ResponseEntity.ok(rating);
    }

    private static class FullRating {
        
        public double rating;

        public FullRating(double rating) {
            this.rating=rating;
        }

        public double getRating() {
            return rating;
        }

        public void setRating(int rating) {
            this.rating = rating;
        }
        
    }
    
}
