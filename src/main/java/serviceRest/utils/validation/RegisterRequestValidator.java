package serviceRest.utils.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import serviceRest.dto.RegisterRequest;
import serviceRest.repository.UserRepository;

@Component
public class RegisterRequestValidator {


    @Autowired
    private UserRepository userRepository;


    public  boolean isEmailTaken(RegisterRequest request) {
        return (userRepository.findByEmail(request.getEmail()) == null);
    }

    public boolean arePasswordsEqual(String password, String confirmedPassword) {
        return password.equals(confirmedPassword);
    }

    public  boolean isValidRequest(RegisterRequest request) {
        return //isEmailTaken(request) &&
                arePasswordsEqual(request.getPassword(), request.getConfirmedPassword());
    }










}


















