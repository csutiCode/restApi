package serviceRest.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import serviceRest.model.City;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class CityAndCategoryTestService {

    @Autowired
    private CityAndCategoryService cityAndCategoryService;

    @Test
    public void shouldReturnACity() {
        City city = cityAndCategoryService.findCityByName("Vienna");
        assertThat(city).isInstanceOf(City.class);
    }
}
