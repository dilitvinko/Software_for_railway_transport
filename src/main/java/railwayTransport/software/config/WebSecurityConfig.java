package railwayTransport.software.config;

import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import railwayTransport.software.service.PersonServiceImpl;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  private PersonServiceImpl personService;

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
        .httpBasic()
        .and()
        .csrf().disable()
        .authorizeRequests()
        .antMatchers("/trains/**").hasAnyAuthority("ADMIN", "CREATERTIMETABLES")
        .antMatchers("/cities/**").hasAnyAuthority("ADMIN", "CREATERTIMETABLES")
        .antMatchers("/carriages/**").hasAnyAuthority("ADMIN", "CREATERTIMETABLES")
        .antMatchers("/typeCarriages/**").hasAnyAuthority("ADMIN", "CREATERTIMETABLES")
        .antMatchers("/tickets/**").hasAnyAuthority("ADMIN", "CREATERTIMETABLES")
        .antMatchers("/schedules/**").hasAnyAuthority("ADMIN", "CREATERTIMETABLES")
        .antMatchers("/persons/**").hasAuthority("ADMIN")
        .antMatchers("/login").permitAll()
        .antMatchers("/registration").permitAll()
        .anyRequest().authenticated();
  }


  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(personService)
        .passwordEncoder(NoOpPasswordEncoder.getInstance());

  }

  @Bean
  @Override
  public AuthenticationManager authenticationManagerBean() throws Exception {
    return super.authenticationManagerBean();
  }





}
