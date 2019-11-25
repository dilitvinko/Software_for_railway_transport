package railwayTransport.software.controller;

import javax.ws.rs.core.Response;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import railwayTransport.software.dto.UserPasswordDTO;

@RestController
public class LoginController {

  @PostMapping("/login")
  public @ResponseBody Response login (@RequestBody UserPasswordDTO userPasswordDTO){
    return Response.status(Response.Status.OK.getStatusCode()).build();
  }

}
