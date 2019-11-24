package jarvast.app.jobs.repository;

import jarvast.app.jobs.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    List<Category> findAll();

    Category findByCategoryName(String name);

}
