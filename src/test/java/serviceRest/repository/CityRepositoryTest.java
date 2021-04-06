package serviceRest.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import serviceRest.model.City;
import serviceRest.model.ServiceAccount;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class CityRepositoryTest {

    @Autowired
    private CityRepository cityRepository;

    @Test
    public void shouldReturnACity() {
       City city = cityRepository.findCityByName("Vienna");
       assertThat(city).isInstanceOf(City.class);

    }
}
