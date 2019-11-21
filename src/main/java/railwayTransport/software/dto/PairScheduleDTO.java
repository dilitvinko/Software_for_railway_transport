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
public class PairScheduleDTO {

  private TrainDto trainDto;
  private ScheduleDto outScheduleDto;
  private ScheduleDto inScheduleDto;

}
