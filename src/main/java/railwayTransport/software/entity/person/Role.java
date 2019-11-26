package railwayTransport.software.entity.person;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
  USER,
  ADMIN,
  CREATERTIMETABLES;

  @Override
  public String getAuthority() {
    return name();
  }
}
