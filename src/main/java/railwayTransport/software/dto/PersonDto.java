package railwayTransport.software.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import railwayTransport.software.entity.person.Role;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonDto extends  AbstractDto{

  private String name;
  private String surname;
  private String login;
  private String password;
  private Set<Role> roles;
  @JsonManagedReference(value = "person-ticket")
  private Set<TicketDto> tickets;
  private int experience;


}
