package dto;

import entity.schedule.Schedule;
import entity.train.Train;
import com.ibm.icu.impl.Pair;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class ScheduleDTO {

    private Train train;
    private long idInShedule;
    private long idOutShedule;
    private Time outTime;
    private Time inTime;

    public ScheduleDTO() {
    }

    public ScheduleDTO(Train train, long idInShedule, long idOutShedule, Time outTime, Time inTime) {
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
        return "ScheduleDTO{" +
                "train=" + train +
                ", idInShedule=" + idInShedule +
                ", idOutShedule=" + idOutShedule +
                ", outTime=" + outTime +
                ", inTime=" + inTime +
                '}';
    }
    public static List<ScheduleDTO> convertFromListPairsShedule(List<Pair<Schedule, Schedule>> allTrainAtDateByCities){
        List<ScheduleDTO> scheduleDTOS = new ArrayList<>();
        for (Pair<Schedule, Schedule> pair :
                allTrainAtDateByCities) {
            ScheduleDTO scheduleDTO = new ScheduleDTO();
            scheduleDTO.setTrain(pair.first.getTrain());
            scheduleDTO.setIdOutShedule(pair.first.getId());
            scheduleDTO.setIdInShedule(pair.second.getId());
            scheduleDTO.setOutTime(pair.first.getTime());
            scheduleDTO.setInTime(pair.second.getTime());
            scheduleDTOS.add(scheduleDTO);
        }
        return scheduleDTOS;
    }
}
