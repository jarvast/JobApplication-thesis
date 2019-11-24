package jarvast.app.jobs.config;

import jarvast.app.jobs.entity.BaseUser;
import jarvast.app.jobs.repository.UserRepository;
import jarvast.app.jobs.service.UserService;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;

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

        MessageDigest md;
        try {
            md = MessageDigest.getInstance("MD5");
            byte[] temp = md.digest(password.getBytes());
            password = String.format("%032X", new BigInteger(1, temp));
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(CustomAuthProvider.class.getName()).log(Level.SEVERE, null, ex);
        }

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
