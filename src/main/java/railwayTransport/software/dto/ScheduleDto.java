package railwayTransport.software.dto;

import java.sql.Time;
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

  private CityDto city;
  private int drivingOrder;
  private Time time;
  private TrainDto train;

}
