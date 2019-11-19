package railwayTransport.software.controller.util;

import java.sql.Date;
import javax.servlet.http.Cookie;

public class CookieManager {

  public static int getIdValueOfCookie(Cookie[] cookies, String nameCookie){
    String resValue = "";
    for (Cookie cookie :
        cookies) {
      if (cookie.getName().equals(nameCookie)) {
        resValue = cookie.getValue();
      }
    }
    return Integer.parseInt(resValue);
  }

  public static Date getDateValueOfCookie(Cookie[] cookies, String nameCookie){
    String resValue = "";
    for (Cookie cookie :
        cookies) {
      if (cookie.getName().equals(nameCookie)) {
        resValue = cookie.getValue();
      }
    }
    return Date.valueOf(resValue);
  }

}
