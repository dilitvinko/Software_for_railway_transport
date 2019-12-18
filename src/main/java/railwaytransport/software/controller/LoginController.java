package railwaytransport.software.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:8081", maxAge = 3600)
public class LoginController {

  @PostMapping("/testLogin")
  public String testLogin1() {
    return "Success Post Login";
  }

}
