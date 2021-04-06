package serviceRest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import serviceRest.dto.LoginRequest;
import serviceRest.dto.RegisterRequest;
import serviceRest.service.AuthService;
import serviceRest.utils.validation.RegisterRequestValidator;
import javax.validation.Valid;
import java.io.IOException;



@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private RegisterRequestValidator validator;

    @PostMapping("/signup")
    public ResponseEntity<String> signupWithValidation(@Valid @RequestBody RegisterRequest request) throws IOException {
        return returnValidationState(request);
    }

    @GetMapping("/signup/create")
    public String createPage() {
        return "some frontend to get user input";
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginRequest) {
        return authService.login(loginRequest);
    }


    //TODO: make it correct
    public ResponseEntity<String> returnValidationState(RegisterRequest request) {
        switch (validator.returnValidationState(request)) {
            case E_MAIL_USED:
                return new ResponseEntity("E-Mail already used", HttpStatus.BAD_REQUEST);
            case PASSWORDS_NOT_EQUAL:
                return new ResponseEntity("Passwords should be equal", HttpStatus.BAD_REQUEST);
            case NOT_AN_ADULT:
                return new ResponseEntity("Should be an adult", HttpStatus.BAD_REQUEST);
            case SUCCESS:
                authService.signUp(request);
                return new ResponseEntity("Registration successful", HttpStatus.OK);
            default:
                throw new UnknownError();

        }
    }

}


