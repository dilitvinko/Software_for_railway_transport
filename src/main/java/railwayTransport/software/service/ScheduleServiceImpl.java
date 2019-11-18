package railwayTransport.software.service;

import com.ibm.icu.impl.Pair;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;
import railwayTransport.software.daoJPA.repository.ScheduleRepository;
import railwayTransport.software.dto.DateCitiesDTO;
import railwayTransport.software.dto.PairScheduleDTO;
import railwayTransport.software.dto.ScheduleDto;
import railwayTransport.software.dto.mapper.ScheduleMapper;
import railwayTransport.software.entity.schedule.Schedule;
import railwayTransport.software.service.interfaces.ScheduleService;

@Service
public class ScheduleServiceImpl implements ScheduleService {

  private final ScheduleRepository scheduleRepository;
  private final ScheduleMapper mapper;

  public ScheduleServiceImpl(
      ScheduleRepository scheduleRepository, ScheduleMapper mapper) {
    this.scheduleRepository = scheduleRepository;
    this.mapper = mapper;
  }


  @Override
  public List<ScheduleDto> findAll() {
    return mapper.listScheduleToListScheduleDto(scheduleRepository.findAll());
  }

  @Override
  public ScheduleDto findById(long id) {
    return mapper.scheduleToScheduleDto(scheduleRepository.getOne(id));
  }

  @Override
  public boolean deleteById(long id) {
    boolean flag = false;
    try{
      scheduleRepository.deleteById(id);
      flag = true;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return flag;
  }

  @Override
  public boolean delete(ScheduleDto dto) {
    boolean flag = false;
    Schedule schedule = mapper.scheduleDtoToCarriage(dto);
    try{
      scheduleRepository.delete(schedule);
      flag = true;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return flag;
  }

  @Override
  public ScheduleDto create(ScheduleDto dto) {
    Schedule schedule = mapper.scheduleDtoToCarriage(dto);
    scheduleRepository.saveAndFlush(schedule);
    dto = mapper.scheduleToScheduleDto(schedule);
    return dto;
  }

  @Override
  public ScheduleDto update(ScheduleDto dto) {
    Schedule schedule = mapper.scheduleDtoToCarriage(dto);
    scheduleRepository.saveAndFlush(schedule);
    dto = mapper.scheduleToScheduleDto(schedule);
    return dto;
  }

//    public List<Pair<Schedule, Schedule>> findAllTrainAtDateByCities(DateCitiesDTO dateCitiesDTO) {
//    return  new ScheduleDAOImpl().findAllTrainAtDateByCities(dateCitiesDTO.getDate(), dateCitiesDTO.getOutCity(), dateCitiesDTO.getInCity());
//    }
//
//  public List<PairScheduleDTO> findAllTrainAtDateByCities(DateCitiesDTO dateCitiesDTO) {
//    List<Pair<Schedule, Schedule>> allTrainAtDateByCities = new ScheduleDAOImpl()
//        .findAllTrainAtDateByCities(dateCitiesDTO.getDate(), dateCitiesDTO.getOutCity(),
//            dateCitiesDTO.getInCity());
//    return PairScheduleDTO.convertFromListPairsShedule(allTrainAtDateByCities);
//  }

}
