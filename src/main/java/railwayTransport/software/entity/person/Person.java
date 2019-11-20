package railwayTransport.software.entity.person;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
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
import railwayTransport.software.entity.BaseEntity;
import railwayTransport.software.entity.ticket.Ticket;

@Entity
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Person extends BaseEntity {

  private String name;
  private String surname;
  private String login;
  private String password;
  @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
  @CollectionTable(name = "person_role", joinColumns = @JoinColumn(name = "person_id"))
  @Enumerated(EnumType.STRING)
  private Set<Role> roles;
  @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  private Set<Ticket> tickets;
  private int experience;


}
