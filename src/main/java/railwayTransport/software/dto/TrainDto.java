package railwayTransport.software.dto;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TrainDto extends AbstractDto {

  private String name;
  @JsonManagedReference(value = "train-carriage")
  private Set<CarriageDto> carriages;


}
