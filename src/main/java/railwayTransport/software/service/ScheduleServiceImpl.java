package railwayTransport.software.service;

import java.util.List;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import railwayTransport.software.daoJPA.repository.ScheduleRepository;
import railwayTransport.software.dto.ScheduleDto;
import railwayTransport.software.entity.schedule.Schedule;
import railwayTransport.software.service.interfaces.ScheduleService;

public class ScheduleServiceImpl implements ScheduleService {

  private final ScheduleRepository scheduleRepository;
  private final ModelMapper modelMapper;

  public ScheduleServiceImpl(
      ScheduleRepository scheduleRepository, ModelMapper modelMapper) {
    this.scheduleRepository = scheduleRepository;
    this.modelMapper = modelMapper;
  }


  @Override
  public List<ScheduleDto> findAll() {
    List<Schedule> schedules = scheduleRepository.findAll();
    return modelMapper.map(schedules, new TypeToken<List<ScheduleDto>>() {
    }.getType());
  }

  @Override
  public ScheduleDto findById(long id) {
    return modelMapper.map(scheduleRepository.getOne(id), new TypeToken<ScheduleDto>() {
    }.getType());
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
  public boolean delete(ScheduleDto entity) {
    boolean flag = false;
    Schedule schedule = modelMapper.map(entity, new TypeToken<ScheduleDto>() {
    }.getType());
    try{
      scheduleRepository.delete(schedule);
      flag = true;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return flag;
  }

  @Override
  public ScheduleDto create(ScheduleDto entity) {
    Schedule schedule = new Schedule();
    modelMapper.map(entity, schedule);
    scheduleRepository.saveAndFlush(schedule);
    entity = modelMapper.map(schedule, new TypeToken<ScheduleDto>() {
    }.getType());
    return entity;
  }

  @Override
  public ScheduleDto update(ScheduleDto entity) {
    Schedule schedule = new Schedule();
    modelMapper.map(entity, schedule);
    scheduleRepository.saveAndFlush(schedule);
    entity = modelMapper.map(schedule, new TypeToken<ScheduleDto>() {
    }.getType());
    return entity;
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
