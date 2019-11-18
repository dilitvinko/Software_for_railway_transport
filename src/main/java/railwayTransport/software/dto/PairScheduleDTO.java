package railwayTransport.software.dto;

import com.ibm.icu.impl.Pair;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import railwayTransport.software.entity.schedule.Schedule;
import railwayTransport.software.entity.train.Train;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PairScheduleDTO {

  private Train train;
  private long idInShedule;
  private long idOutShedule;
  private Time outTime;
  private Time inTime;



  public static List<PairScheduleDTO> convertFromListPairsShedule(
      List<Pair<Schedule, Schedule>> allTrainAtDateByCities) {
    List<PairScheduleDTO> pairScheduleDTOS = new ArrayList<>();
    for (Pair<Schedule, Schedule> pair :
        allTrainAtDateByCities) {
      PairScheduleDTO pairScheduleDTO = new PairScheduleDTO();
      pairScheduleDTO.setTrain(pair.first.getTrain());
      pairScheduleDTO.setIdOutShedule(pair.first.getId());
      pairScheduleDTO.setIdInShedule(pair.second.getId());
      pairScheduleDTO.setOutTime(pair.first.getTime());
      pairScheduleDTO.setInTime(pair.second.getTime());
      pairScheduleDTOS.add(pairScheduleDTO);
    }
    return pairScheduleDTOS;
  }
}
