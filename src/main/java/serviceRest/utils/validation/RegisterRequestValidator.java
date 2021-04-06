package serviceRest.utils.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import serviceRest.dto.RegisterRequest;
import serviceRest.repository.UserRepository;
import java.time.*;
import java.time.temporal.ChronoUnit;

import static serviceRest.utils.validation.RegisterRequestValidationState.*;

@Component
public class RegisterRequestValidator {


    @Autowired
    private UserRepository userRepository;

    public  boolean isEmailNotUsed(RegisterRequest request) {
        return (userRepository.findUserByEmail(request.getEmail()) == null);
    }

    public boolean arePasswordsEqual(RegisterRequest request) {
        String password = request.getPassword();
        String confirmedPassword = request.getConfirmedPassword();
        return password.equals(confirmedPassword);
    }

    public boolean isAdult(LocalDate dateOfBirth) {
        LocalDate today = LocalDate.now();
        if (dateOfBirth.isAfter(today)) {
            System.out.println("Date in future - invalid.");
            return false;
        } else {
            int age = (int) ChronoUnit.YEARS.between(dateOfBirth, today);
            if (age < 18) {
                return false;
            } else {
                return true;
            }
        }
    }

    public  RegisterRequestValidationState returnValidationState(RegisterRequest request) {
       if (!isEmailNotUsed(request)) {
           return E_MAIL_USED;
       } else if (!arePasswordsEqual(request)) {
           return PASSWORDS_NOT_EQUAL;
        } else if (!isAdult(request.getDateOfBirth())) {
           return NOT_AN_ADULT;
       } else {
           return SUCCESS;
       }
    }


}


















