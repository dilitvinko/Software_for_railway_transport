package railwayTransport.software.controller.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

@Component
@Log4j
public class ExceptionHandler implements HandlerExceptionResolver {

  //TODO обработка других исключений

  @Override
  public ModelAndView resolveException(HttpServletRequest httpServletRequest,
      HttpServletResponse httpServletResponse, Object o, Exception e) {
    log.info("Using ExceptionHandler");
    if ("EntityNotFoundException".equals(e.getClass().getSimpleName())) {
      log.error("Entity Not Found", e);
    }
    if ("EmptyResultDataAccessException".equals(e.getClass().getSimpleName())) {
      log.error("No entity exists", e);
    }
    return null;
  }
}
