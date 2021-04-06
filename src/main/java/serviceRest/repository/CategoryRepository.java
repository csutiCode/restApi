package serviceRest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import serviceRest.model.Category;

import java.util.List;


@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {


    Category findByName(String name);
}
