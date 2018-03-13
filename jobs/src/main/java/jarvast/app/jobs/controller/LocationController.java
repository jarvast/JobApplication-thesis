/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jarvast.app.jobs.controller;

import jarvast.app.jobs.entity.Location;
import jarvast.app.jobs.entity.Worker;
import jarvast.app.jobs.service.LocationService;
import jarvast.app.jobs.service.UserService;
import java.util.List;
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
@RequestMapping("/api/location")
public class LocationController {
    
    @Autowired
    private LocationService locationService;
    
    @Autowired
    private UserService userService;
    
    @GetMapping("/{userId}")
    private ResponseEntity<List<Location>> getLocationsByUser(@PathVariable(value = "userId") Long userId){
        Worker worker = userService.getOne(userId);
        return ResponseEntity.ok(locationService.getLocationsByWorker(worker));
    }
}
