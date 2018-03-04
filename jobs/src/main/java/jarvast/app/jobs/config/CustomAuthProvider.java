/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jarvast.app.jobs.config;

import jarvast.app.jobs.entity.Role;
import jarvast.app.jobs.entity.User;
import jarvast.app.jobs.repository.UserRepository;
import jarvast.app.jobs.service.UserDetailsImpl;
import jarvast.app.jobs.service.UserService;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 *
 * @author TomiPC
 */
@Component
public class CustomAuthProvider implements AuthenticationProvider{
    
   /* @Autowired
    private HeaderUsernamePasswordAuthenticationFilter headerUsernamePasswordAuthenticationFilter;*/
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private UserService userService;
    
    
   /* public CustomAuthProvider(UserRepository userRepository) {
        this.userRepository = userRepository;
    } */
    

    @Override
    public Authentication authenticate(Authentication auth) throws AuthenticationException {
       User user = null;
           String username = auth.getPrincipal() + "";
            String password = auth.getCredentials() + "";
            System.out.println("User " + username);
            System.out.println("P: " + password);
       try{
           user = userRepository.findByUsername(username);
       }catch (Exception e ){
           System.out.println("Username not found");
       }
       
          if (user == null) {
        throw new UsernameNotFoundException(String.format("Invalid credentials", username));
          }
          Collection<GrantedAuthority> authorities = new HashSet<>();
          if (user.getPassword().equals(password)){
              /*Set<Role> roles = user.getRoles();
                for (Role role : roles){
                    authorities.add(new SimpleGrantedAuthority(role.getRole()));
                }*/
              authorities.add(new SimpleGrantedAuthority(user.getRole().getRole()));
          }
          System.out.println("MOSTANI" + user.toString());
          this.userService.login(user);
       
        return new UsernamePasswordAuthenticationToken(username, password, authorities);
        /*    } else if (!user.isEnabled()) {
        throw new UsernameNotFoundException(String.format("Not found enabled user for username ", user.getUsername()));*/
       /* User user = userRepository.findByUsername(headerUsernamePasswordAuthenticationFilter.getUsernameParameter());
        String name = auth.getName();
        String pass = auth.getCredentials().toString();
        
        System.out.println("name" + name + "pass " + pass);
        
        User user2 = userRepository.findByUsername(name);
        UserDetailsImpl userdetails = new UserDetailsImpl(user2);
        
        return new UsernamePasswordAuthenticationToken(userdetails.getUsername(), userdetails.getPassword(), userdetails.getAuthorities());*/
        
        
        /*if(user == null){
            throw new AuthenticationException("Could not find user with ID: ") {};
        }
        return user;*/
    }
        /*return new UsernamePasswordAuthenticationToken(new UserDetailsImpl
        auth.
        (new User(headerUsernamePasswordAuthenticationFilter.getUsernameParameter(), headerUsernamePasswordAuthenticationFilter.getPasswordParameter())));
    }*/

    @Override
    public boolean supports(Class<?> type) {
        return true;
    }
    
}
