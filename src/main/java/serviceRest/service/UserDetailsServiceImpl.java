package serviceRest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import serviceRest.exceptions.EmailNotFoundException;
import serviceRest.model.User;
import serviceRest.repository.UserRepository;

import java.util.Collection;
import java.util.Collections;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    //Username is the email!!!
    @Override
    public UserDetails loadUserByUsername(String email) throws EmailNotFoundException {
        User user = userRepository.findByEmail(email).orElseThrow(() ->
                new EmailNotFoundException("No user found " + email));
        return new org.springframework.security.core.userdetails.User(user.getEmail(),
                user.getPassword(),
                true, true, true, true,
                getAuthorities("ROLE_USER"));
    }

    private Collection<? extends GrantedAuthority> getAuthorities(String role_user) {
        return Collections.singletonList(new SimpleGrantedAuthority(role_user));
    }

}
