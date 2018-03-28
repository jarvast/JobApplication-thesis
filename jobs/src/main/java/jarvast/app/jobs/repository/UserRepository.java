package jarvast.app.jobs.repository;

import jarvast.app.jobs.entity.BaseUser;
import jarvast.app.jobs.entity.Category;
import jarvast.app.jobs.entity.User;
import jarvast.app.jobs.entity.Worker;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<BaseUser, Long> {

    public BaseUser findByUsername(String username);

    @Query("select a from BaseUser a WHERE User_Type = Worker")
    public List<Worker> findAllWorkers();

    public Worker findOne(Long id);
    public User findById(Long id);
    public BaseUser findPeopleById(Long id);

    public List<Worker> findByCategory(Category category);

    public List<Worker> findAllByNameContainingAllIgnoreCase(String searchword);

    List<Worker> findByNameIgnoreCaseContainingOrDescriptionIgnoreCaseContainingOrEmailIgnoreCaseContaining(String name, String desc, String email);

}
