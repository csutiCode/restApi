package serviceRest.utils.validation;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import serviceRest.controller.AuthController;
import serviceRest.dto.RegisterRequest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;



@SpringBootTest
@AutoConfigureMockMvc
public class RegisterRequestValidatorTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private AuthController authController;


    @Test
    public void shouldValidate() {

        RegisterRequest request = new RegisterRequest("email","password");

    }


}
