package jarvast.app.jobs.repository;

import jarvast.app.jobs.entity.BaseUser;
import jarvast.app.jobs.entity.Category;
import jarvast.app.jobs.entity.User;
import jarvast.app.jobs.entity.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<BaseUser, Long> {

    BaseUser findByUsername(String username);

    @Query("select a from BaseUser a WHERE User_Type = Worker")
    public List<Worker> findAllWorkers();

    @Query("select a from BaseUser a WHERE User_Type = User")
    List<User> findAllUsers();

    Optional<BaseUser> findById(Long id);

    BaseUser findPeopleById(Long id);

    List<Worker> findByCategory(Category category);

    List<Worker> findAllByNameContainingAllIgnoreCase(String searchword);

    List<Worker> findByNameIgnoreCaseContainingOrDescriptionIgnoreCaseContainingOrEmailIgnoreCaseContaining(String name, String desc, String email);

}
