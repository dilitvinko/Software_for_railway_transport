package railwayTransport.software.dto;

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

  private int number;
  private TypeCarriageDto typeCarriage;
  private long TrainId;

}
