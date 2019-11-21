package railwayTransport.software.dto;

import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import railwayTransport.software.entity.person.Role;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class PersonDto extends AbstractDto {

  private String name;
  private String surname;
  private String login;
  private String password;
  private Set<Role> roles;

  private Set<TicketDto> tickets;
  private int experience;


}
