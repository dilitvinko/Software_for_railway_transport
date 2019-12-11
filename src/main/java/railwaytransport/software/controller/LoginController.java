package railwaytransport.software.controller;

import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import railwaytransport.software.entity.train.Train;

@RestController
@CrossOrigin(origins = "http://localhost:8081", maxAge = 3600)
public class LoginController {

  @PostMapping("/test")
  public String testLogin1() {
    return "Post Login";
  }

  @GetMapping("/test")
  public String testLogin2() {
    return "Get Login";
  }

  @GetMapping("/log")
  public String loginPage() {
    return "You are log in";
  }

}
