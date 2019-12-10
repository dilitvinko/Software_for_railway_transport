package railwayTransport.software.dto;

import java.util.Set;
import javax.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class TrainDto extends AbstractDto {

  @NotEmpty
  private String name;
  private Set<CarriageDto> carriages;


}
