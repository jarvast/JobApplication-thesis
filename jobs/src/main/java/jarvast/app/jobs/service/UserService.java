package jarvast.app.jobs.service;

import jarvast.app.jobs.entity.User;
import jarvast.app.jobs.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService {// implements UserDetailsService{
    
    private UserRepository userRepository;
    
    //@Autowired
    private User user;
    
    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository=userRepository;
    }
    
    public User findByUsername(String username){
        return userRepository.findByUsername(username);
    }

    /*@Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = findByUsername(username);
        if (user == null){
            throw new UsernameNotFoundException(username);
        }
        System.out.println(user.getRoles().toString() + user.getPassword());
        return new UserDetailsImpl(user);
    }*/

    public void login(User user) {
        this.user = user;
        System.out.println("thisservice" + this.user.toString());
    }

    public User getLoggedInUser() {
        return user;
    }

    public void logout() {
        this.user=null;
    }
    
}
