package railwayTransport.software.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TypeCarriageDto extends AbstractDto {

  private String type;
  private int amountSeats;
  private double cooffPrise;


}
