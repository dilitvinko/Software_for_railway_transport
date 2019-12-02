package railwayTransport.software.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import railwayTransport.software.entity.person.Person;
import railwayTransport.software.service.PersonServiceImpl;

@RestController
@CrossOrigin(origins = "http://localhost:8081", maxAge = 3600)
public class LoginController {

  @Autowired
  private AuthenticationManager authenticationManager;

  @Autowired
  private PersonServiceImpl personService;

//  @GetMapping("/")
//  public String helloPage() {
//    return "Hello";
//  }

  @PostMapping("/test")
  public String testLogin1() {

//    authenticationManager.authenticate(
//        new UsernamePasswordAuthenticationToken(person.getLogin(), person.getPassword()));

    return "Post Login";
  }
  @GetMapping("/test")
  public String testLogin2() {

//    authenticationManager.authenticate(
//        new UsernamePasswordAuthenticationToken(person.getLogin(), person.getPassword()));

    return "Get Login";
  }

  @GetMapping("/log")
  public String loginPage(){
    return "You are log in";
  }

  @GetMapping("/main")
  public String mainPage() {
    return "Get Main";
  }

  @PostMapping("/login")
  public String loginPost(@RequestBody Person person) {

//    authenticationManager.authenticate(
//        new UsernamePasswordAuthenticationToken(person.getLogin(), person.getPassword()));

    return "Post Login";
  }

}
