package jarvast.app.jobs.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableGlobalMethodSecurity(securedEnabled = true)
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    
    
    @Autowired
    private CustomAuthProvider myAuthProvider;
    
    //@Autowired
    @Override
    public void configure (AuthenticationManagerBuilder auth) throws Exception{
        /*System.out.println("ASDASASD");
        auth.authenticationProvider(myAuthProvider);*/
      /*auth.inMemoryAuthentication()
      .withUser("admin").password("admin1").roles("ADMIN");*/
       // auth.userDetailsService(userService);
        auth.authenticationProvider(myAuthProvider);
    }
    
    @Override
    protected void configure (HttpSecurity http) throws Exception{
        /*http.addFilterBefore(new HeaderUsernamePasswordAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)
                .authorizeRequests()s
                .antMatchers("/h2/**").hasAuthority("ADMIN")
                .antMatchers("/fukk").permitAll()
                .antMatchers("/admin/**").hasAuthority("USER")
                .anyRequest().authenticated()
                .and()
            .formLogin().disable();
        
        http.csrf().disable();
        http.headers().frameOptions().disable();*/
        http//.addFilterBefore(new HeaderUsernamePasswordAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)
                .authorizeRequests()
            //.antMatchers("/login").hasAuthority("ADMIN")
                .antMatchers("/api/user/login").hasAnyAuthority("ADMIN","USER","WORKER")
                .antMatchers("/api/user/logout").hasAnyAuthority("ADMIN","USER","WORKER")
            //.anyRequest().permitAll()
            .and()//.formLogin().loginProcessingUrl("/api/user/login").permitAll().and()
            .httpBasic();
        
       /// http.logout().logoutUrl("/api/user/logout").invalidateHttpSession(true);
        http.csrf().disable();
        http.headers().frameOptions().disable();
    }
}
