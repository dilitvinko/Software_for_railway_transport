package railwaytransport.software.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import railwaytransport.software.controller.util.CustomAccessDeniedHandler;
import railwaytransport.software.controller.util.CustomAuthenticationEntryPoint;
import railwaytransport.software.service.PersonServiceImpl;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  private final PersonServiceImpl personService;

  public WebSecurityConfig(PersonServiceImpl personService) {
    this.personService = personService;
  }

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
        .antMatchers("/registration").permitAll()
        .anyRequest()
        .authenticated();

    http.exceptionHandling().accessDeniedHandler(accessDeniedHandler());
    http.exceptionHandling().authenticationEntryPoint(authenticationEntryPoint());
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

  @Bean
  public AccessDeniedHandler accessDeniedHandler(){
    return new CustomAccessDeniedHandler();
  }

  @Bean
  public AuthenticationEntryPoint authenticationEntryPoint(){
    return new CustomAuthenticationEntryPoint();
  }


}
