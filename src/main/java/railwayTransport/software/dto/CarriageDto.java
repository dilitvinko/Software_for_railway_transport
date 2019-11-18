package railwayTransport.software.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CarriageDto extends AbstractDto{

  private int number;
  private TypeCarriageDto typeCarriage;
  private long TrainId;
//  @JsonBackReference(value = "train-carriage")
//  private TrainDto train;


}
