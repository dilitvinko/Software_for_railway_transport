package railwayTransport.software.dto;

import java.sql.Time;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleDto extends AbstractDto {


  private CityDto city;
  private int drivingOrder;
  private Time time;
  private TrainDto train;


}
