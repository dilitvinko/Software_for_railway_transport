package railwaytransport.software.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import railwaytransport.software.daojpa.repository.CityRepository;
import railwaytransport.software.daojpa.repository.ScheduleRepository;
import railwaytransport.software.dto.PairScheduleDTO;
import railwaytransport.software.dto.ScheduleDto;
import railwaytransport.software.dto.mapper.ScheduleMapper;
import railwaytransport.software.dto.mapper.TrainMapper;
import railwaytransport.software.entity.schedule.Schedule;
import railwaytransport.software.exception.CityNotFoundException;
import railwaytransport.software.service.interfaces.ScheduleService;

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
  public void deleteById(long id) {
    scheduleRepository.deleteById(id);
  }

  @Override
  public void delete(ScheduleDto dto) {
    Schedule schedule = scheduleMapper.scheduleDtoToSchedule(dto);
    scheduleRepository.delete(schedule);
  }

  @Override
  public ScheduleDto create(ScheduleDto dto) {
    dto.setId(null);
    Schedule schedule = scheduleMapper.scheduleDtoToSchedule(dto);
    scheduleRepository.saveAndFlush(schedule);
    dto = scheduleMapper.scheduleToScheduleDto(schedule);
    return dto;
  }

  @Override
  public ScheduleDto update(ScheduleDto dto) {
    Schedule schedule = scheduleMapper.scheduleDtoToSchedule(dto);
    if (null == scheduleRepository.getOne(schedule.getId())) {
      throw new EntityNotFoundException();
    }
    scheduleRepository.saveAndFlush(schedule);
    dto = scheduleMapper.scheduleToScheduleDto(schedule);
    return dto;
  }

  public List<PairScheduleDTO> findAllTrainAtDateByCities(Date date, String outCity,
      String inCity) {
    //TODO обработать ошибки если не найдет в базе города
    if (cityRepository.findByName(outCity) == null || cityRepository.findByName(inCity) == null){
      throw new CityNotFoundException();
    }


    long idOutCity = cityRepository.findByName(outCity).getId();
    long idInCity = cityRepository.findByName(inCity).getId();

    //TODO как грамотно сделать этот запрос в БД
    List<Schedule> schedules = scheduleRepository
        .findSchedulesByCityIdOrCityId(idOutCity, idInCity);
    List<PairScheduleDTO> pairScheduleDTOS = new ArrayList<>();
    for (int i = 0; i < schedules.size(); i++) {
      for (Schedule schedule : schedules) {
        if (idOutCity == schedules.get(i).getCity().getId() &&
            idInCity == schedule.getCity().getId() &&
            schedules.get(i).getTrain().getId() == schedule.getTrain().getId() &&
            schedules.get(i).getDrivingOrder() < schedule.getDrivingOrder()
        ) {
          PairScheduleDTO pairScheduleDTO = new PairScheduleDTO();
          pairScheduleDTO.setTrain(trainMapper.trainToTrainDto(schedules.get(i).getTrain()));
          pairScheduleDTO.setOutSchedule(scheduleMapper.scheduleToScheduleDto(schedules.get(i)));
          pairScheduleDTO.setInSchedule(scheduleMapper.scheduleToScheduleDto(schedule));
          pairScheduleDTOS.add(pairScheduleDTO);
        }
      }
    }

    return pairScheduleDTOS;
  }

  public ScheduleDto findScheduleByTrainIdAndCityId(long trainId, long cityId) {
    return scheduleMapper
        .scheduleToScheduleDto(scheduleRepository.findScheduleByTrainIdAndCityId(trainId, cityId));
  }

}
