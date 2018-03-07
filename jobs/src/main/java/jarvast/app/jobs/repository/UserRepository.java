package jarvast.app.jobs.repository;

import jarvast.app.jobs.entity.BaseUser;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<BaseUser, Long> {

    public BaseUser findByUsername(String username);
}
