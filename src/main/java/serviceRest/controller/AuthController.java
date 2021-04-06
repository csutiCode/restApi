package serviceRest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import serviceRest.dto.LoginRequest;
import serviceRest.dto.RegisterRequest;
import serviceRest.exceptions.InvalidRequestException;
import serviceRest.service.AuthService;
import serviceRest.utils.validation.RegisterRequestValidator;

import javax.servlet.http.HttpServletResponse;
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
    public ResponseEntity signupWithValidation( @Valid @RequestBody RegisterRequest request) throws IOException {
        if (isValid(request)) {
            authService.signUp(request);
            return new ResponseEntity(HttpStatus.OK);
        } else {
            throw new InvalidRequestException("Password not equal, Email used or not an adult");
        }
    }

    @GetMapping("/signup/create")
    public String createPage() {
        return "some frontend to get user input";
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginRequest) {
        return authService.login(loginRequest);
    }

    public boolean isValid(RegisterRequest request) {
        return validator.isValidRequest(request);
    }













}
