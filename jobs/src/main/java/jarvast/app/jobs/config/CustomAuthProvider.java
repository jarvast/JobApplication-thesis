package jarvast.app.jobs.config;

import jarvast.app.jobs.entity.BaseUser;
import jarvast.app.jobs.repository.UserRepository;
import jarvast.app.jobs.service.UserService;
import java.util.Collection;
import java.util.HashSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;


@Component
public class CustomAuthProvider implements AuthenticationProvider {

    private UserRepository userRepository;
    private UserService userService;

    @Autowired
    public CustomAuthProvider(UserRepository userRepository, UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }

    @Override
    public Authentication authenticate(Authentication auth) throws AuthenticationException {
        BaseUser user = null;
        String username = auth.getPrincipal() + "";
        String password = auth.getCredentials() + "";
        try {
            user = userRepository.findByUsername(username);
        } catch (Exception e) {
            System.out.println("Username not found");
        }

        if (user == null) {
            throw new UsernameNotFoundException(String.format("Invalid credentials" + username, username));
        }
        Collection<GrantedAuthority> authorities = new HashSet<>();
        if (user.getPassword().equals(password)) {
            authorities.add(new SimpleGrantedAuthority(user.getRole().getRole()));
        }
        this.userService.login(user);

        return new UsernamePasswordAuthenticationToken(username, password, authorities);
    }

    @Override
    public boolean supports(Class<?> type) {
        return true;
    }

}
