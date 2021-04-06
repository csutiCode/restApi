package serviceRest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import serviceRest.dto.LoginRequest;
import serviceRest.dto.RegisterRequest;
import serviceRest.model.User;
import serviceRest.repository.UserRepository;
import serviceRest.security.JwtTokenProvider;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    public void signUp(RegisterRequest request) {
        User user = mapRequestToUser(request);
        userRepository.save(user);
    }

    public User mapRequestToUser(RegisterRequest request) {
        User user = new User();
        user.setEmail(request.getEmail());
        //hashes the password
        user.setPassword(encodePassword(request.getPassword()));
        user.setCreatedOn(LocalDate.now());
        //user.setDateOfBirth(request.getDateOfBirth());
        return user;
    }

    //returns encrypted password
    private String encodePassword(String password) {
        return passwordEncoder.encode(password);
    }

    //to log in
    public String login(LoginRequest loginRequest) {
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(),
                loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authenticate);
        return jwtTokenProvider.generateToken(authenticate);
    }
    public Optional<org.springframework.security.core.userdetails.User> getCurrentUser() {
        org.springframework.security.core.userdetails.User principal = (org.springframework.security.core.userdetails.User) SecurityContextHolder.
                getContext().getAuthentication().getPrincipal();
        return Optional.of(principal);
    }



}
