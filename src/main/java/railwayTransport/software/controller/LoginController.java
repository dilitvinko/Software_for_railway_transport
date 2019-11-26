package railwayTransport.software.controller;

import javax.ws.rs.core.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import railwayTransport.software.dto.UserPasswordDTO;
import railwayTransport.software.entity.person.Person;
import railwayTransport.software.service.PersonServiceImpl;

@RestController
public class LoginController {

  @Autowired
  AuthenticationManager authenticationManager;

  @Autowired
  PersonServiceImpl personService;

  @GetMapping("/")
  public String helloPage (){
    return "Hello";
  }

  @GetMapping("/main")
  public String mainPage (){
    return "MainPage";
  }



  @PostMapping("/login")
  public String loginPost (@RequestBody Person person){

      String username = person.getLogin();
      authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, person.getPassword()));

    return "redirect:/main";
  }

}
