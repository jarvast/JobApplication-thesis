package jarvast.app.jobs.service;

import jarvast.app.jobs.entity.Admin;
import jarvast.app.jobs.entity.BaseUser;
import jarvast.app.jobs.entity.Category;
import jarvast.app.jobs.entity.Role;
import jarvast.app.jobs.entity.User;
import jarvast.app.jobs.entity.Worker;
import jarvast.app.jobs.repository.RoleRepository;
import jarvast.app.jobs.repository.TaskRepository;
import jarvast.app.jobs.repository.UserRepository;
import java.math.RoundingMode;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService<T> {

    private final String defaultimagename = "default.png";
    private UserRepository userRepository;
    private BaseUser user;
    private RatingService ratingService;
    private LocationService locationService;
    private TaskRepository taskRepository;
    private RoleRepository roleRepository;

    @Autowired
    public UserService(UserRepository userRepository, LocationService locationService, TaskRepository taskRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.user = null;
        this.locationService = locationService;
        this.taskRepository = taskRepository;
        this.roleRepository = roleRepository;

    }
    @Autowired
    public void setRatingService(RatingService ratingService) {
        this.ratingService = ratingService;
    }
    
    public void login(BaseUser user) {
        user.setLastLogin(new Timestamp(System.currentTimeMillis()));
        userRepository.save(user);
        this.user = user;
        
    }

    public BaseUser getLoggedInUser() {
        return user;
    }

    public String getLoggedInUserName() {
        return user.getUsername();
    }

    public void updateImg(String imgname) {
        System.out.println("erre kell az újat " + imgname);
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
        
        for(Iterator<Worker> it = list.iterator(); it.hasNext();){
            Worker temp = it.next();
            if (!temp.getApproved()){
                it.remove();
            }else{
                calculateRate(temp);
            }
        }
        /*for (Worker w : list) {
            w.setRating(ratingService.calculateRating(w));
        }*/
        return list;
    }
    public List<Worker> getAllWorkers() {
        List<Worker> list = userRepository.findAllWorkers();
        
        for(Iterator<Worker> it = list.iterator(); it.hasNext();){
            Worker temp = it.next();
                calculateRate(temp);
        }
        /*for (Worker w : list) {
            w.setwRating(ratingService.calculateRating(w));
        }*/
        return list;
    }
    
    public List<User> getUsers(){
        return userRepository.findAllUsers();
    }

    public List<Worker> listByCategory(Category category) {
        List<Worker> workerlist = userRepository.findByCategory(category);
        
        for(Iterator<Worker> it = workerlist.iterator(); it.hasNext();){
            Worker temp = it.next();
            if (!temp.getApproved()){
                it.remove();
            }else{
                calculateRate(temp);
            }
        }
        /*for (Worker w : workerlist) {
            calculateRate(w);
        }*/
        return workerlist;
    }
    public List<Worker> searchForString(String input) {
        String searchWord = input.replace("searchFor:", "");
        List<Worker> locationList = locationService.searchByString(searchWord);
        List<Worker> workerList = userRepository.findByNameIgnoreCaseContainingOrDescriptionIgnoreCaseContainingOrEmailIgnoreCaseContaining(searchWord, searchWord, searchWord);

        List<Worker> mergedList = Stream.concat(workerList.stream(), locationList.stream()).collect(Collectors.toList());
        
        for(Iterator<Worker> it = mergedList.iterator(); it.hasNext();){
            Worker temp = it.next();
            if (!temp.getApproved()){
                it.remove();
            }else{
                calculateRate(temp);
            }
        }
        /*for (Worker w : mergedList) {
            calculateRate(w);
        }*/
        return mergedList;
    }

    public Worker getWorker(Long id) {
        return calculateRate(userRepository.findOne(id));
    }
    public User getUser(Long id){
        return userRepository.findById(id);
    }
    public void maintain(){
        //Iterable<BaseUser> all = userRepository.findAll();
        Timestamp old = new Timestamp(System.currentTimeMillis());
        ZonedDateTime zonedDateTime = old.toInstant().atZone(ZoneId.of("UTC"));
        Timestamp yearless = Timestamp.from(zonedDateTime.minus(365, ChronoUnit.DAYS).toInstant());
        
        List<User> users = userRepository.findAllUsers();
        List<Worker> workers = userRepository.findAllWorkers();
        /*for(Iterator<User> it = users.iterator(); it.hasNext();){
            User asd = it.next();
            if (asd.getLastLogin().before(yearless)){
                System.out.println(asd);
                //userRepository.delete(asd);
                userRepository.delete(asd.getId());
            }
        }*/
        for(Iterator<Worker> it = workers.iterator(); it.hasNext();){
            Worker asd = it.next();
            if (asd.getLastLogin().before(yearless)){
                System.out.println(asd);
                //userRepository.delete(asd);
                userRepository.delete(asd.getId());
            }
        }
    }

    private Worker calculateRate(Worker worker) {
        Double rate = ratingService.calculateRating(worker);
        //DecimalFormat df = new DecimalFormat("0,00");
        //df.setRoundingMode(RoundingMode.CEILING);//
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
        List<Worker> top5 = workerList.subList(0, 5);
        
        for(Iterator<Worker> it = top5.iterator(); it.hasNext();){
            Worker temp = it.next();
            if (!temp.getApproved()){
                it.remove();
            }else{
                calculateRate(temp);
            }
        }
        
        /*for (Worker w : top5) {
            calculateRate(w);
        }*/
        return top5;
    }
    public User updateUser(User user){
        User oldUser = userRepository.findById(user.getId());
        
        oldUser.setName(user.getName());
        oldUser.setEmail(user.getEmail());
        oldUser.setPhoneNum(user.getPhoneNum());
        oldUser.setLocation(user.getLocation());
        return userRepository.save(oldUser);
    }
    public Worker updateWorker(Worker worker){
        Worker oldWorker = userRepository.findOne(worker.getId());
        
        oldWorker.setName(worker.getName());
        oldWorker.setDescription(worker.getDescription());
        oldWorker.setPhoneNum(worker.getPhoneNum());
        return userRepository.save(oldWorker);
    }
    public User favorite(Long workerId){
        Worker worker = userRepository.findOne(workerId);
        User oldUser = (User) getLoggedInUser();
        List<Worker> favorites = oldUser.getFavorites();
        favorites.add(worker);
        oldUser.setFavorites(favorites);
        return userRepository.save(oldUser);
    }
    public User removeFavorite(Long workerId){
        Worker worker = userRepository.findOne(workerId);
        User oldUser = (User) getLoggedInUser();
        List<Worker> favorites = oldUser.getFavorites();
        System.out.println(favorites + "aa");
        System.out.println("remsove:" + worker);
        favorites.remove(worker);
        System.out.println(favorites);
        oldUser.setFavorites(favorites);
        return userRepository.save(oldUser);
    }
    public List<Worker> listFavorites(){
        User user = (User) getLoggedInUser();
        List<Worker> favorites = user.getFavorites();
        /*for(Iterator<Worker> it = favorites.iterator(); it.hasNext();){
            calculateRate(it.negxt());
        }*/
        
        
        for (int i =0 ;i< favorites.size();i++){
            calculateRate(favorites.get(i));
        }
        return favorites;
    }
    public Worker approve(Long id){
        Worker worker = userRepository.findOne(id);
        worker.setApproved(Boolean.TRUE);
        
        return userRepository.save(worker);
    }
    public void delete(Long id){
        userRepository.delete(userRepository.findPeopleById(id));
    }
    public Admin registerAdmin(Admin admin, String pass){
        admin.setRole(roleRepository.findOne(1l));
        admin.setPassword(pass);
        admin.setImgName(defaultimagename);
        return userRepository.save(admin);
    }
    public User registerUser(User user, String pass){
        user.setRole(roleRepository.findOne(2l));
        user.setPassword(pass);
        user.setImgName(defaultimagename);
        return userRepository.save(user);
    }
    public Worker registerWorker(Worker worker, String pass){
        worker.setRole(roleRepository.findOne(3l));
        worker.setPassword(pass);
        worker.setImgName(defaultimagename);
        return userRepository.save(worker);
    }

}
