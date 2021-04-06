package serviceRest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import serviceRest.model.City;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {




    //@Query(value="select a from city a where a.name= :name")
    City findCityByName(String name);

}
