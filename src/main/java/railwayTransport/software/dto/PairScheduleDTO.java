package railwayTransport.software.dto;

import com.ibm.icu.impl.Pair;
import railwayTransport.software.entity.schedule.Schedule;
import railwayTransport.software.entity.train.Train;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class PairScheduleDTO {

  private Train train;
  private long idInShedule;
  private long idOutShedule;
  private Time outTime;
  private Time inTime;

  public PairScheduleDTO() {
  }

  public PairScheduleDTO(Train train, long idInShedule, long idOutShedule, Time outTime, Time inTime) {
    this.train = train;
    this.idInShedule = idInShedule;
    this.idOutShedule = idOutShedule;
    this.outTime = outTime;
    this.inTime = inTime;
  }

  public Train getTrain() {
    return train;
  }

  public void setTrain(Train train) {
    this.train = train;
  }

  public long getIdInShedule() {
    return idInShedule;
  }

  public void setIdInShedule(long idInShedule) {
    this.idInShedule = idInShedule;
  }

  public long getIdOutShedule() {
    return idOutShedule;
  }

  public void setIdOutShedule(long idOutShedule) {
    this.idOutShedule = idOutShedule;
  }

  public Time getOutTime() {
    return outTime;
  }

  public void setOutTime(Time outTime) {
    this.outTime = outTime;
  }

  public Time getInTime() {
    return inTime;
  }

  public void setInTime(Time inTime) {
    this.inTime = inTime;
  }

  @Override
  public String toString() {
    return "PairScheduleDTO{" +
        "train=" + train +
        ", idInShedule=" + idInShedule +
        ", idOutShedule=" + idOutShedule +
        ", outTime=" + outTime +
        ", inTime=" + inTime +
        '}';
  }

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
