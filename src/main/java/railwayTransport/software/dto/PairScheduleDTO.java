package railwayTransport.software.dto;

import com.ibm.icu.impl.Pair;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import railwayTransport.software.entity.schedule.Schedule;
import railwayTransport.software.entity.train.Train;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PairScheduleDTO {

  private Train train;
  private ScheduleDto outScheduleDto;
  private ScheduleDto inScheduleDto;
  private Time outTime;
  private Time inTime;



  public static List<PairScheduleDTO> convertFromListPairsShedule(
      List<Pair<Schedule, Schedule>> allTrainAtDateByCities) {
    List<PairScheduleDTO> pairScheduleDTOS = new ArrayList<>();
    for (Pair<Schedule, Schedule> pair :
        allTrainAtDateByCities) {
      PairScheduleDTO pairScheduleDTO = new PairScheduleDTO();
      pairScheduleDTO.setTrain(pair.first.getTrain());
//      pairScheduleDTO.setIdOutShedule(pair.first.getId());
//      pairScheduleDTO.setIdInShedule(pair.second.getId());
      pairScheduleDTO.setOutTime(pair.first.getTime());
      pairScheduleDTO.setInTime(pair.second.getTime());
      pairScheduleDTOS.add(pairScheduleDTO);
    }
    return pairScheduleDTOS;
  }
}
