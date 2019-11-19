package railwayTransport.software.controller.util;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

@Component
public class ExceptionFilter implements Filter {

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {

  }

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
      FilterChain filterChain) throws IOException, ServletException {
    try{
      filterChain.doFilter(servletRequest, servletResponse);
    }catch (Exception e) {
      HttpServletResponse res = (HttpServletResponse) servletResponse;
      res.setHeader("exception", e.getCause().getMessage());
      //Почему конфликт
      res.setStatus(HttpServletResponse.SC_CONFLICT);
    }

  }

  @Override
  public void destroy() {

  }
}
