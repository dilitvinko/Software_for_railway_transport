package railwaytransport.software.dto;

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

  private TrainDto train;
  private ScheduleDto outSchedule;
  private ScheduleDto inSchedule;

}
