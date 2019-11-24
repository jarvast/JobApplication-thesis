package jarvast.app.jobs.controller;

import jarvast.app.jobs.entity.Rating;
import jarvast.app.jobs.entity.Worker;
import jarvast.app.jobs.service.RatingService;
import jarvast.app.jobs.service.UserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ratings")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @Autowired
    private UserService userService;

    @GetMapping("/worker/{userId}")
    private ResponseEntity<List<Rating>> getAllRatingsByWorker(@PathVariable(value = "userId") Long userId) {
        Worker worker = userService.getWorker(userId);
        return ResponseEntity.ok(ratingService.getAllRatingsByWorker(worker));
    }

    @PostMapping("")
    private ResponseEntity<Rating> newRating(@RequestBody Rating rating) {
        return ResponseEntity.ok(ratingService.newRating(rating));
    }

}
