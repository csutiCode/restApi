package serviceRest.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import serviceRest.model.ServiceAccount;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class ServiceServiceTest {

    @Autowired
    private ServiceAccountService serviceService;

    @Test
    public void shouldReturnListOfServices() {
        List<ServiceAccount> result = serviceService.findAllServices();
        assertThat(result.get(0)).isInstanceOf(ServiceAccount.class);
    }
}
