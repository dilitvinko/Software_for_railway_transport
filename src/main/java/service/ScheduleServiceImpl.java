package service;

import com.ibm.icu.impl.Pair;
import dao.ScheduleDAOImpl;
import dto.DateCitiesDTO;
import dto.ScheduleDTO;
import entity.schedule.Schedule;
import java.util.List;
import service.interfaces.ScheduleService;

public class ScheduleServiceImpl extends AbstractService implements ScheduleService {

  public ScheduleServiceImpl() {
    abstractDAODB = new ScheduleDAOImpl();
  }

//    public List<Pair<Schedule, Schedule>> findAllTrainAtDateByCities(DateCitiesDTO dateCitiesDTO) {
//    return  new ScheduleDAOImpl().findAllTrainAtDateByCities(dateCitiesDTO.getDate(), dateCitiesDTO.getOutCity(), dateCitiesDTO.getInCity());
//    }

  public List<ScheduleDTO> findAllTrainAtDateByCities(DateCitiesDTO dateCitiesDTO) {
    List<Pair<Schedule, Schedule>> allTrainAtDateByCities = new ScheduleDAOImpl()
        .findAllTrainAtDateByCities(dateCitiesDTO.getDate(), dateCitiesDTO.getOutCity(),
            dateCitiesDTO.getInCity());
    return ScheduleDTO.convertFromListPairsShedule(allTrainAtDateByCities);
  }

}
