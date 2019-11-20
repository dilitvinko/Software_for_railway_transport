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
public class TypeCarriageDto extends AbstractDto {

  private String type;
  private int amountSeats;
  private double cooffPrise;

}
