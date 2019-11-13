//package railwayTransport.software.service;
//
//import com.ibm.icu.impl.Pair;
//import railwayTransport.software.daoJDBC.ScheduleDAOImpl;
//import railwayTransport.software.dto.DateCitiesDTO;
//import railwayTransport.software.dto.PairScheduleDTO;
//import railwayTransport.software.entity.schedule.Schedule;
//import java.util.List;
//import railwayTransport.software.service.interfaces.ScheduleService;
//
//public class ScheduleServiceImpl extends AbstractService implements ScheduleService {
//
//  public ScheduleServiceImpl() {
//    jpaRepository = new ScheduleDAOImpl();
//  }
//
////    public List<Pair<Schedule, Schedule>> findAllTrainAtDateByCities(DateCitiesDTO dateCitiesDTO) {
////    return  new ScheduleDAOImpl().findAllTrainAtDateByCities(dateCitiesDTO.getDate(), dateCitiesDTO.getOutCity(), dateCitiesDTO.getInCity());
////    }
//
//  public List<PairScheduleDTO> findAllTrainAtDateByCities(DateCitiesDTO dateCitiesDTO) {
//    List<Pair<Schedule, Schedule>> allTrainAtDateByCities = new ScheduleDAOImpl()
//        .findAllTrainAtDateByCities(dateCitiesDTO.getDate(), dateCitiesDTO.getOutCity(),
//            dateCitiesDTO.getInCity());
//    return PairScheduleDTO.convertFromListPairsShedule(allTrainAtDateByCities);
//  }
//
//}
