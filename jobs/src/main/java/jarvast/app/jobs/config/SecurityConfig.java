package jarvast.app.jobs.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@EnableGlobalMethodSecurity(securedEnabled = true)
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    
    @Autowired
    private UserDetailsService userService;
    
    @Autowired
    public void configureAuth (AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(userService);
    }
    
    @Override
    protected void configure (HttpSecurity http) throws Exception{
        http.authorizeRequests()
                .antMatchers("/h2/**").hasAuthority("ADMIN")
                .antMatchers("/fukk").permitAll()
                .antMatchers("/admin/**").hasAuthority("USER")
                .anyRequest().authenticated()
                .and()
            .formLogin().permitAll();
        
        http.csrf().disable();
        http.headers().frameOptions().disable();
    }
}
