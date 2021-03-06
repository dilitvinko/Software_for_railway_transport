package railwaytransport.software.controller.corsfilter;//package railwaytransport.software.controller.corsfilter;

import static com.google.common.net.HttpHeaders.ACCEPT;
import static com.google.common.net.HttpHeaders.ACCESS_CONTROL_ALLOW_CREDENTIALS;
import static com.google.common.net.HttpHeaders.ACCESS_CONTROL_ALLOW_HEADERS;
import static com.google.common.net.HttpHeaders.ACCESS_CONTROL_ALLOW_METHODS;
import static com.google.common.net.HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN;
import static com.google.common.net.HttpHeaders.ACCESS_CONTROL_MAX_AGE;
import static com.google.common.net.HttpHeaders.AUTHORIZATION;
import static com.google.common.net.HttpHeaders.CONTENT_TYPE;
import static com.google.common.net.HttpHeaders.ORIGIN;
import static com.google.common.net.HttpHeaders.X_REQUESTED_WITH;
import static javax.ws.rs.HttpMethod.DELETE;
import static javax.ws.rs.HttpMethod.GET;
import static javax.ws.rs.HttpMethod.OPTIONS;
import static javax.ws.rs.HttpMethod.POST;
import static javax.ws.rs.HttpMethod.PUT;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CorsFilter2 implements Filter {

  private static final String DELIMITER = ", ";
  private static final String ACCESS_AGE = "3600";
  private static final String ALLOW_ORIGIN = "http://localhost:8081";

  @Autowired
  public CorsFilter2() {
  }

  @Override
  public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
      throws IOException, ServletException {
    HttpServletResponse response = (HttpServletResponse) res;
    HttpServletRequest request = (HttpServletRequest) req;
    response.setHeader(ACCESS_CONTROL_ALLOW_ORIGIN, ALLOW_ORIGIN);
    response.setHeader(ACCESS_CONTROL_ALLOW_METHODS,
        String.join(DELIMITER, POST, GET, PUT, OPTIONS, DELETE));
    response.setHeader(ACCESS_CONTROL_ALLOW_CREDENTIALS, Boolean.TRUE.toString());
    response.setHeader(ACCESS_CONTROL_MAX_AGE, ACCESS_AGE);
    response.setHeader(ACCESS_CONTROL_ALLOW_HEADERS,
        String.join(DELIMITER, ORIGIN, AUTHORIZATION, X_REQUESTED_WITH, CONTENT_TYPE, ACCEPT));

    if (OPTIONS.equalsIgnoreCase(request.getMethod())) {
      response.setStatus(HttpServletResponse.SC_OK);
    } else {
      chain.doFilter(req, res);
    }
  }
}