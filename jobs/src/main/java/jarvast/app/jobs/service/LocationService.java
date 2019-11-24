package jarvast.app.jobs.service;

import jarvast.app.jobs.entity.Location;
import jarvast.app.jobs.entity.Worker;
import jarvast.app.jobs.repository.LocationRepository;
import jarvast.app.jobs.repository.UserRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationService {

    @Autowired
    private LocationRepository locationRepository;
    
    @Autowired
    private UserRepository userRepository;

    public List<Location> getLocationsByWorker(Worker worker) {
        return locationRepository.findByWorker(worker);
    }
    public List<Location> getLocations(){
        return locationRepository.findAll();
    }

    List<Worker> searchByString(String input) {
        List<Location> locationList = locationRepository.findPeopleDistinctByLocationNameContainingAllIgnoreCase(input);
        List<Worker> noDuplicateList = new ArrayList<>();
        for (Location loc : locationList) {
            noDuplicateList.addAll(loc.getWorker());
        }
        return noDuplicateList;
    }
    public Worker updateLocationsByWorker(Worker worker, List<Location> locations){
        worker.setLocations(locations);
        return userRepository.save(worker);
    }
}
