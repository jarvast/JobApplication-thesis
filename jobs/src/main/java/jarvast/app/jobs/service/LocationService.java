package jarvast.app.jobs.service;

import jarvast.app.jobs.entity.Location;
import jarvast.app.jobs.entity.Worker;
import jarvast.app.jobs.repository.LocationRepository;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationService {

    @Autowired
    private LocationRepository locationRepository;

    public List<Location> getLocationsByWorker(Worker worker) {
        return locationRepository.findByWorker(worker);
    }
    public List<Location> getLocations(){
        return locationRepository.findAll();
    }

    List<Worker> searchByString(String input) {
        List<Location> locationList = locationRepository.findPeopleDistinctBylocationNameContainingAllIgnoreCase(input);
        List<Worker> noDuplicateList = new ArrayList<>();
        for (Location loc : locationList) {
            noDuplicateList.addAll(loc.getWorker());
        }
        /*
        Set<Worker> temp = new HashSet<>();
        temp.addAll(noDuplicateList);
        noDuplicateList.clear();
        noDuplicateList.addAll(temp);*/
        return noDuplicateList;
        //return noDuplicateList;
    }
}
