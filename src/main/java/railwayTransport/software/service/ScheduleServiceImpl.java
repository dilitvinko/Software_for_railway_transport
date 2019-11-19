package railwayTransport.software.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import railwayTransport.software.daoJPA.repository.CityRepository;
import railwayTransport.software.daoJPA.repository.ScheduleRepository;
import railwayTransport.software.dto.DateCitiesDTO;
import railwayTransport.software.dto.PairScheduleDTO;
import railwayTransport.software.dto.ScheduleDto;
import railwayTransport.software.dto.mapper.ScheduleMapper;
import railwayTransport.software.dto.mapper.TrainMapper;
import railwayTransport.software.entity.schedule.Schedule;
import railwayTransport.software.service.interfaces.ScheduleService;

@Service
public class ScheduleServiceImpl implements ScheduleService {

  private final ScheduleRepository scheduleRepository;
  private final ScheduleMapper scheduleMapper;
  private final CityRepository cityRepository;
  private final TrainMapper trainMapper;

  public ScheduleServiceImpl(
      ScheduleRepository scheduleRepository, ScheduleMapper scheduleMapper,
      CityRepository cityRepository, TrainMapper trainMapper) {
    this.scheduleRepository = scheduleRepository;
    this.scheduleMapper = scheduleMapper;
    this.cityRepository = cityRepository;
    this.trainMapper = trainMapper;
  }


  @Override
  public List<ScheduleDto> findAll() {
    return scheduleMapper.listScheduleToListScheduleDto(scheduleRepository.findAll());
  }

  @Override
  public ScheduleDto findById(long id) {
    return scheduleMapper.scheduleToScheduleDto(scheduleRepository.getOne(id));
  }

  @Override
  public boolean deleteById(long id) {
    boolean flag = false;
    try {
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
    Schedule schedule = scheduleMapper.scheduleDtoToSchedule(dto);
    try {
      scheduleRepository.delete(schedule);
      flag = true;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return flag;
  }

  @Override
  public ScheduleDto create(ScheduleDto dto) {
    Schedule schedule = scheduleMapper.scheduleDtoToSchedule(dto);
    scheduleRepository.saveAndFlush(schedule);
    dto = scheduleMapper.scheduleToScheduleDto(schedule);
    return dto;
  }

  @Override
  public ScheduleDto update(ScheduleDto dto) {
    Schedule schedule = scheduleMapper.scheduleDtoToSchedule(dto);
    scheduleRepository.saveAndFlush(schedule);
    dto = scheduleMapper.scheduleToScheduleDto(schedule);
    return dto;
  }

  public List<PairScheduleDTO> findAllTrainAtDateByCities(
      DateCitiesDTO dateCitiesDTO) {
    //TODO обработать ошибки если не найдет в базе города
    long idOutCity = 0;
    long idInCity = 0;
    try {
      idOutCity = cityRepository.findByName(dateCitiesDTO.getOutCity()).getId();
      idInCity = cityRepository.findByName(dateCitiesDTO.getInCity()).getId();
    } catch (Exception e) {
      e.printStackTrace();
    }
    //TODO как грамотно сделать этот запрос в БД
    List<Schedule> schedules = scheduleRepository.findSchedulesByCityIdOrCityId(idOutCity, idInCity);
    List<PairScheduleDTO> pairScheduleDTOS = new ArrayList<>();
    for (int i = 0; i < schedules.size(); i++) {
      for (int j = 0; j < schedules.size(); j++) {
        if (idOutCity == schedules.get(i).getCity().getId() &&
            idInCity == schedules.get(j).getCity().getId() &&
            schedules.get(i).getTrain().getId() == schedules.get(j).getTrain().getId() &&
            schedules.get(i).getDrivingOrder() < schedules.get(j).getDrivingOrder()
        ) {
          PairScheduleDTO pairScheduleDTO = new PairScheduleDTO();
          pairScheduleDTO.setTrainDto(trainMapper.trainToTrainDto(schedules.get(i).getTrain()));
          pairScheduleDTO.setOutScheduleDto(scheduleMapper.scheduleToScheduleDto(schedules.get(i)));
          pairScheduleDTO.setInScheduleDto(scheduleMapper.scheduleToScheduleDto(schedules.get(j)));
          pairScheduleDTOS.add(pairScheduleDTO);
        }
      }
    }

    return pairScheduleDTOS;//new ScheduleDAOImpl().findAllTrainAtDateByCities(dateCitiesDTO.getDate(), dateCitiesDTO.getOutCity(), dateCitiesDTO.getInCity());
  }

  public ScheduleDto findScheduleByTrainIdAndCityId(long trainId, long cityId){
    return scheduleMapper.scheduleToScheduleDto(scheduleRepository.findScheduleByTrainIdAndCityId(trainId, cityId));
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
