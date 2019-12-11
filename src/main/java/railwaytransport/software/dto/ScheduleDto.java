package railwaytransport.software.dto;

import java.sql.Time;
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
public class ScheduleDto extends AbstractDto {

  @NotEmpty
  private CityDto city;
  @DecimalMin("1")
  private int drivingOrder;
  @NotEmpty
  private Time time;
  @NotEmpty
  private TrainDto train;

}
