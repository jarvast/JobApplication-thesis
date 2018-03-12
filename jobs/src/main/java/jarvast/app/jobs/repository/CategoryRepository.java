package jarvast.app.jobs.repository;

import jarvast.app.jobs.entity.Category;
import java.io.Serializable;
import java.util.List;
import org.springframework.data.repository.CrudRepository;


public interface CategoryRepository extends CrudRepository<Category, Long>{
    
    public List<Category> findAll();
    
    public Category findBycategoryName(String name);
    
}
