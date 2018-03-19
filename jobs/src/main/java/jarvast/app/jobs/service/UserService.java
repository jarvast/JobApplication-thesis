package jarvast.app.jobs.service;

import jarvast.app.jobs.entity.BaseUser;
import jarvast.app.jobs.entity.Category;
import jarvast.app.jobs.entity.User;
import jarvast.app.jobs.entity.Worker;
import jarvast.app.jobs.repository.UserRepository;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService<T> {

    private UserRepository userRepository;
    private BaseUser user;
    private RatingService ratingService;
    private LocationService locationService;

    @Autowired
    public UserService(UserRepository userRepository, RatingService ratingService, LocationService locationService) {
        this.userRepository = userRepository;
        this.user = null;
        this.ratingService = ratingService;
        this.locationService = locationService;

    }
    public void login(BaseUser user) {
        this.user = user;
    }

    public BaseUser getLoggedInUser() {
        return user;
    }

    public String getLoggedInUserName() {
        return user.getUsername();
    }

    public void updateImg(String imgname) {
        this.user.setImgName(imgname);
        userRepository.save(this.user);
    }

    public String getImg() {
        return this.user.getImgName();
    }

    public void logout() {
        this.user = null;
    }

    public List<Worker> getWorkers() {
        List<Worker> list = userRepository.findAllWorkers();
        for (Worker w : list) {
            w.setRating(ratingService.calculateRating(w));
        }
        return list;
    }

    public List<Worker> listByCategory(Category category) {
        List<Worker> workerlist = userRepository.findByCategory(category);
        for (Worker w : workerlist) {
            calculateRate(w);
        }
        return workerlist;
    }
    public List<Worker> searchForString(String input) {
        String searchWord = input.replace("searchFor:", "");
        List<Worker> locationList = locationService.searchByString(searchWord);
        List<Worker> workerList = userRepository.findByNameIgnoreCaseContainingOrDescriptionIgnoreCaseContainingOrEmailIgnoreCaseContaining(searchWord, searchWord, searchWord);

        List<Worker> mergedList = Stream.concat(workerList.stream(), locationList.stream()).collect(Collectors.toList());
        for (Worker w : mergedList) {
            calculateRate(w);
        }
        return mergedList;
    }

    public Worker getWorker(Long id) {
        return calculateRate(userRepository.findOne(id));
    }
    public User getUser(Long id){
        return userRepository.findById(id);
    }

    private Worker calculateRate(Worker worker) {
        Double rate = ratingService.calculateRating(worker);
        //DecimalFormat df = new DecimalFormat("0,00");
        //df.setRoundingMode(RoundingMode.CEILING);
        if (Double.isNaN(rate)) {
            worker.setRating(0.0);
        } else {
            worker.setRating(rate);
           // worker.setRating(Double.parseDouble(df.format(rate)));
        }
        return worker;
    }
    public List<Worker> getTop5(){
        List<Worker> workerList = userRepository.findAllWorkers();
        workerList.sort((r1, r2) -> Integer.compare(r2.getRatings().size(), r1.getRatings().size()));
        return workerList.subList(0, 5);
    }

}
