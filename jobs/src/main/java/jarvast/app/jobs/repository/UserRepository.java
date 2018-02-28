package jarvast.app.jobs.repository;

import jarvast.app.jobs.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long>{
    
    User findByUsername(String username);
}
