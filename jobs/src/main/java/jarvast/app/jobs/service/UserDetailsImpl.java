package jarvast.app.jobs.service;

import jarvast.app.jobs.config.HeaderUsernamePasswordAuthenticationFilter;
import jarvast.app.jobs.entity.Role;
import jarvast.app.jobs.entity.User;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


public class UserDetailsImpl implements UserDetails{
    
    private User user;
    
    @Autowired
    HeaderUsernamePasswordAuthenticationFilter headerUsernamePasswordAuthenticationFilter;

    public UserDetailsImpl(User user) {
        this.user=user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> authorities = new HashSet<>();
        /*Set<Role> roles = user.getRole();
        for (Role role : roles){
            authorities.add(new SimpleGrantedAuthority(role.getRole()));
        }*/
        authorities.add(new SimpleGrantedAuthority(user.getRole().getRole()));
        System.out.println("dsdsa" + authorities.toString());
        return authorities;
    }

    @Override
    public String getPassword() {
        //return headerUsernamePasswordAuthenticationFilter.getPasswordParameter();
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        //return headerUsernamePasswordAuthenticationFilter.getUsernameParameter();
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
    
}
