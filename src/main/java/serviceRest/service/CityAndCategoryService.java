package serviceRest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import serviceRest.model.Category;
import serviceRest.model.City;
import serviceRest.repository.CategoryRepository;
import serviceRest.repository.CityRepository;
import java.util.List;

@Service
public class CityAndCategoryService {

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public List<City> findAllCities() {

        return cityRepository.findAll();
    }

    public List<Category> findAllCategories() {

        return categoryRepository.findAll();
    }

    public City findCityByName(String name) {
        return cityRepository.findCityByName(name);
    }

    public Category findCategoryByName(String name) {
        return categoryRepository.findByName(name);
    }


}
