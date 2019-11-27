package railwayTransport.software.entity.person;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import railwayTransport.software.entity.BaseEntity;
import railwayTransport.software.entity.ticket.Ticket;

@Entity
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Person extends BaseEntity implements UserDetails {

  
  private String name;
  private String surname;
  private String login;
  private String password;
  @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
  @CollectionTable(name = "person_role", joinColumns = @JoinColumn(name = "person_id"))
  @Enumerated(EnumType.STRING)
  private Set<Role> roles;
  @JsonManagedReference(value = "person-ticket")
  @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  private Set<Ticket> tickets;
  private int experience;


  //private boolean active;


  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return roles.stream()
        .map(role ->
            new SimpleGrantedAuthority(role.name())
        ).collect(Collectors.toList());
  }

  private static List<GrantedAuthority> mapToGrantedAuthorities(List<Role> userRoles) {
    return userRoles.stream()
        .map(role ->
            new SimpleGrantedAuthority(role.name())
        ).collect(Collectors.toList());
  }

  @Override
  public String getUsername() {
    return login;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }
}
