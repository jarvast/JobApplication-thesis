package jarvast.app.jobs.service;

import jarvast.app.jobs.entity.*;
import jarvast.app.jobs.repository.RoleRepository;
import jarvast.app.jobs.repository.TaskRepository;
import jarvast.app.jobs.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class UserService<T> {

    private final String defaultimagename = "default.jpg";
    private UserRepository userRepository;
    private BaseUser user;
    private RatingService ratingService;
    private MessageService messageService;
    private LocationService locationService;
    private RoleRepository roleRepository;

    @Autowired
    public UserService(UserRepository userRepository, LocationService locationService, TaskRepository taskRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.user = null;
        this.locationService = locationService;
        this.roleRepository = roleRepository;

    }

    @Autowired
    public void setRatingService(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @Autowired
    public void setMessageService(MessageService messageService) {
        this.messageService = messageService;
    }

    public void login(BaseUser user) {
        user.setLastLogin(new Timestamp(System.currentTimeMillis()));
        userRepository.save(user);
        this.user = user;

    }

    public BaseUser getLoggedInUser() {
        return user;
    }

    String getLoggedInUserName() {
        return user.getUsername();
    }

    void updateImg(String imgname) {
        this.user.setImgName(imgname);
        userRepository.save(this.user);
    }

    String getImg() {
        return this.user.getImgName();
    }

    public void logout() {
        this.user = null;
    }

    public List<Worker> getWorkers() {
        List<Worker> list = userRepository.findAllWorkers();

        for (Iterator<Worker> it = list.iterator(); it.hasNext(); ) {
            Worker temp = it.next();
            if (!temp.getApproved()) {
                it.remove();
            } else {
                calculateRate(temp);
            }
        }
        return list;
    }

    public List<Worker> getAllWorkers() {
        List<Worker> allWorkers = userRepository.findAllWorkers();

        for (Worker temp : allWorkers) {
            calculateRate(temp);
        }
        return allWorkers;
    }

    public List<User> getUsers() {
        return userRepository.findAllUsers();
    }

    public List<Worker> listByCategory(Category category) {
        List<Worker> workerlist = userRepository.findByCategory(category);

        for (Iterator<Worker> it = workerlist.iterator(); it.hasNext(); ) {
            Worker temp = it.next();
            if (!temp.getApproved()) {
                it.remove();
            } else {
                calculateRate(temp);
            }
        }
        return workerlist;
    }

    public List<Worker> searchForString(String input) {
        String searchWord = input.replace("searchFor:", "");
        List<Worker> locationList = locationService.searchByString(searchWord);
        List<Worker> workerList = userRepository.findByNameIgnoreCaseContainingOrDescriptionIgnoreCaseContainingOrEmailIgnoreCaseContaining(searchWord, searchWord, searchWord);

        List<Worker> mergedList = Stream.concat(workerList.stream(), locationList.stream()).collect(Collectors.toList());

        for (Iterator<Worker> it = mergedList.iterator(); it.hasNext(); ) {
            Worker temp = it.next();
            if (!temp.getApproved()) {
                it.remove();
            } else {
                calculateRate(temp);
            }
        }
        return mergedList;
    }

    public Worker getWorker(Long id) {
        return calculateRate(userRepository.getOne(id));
    }

    public User getUser(Long id) throws UserNotFoundException {
        return (User) userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("No user found with id: " + id));
    }

    public void maintain() {
        Timestamp old = new Timestamp(System.currentTimeMillis());
        ZonedDateTime zonedDateTime = old.toInstant().atZone(ZoneId.of("UTC"));
        Timestamp yearless = Timestamp.from(zonedDateTime.minus(365, ChronoUnit.DAYS).toInstant());

        List<User> users = userRepository.findAllUsers();
        List<Worker> workers = userRepository.findAllWorkers();
        for (Worker worker : workers) {
            if (worker.getLastLogin().before(yearless)) {
                delete(worker.getId());
            }
        }
        for (User user : users) {
            if (user.getLastLogin().before(yearless)) {
                delete(user.getId());
            }
        }
    }

    private Worker calculateRate(Worker worker) {
        double rate = ratingService.calculateRating(worker);
        if (Double.isNaN(rate)) {
            worker.setRating(0.0);
        } else {
            worker.setRating(rate);
        }
        return worker;
    }

    public List<Worker> getTop5() {
        List<Worker> workerList = userRepository.findAllWorkers();
        workerList.sort((r1, r2) -> Integer.compare(r2.getRatings().size(), r1.getRatings().size()));
        List<Worker> top5 = workerList.subList(0, 5);

        for (Iterator<Worker> it = top5.iterator(); it.hasNext(); ) {
            Worker temp = it.next();
            if (!temp.getApproved()) {
                it.remove();
            } else {
                calculateRate(temp);
            }
        }
        return top5;
    }

    public User updateUser(User user) throws UserNotFoundException {
        User oldUser = (User) userRepository.findById(user.getId()).orElseThrow(() -> new UserNotFoundException("No user found with id: " + user.getId()));

        oldUser.setName(user.getName());
        oldUser.setEmail(user.getEmail());
        oldUser.setPhoneNum(user.getPhoneNum());
        oldUser.setLocation(user.getLocation());
        return userRepository.save(oldUser);
    }

    public Worker updateWorker(Worker worker) {
        Worker oldWorker = userRepository.getOne(worker.getId());

        oldWorker.setName(worker.getName());
        oldWorker.setDescription(worker.getDescription());
        oldWorker.setPhoneNum(worker.getPhoneNum());
        return userRepository.save(oldWorker);
    }

    public User favorite(Long workerId) {
        Worker worker = userRepository.getOne(workerId);
        User currentUser = (User) getLoggedInUser();
        List<Worker> favorites = currentUser.getFavorites();
        favorites.add(worker);
        currentUser.setFavorites(favorites);
        return userRepository.save(currentUser);
    }

    public User removeFavorite(Long workerId) {
        Worker worker = userRepository.getOne(workerId);
        User currentUser = (User) getLoggedInUser();
        List<Worker> favorites = currentUser.getFavorites();
        favorites.remove(worker);
        currentUser.setFavorites(favorites);
        return userRepository.save(currentUser);
    }

    public List<Worker> listFavorites() {
        User currentUser = (User) getLoggedInUser();
        List<Worker> favorites = currentUser.getFavorites();
        for (Worker favorite : favorites) {
            calculateRate(favorite);
        }
        return favorites;
    }

    public Worker approve(Long id) {
        Worker worker = userRepository.getOne(id);
        worker.setApproved(Boolean.TRUE);
        messageService.sendMessage(new Message(null, worker, "A profilja engedélyezve lett egy adminisztrátor által, most már megjelenik a listákban és keresésekben",
                "A profilja engedélyezve lett", null, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE));

        return userRepository.save(worker);
    }

    public void delete(Long id) {
        BaseUser user = userRepository.findPeopleById(id);
        if (user.getRole().getRole().equals("WORKER")) {
            Worker w = (Worker) user;
            List<User> listToEmpty = w.getUserList();
            for (User u : listToEmpty) {
                List<Worker> favorites = u.getFavorites();
                favorites.remove(w);
                u.setFavorites(favorites);
                userRepository.save(u);
            }
            listToEmpty.clear();
            w.setUserList(listToEmpty);
        }
        userRepository.delete(user);
    }

    public Admin registerAdmin(Admin admin, String pass) {
        admin.setRole(roleRepository.getOne(1L));
        admin.setPassword(pass);
        admin.setImgName(defaultimagename);
        return userRepository.save(admin);
    }

    public User registerUser(User user, String pass) {
        user.setRole(roleRepository.getOne(2L));
        user.setPassword(pass);
        user.setImgName(defaultimagename);
        return userRepository.save(user);
    }

    public Worker registerWorker(Worker worker, String pass) {
        worker.setRole(roleRepository.getOne(3L));
        worker.setPassword(pass);
        worker.setImgName(defaultimagename);
        return userRepository.save(worker);
    }

}
