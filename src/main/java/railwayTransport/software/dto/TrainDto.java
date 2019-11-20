package railwayTransport.software.dto;


import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;


@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class TrainDto extends AbstractDto {

  private String name;
  private Set<CarriageDto> carriages;


}
