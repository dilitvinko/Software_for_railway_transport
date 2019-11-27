package railwayTransport.software.dto;

import java.util.Set;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
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

  @NotBlank
  private String name;
  @NotBlank
  private String surname;
  @NotBlank
  private String login;
  @NotBlank
  private String password;
  @NotEmpty
  private Set<Role> roles;
  private Set<TicketDto> tickets;
  private int experience;


}
