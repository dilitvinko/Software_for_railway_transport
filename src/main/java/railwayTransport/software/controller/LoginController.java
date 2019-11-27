package railwayTransport.software.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import railwayTransport.software.entity.person.Person;
import railwayTransport.software.service.PersonServiceImpl;

@RestController
public class LoginController {

  @Autowired
  AuthenticationManager authenticationManager;

  @Autowired
  PersonServiceImpl personService;

  @GetMapping("/")
  public String helloPage() {
    return "Hello";
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
