package jarvast.app.jobs.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableGlobalMethodSecurity(securedEnabled = true)
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomAuthProvider myAuthProvider;

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(myAuthProvider);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                //.antMatchers("/login").hasAuthority("ADMIN")
                .antMatchers("/api/user/login").hasAnyAuthority("ADMIN", "USER", "WORKER")
                .antMatchers("/api/user/logout").hasAnyAuthority("ADMIN", "USER", "WORKER")
                //.anyRequest().permitAll()
                .and()//.formLogin().loginProcessingUrl("/api/user/login").permitAll().and()
                .httpBasic();

        /// http.logout().logoutUrl("/api/user/logout").invalidateHttpSession(true);
        http.csrf().disable();
        http.headers().frameOptions().disable();
    }
}
