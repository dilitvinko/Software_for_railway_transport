package railwayTransport.software.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import railwayTransport.software.daoJPA.repository.CityRepository;
import railwayTransport.software.daoJPA.repository.ScheduleRepository;
import railwayTransport.software.dto.DateCitiesDTO;
import railwayTransport.software.dto.PairScheduleDTO;
import railwayTransport.software.entity.schedule.City;
import railwayTransport.software.service.ScheduleServiceImpl;

@RestController
@RequestMapping("/choose")
public class BuyTicketController {

  private final ScheduleRepository scheduleRepository;
  private final CityRepository cityRepository;
  private final ScheduleServiceImpl scheduleService;

  public BuyTicketController(
      ScheduleRepository scheduleRepository,
      CityRepository cityRepository,
      ScheduleServiceImpl scheduleService) {
    this.scheduleRepository = scheduleRepository;
    this.cityRepository = cityRepository;
    this.scheduleService = scheduleService;
  }

  @GetMapping("/test")
  public City test(){
    System.out.println(cityRepository.findByName("Minsk"));
    return cityRepository.findByName("Minsk");
  }

  @PostMapping("/test")
  public List<PairScheduleDTO> testPair(@RequestBody DateCitiesDTO dateCitiesDTO){
    System.out.println(cityRepository.findByName("Minsk"));
    dateCitiesDTO.setOutCity("Minsk");
    dateCitiesDTO.setInCity("Brest");
    return scheduleService.findAllTrainAtDateByCities(dateCitiesDTO);
  }

  @PostMapping
  public List<PairScheduleDTO> showSchedule(DateCitiesDTO dateCitiesDTO){
    return null;
  }

}
