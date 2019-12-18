package railwaytransport.software.controller.util;

import com.google.gson.Gson;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import railwaytransport.software.controller.util.exceptiondto.ExceptionDTO;

@Component
@Slf4j
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {


  @Override
  public void commence(HttpServletRequest request,
      HttpServletResponse response, AuthenticationException e)
      throws IOException {
    log.error(e.getClass().getName(), e);
    response.setContentType("application/json;charset=UTF-8");
    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
    ExceptionDTO exceptionDTO = new ExceptionDTO(request.getRequestURL().toString(),
        Timestamp.valueOf(
            LocalDateTime.now()), HttpStatus.UNAUTHORIZED.value(), "Unauthorized", e.getMessage());
    response.getWriter().write(new Gson().toJson(exceptionDTO));
  }
}
