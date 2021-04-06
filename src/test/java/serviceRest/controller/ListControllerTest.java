package serviceRest.controller;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import serviceRest.model.ServiceAccount;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
@AutoConfigureMockMvc
public class ListControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ListController listController;


    @Test
    public void shouldReturnListOfServices() {
        List<ServiceAccount> result = listController.findAll();
        assertThat(result.get(0)).isInstanceOf(ServiceAccount.class);

    }




}
