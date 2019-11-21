package railwayTransport.software.controller.util;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
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
    try {
      filterChain.doFilter(servletRequest, servletResponse);
    } catch (Exception e) {
      HttpServletResponse res = (HttpServletResponse) servletResponse;
      res.setHeader("exception", e.getCause().getMessage());
      res.setStatus(HttpServletResponse.SC_NOT_FOUND);
    }

  }

  @Override
  public void destroy() {

  }
}
