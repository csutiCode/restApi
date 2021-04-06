package serviceRest.utils.validation;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.LocalDate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@SpringBootTest
public class RegisterRequestValidatorTest {

    @Autowired
    private RegisterRequestValidator validator;

    @ParameterizedTest
    @ValueSource(strings = {"1991-10-08", "1956-12-04","2012-12-02"})
    public void isAdultTest(String stringDate) {
        LocalDate birthDate = LocalDate.parse(stringDate);
        assertThat(validator.isAdult(birthDate));

    }



}
