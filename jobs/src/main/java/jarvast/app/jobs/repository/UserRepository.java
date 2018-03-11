package jarvast.app.jobs.repository;

import jarvast.app.jobs.entity.BaseUser;
import jarvast.app.jobs.entity.Worker;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<BaseUser, Long> {

    public BaseUser findByUsername(String username);
    
    @Query("select a from BaseUser a WHERE User_Type = Worker")
    public List<Worker> findAllWorkers();

   /* @Override
    public <S extends BaseUser> S save(S s);*/
    
    
}
