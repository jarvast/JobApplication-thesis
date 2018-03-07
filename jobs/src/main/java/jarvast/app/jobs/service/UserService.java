package jarvast.app.jobs.service;

import jarvast.app.jobs.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService<T> {

    private UserRepository userRepository;
    private T user;

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
    public void login(T user) {
        this.user = user;
    }

    public T getLoggedInUser() {
        return user;
    }

    public void logout() {
        this.user = null;
    }

}
