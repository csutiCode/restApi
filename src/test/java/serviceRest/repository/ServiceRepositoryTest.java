package serviceRest.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import serviceRest.model.ServiceAccount;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


//important annotation to get the beans
@SpringBootTest
public class ServiceRepositoryTest {


    @Autowired
    private ServiceRepository serviceRepository;

    @Test
    public void shouldReturnListOfServices() {
        List<ServiceAccount> result = serviceRepository.findAll();
        assertThat(result.get(0)).isInstanceOf(ServiceAccount.class);

    }
}
