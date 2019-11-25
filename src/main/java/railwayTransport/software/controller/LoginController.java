package railwayTransport.software.controller;

import javax.ws.rs.core.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import railwayTransport.software.dto.UserPasswordDTO;

@RestController
public class LoginController {

  @GetMapping("/")
  public String helloPage (){
    return "Hello";
  }

  @GetMapping("/main")
  public String mainPage (){
    return "MainPage";
  }

  @GetMapping("/login")
  public String loginGet (){
    return "Login Get";
  }

  @PostMapping("/login")
  public String loginPost (@RequestBody UserPasswordDTO userPasswordDTO){
    return "Login Post";
  }

}
