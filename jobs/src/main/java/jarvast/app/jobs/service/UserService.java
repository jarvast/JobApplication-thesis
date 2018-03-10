package jarvast.app.jobs.service;

import jarvast.app.jobs.entity.BaseUser;
import jarvast.app.jobs.entity.Worker;
import jarvast.app.jobs.repository.UserRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService<T> {

    private UserRepository userRepository;
    //private T user;
    private BaseUser user;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.user = null;
    }

    /*public BaseUser findByUsername(String username) {
        return userRepository.findByUsername(username);
    }*/

 /*@Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        BaseUser user = findByUsername(username);
        if (user == null){
            throw new UsernameNotFoundException(username);
        }
        System.out.println(user.getRoles().toString() + user.getPassword());
        return new UserDetailsImpl(user);
    }*/
    /*public void login(T user) {
        this.user = user;
    }

    public T getLoggedInUser() {
        return user;
    }*/
    public void login(BaseUser user){
        this.user=user;
    }
    public BaseUser getLoggedInUser(){
        return user;
    }
    public long getloggedId(){
        return user.getId();
    }
    public void updateImg(String name){
        user.setImgName(name);
        System.out.println(user.toString());
        userRepository.save(user);
    }
    public String getImg(){
        return this.user.getImgName();
    }
    /*public T getLoggedInUserId() {
        return (T) (BaseUser) user;
    }*/

    public void logout() {
        this.user = null;
    }

    public void test() {
        System.out.println("BENT VOK");
        ArrayList<Worker> arr = (ArrayList<Worker>) userRepository.findAllWorkers();
        for (Worker w : arr){
            System.out.println(w.toString());
        }
    }
    public List<Worker> getWorkers(){
        return userRepository.findAllWorkers();
    }

}
