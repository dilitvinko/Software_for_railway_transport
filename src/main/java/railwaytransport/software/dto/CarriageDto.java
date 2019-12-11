package railwaytransport.software.dto;

import javax.validation.constraints.NotNull;
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
public class CarriageDto extends AbstractDto {

  @NotNull
  private int number;
  private TypeCarriageDto typeCarriage;
  @NotNull
  private Long idTrain;

}
