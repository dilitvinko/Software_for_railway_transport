package railwayTransport.software.dto;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
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

  @NotEmpty
  private String type;
  @DecimalMin("1")
  @DecimalMax("100")
  private int amountSeats;
  @DecimalMin("0")
  private double cooffPrise;

}
