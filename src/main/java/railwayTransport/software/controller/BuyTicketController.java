package railwayTransport.software.controller;


import java.sql.Date;
import java.util.List;
import java.util.Set;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import railwayTransport.software.dto.BuyTicketDto;
import railwayTransport.software.dto.CarriageDto;
import railwayTransport.software.dto.CarriageTrainCitiesDateDto;
import railwayTransport.software.dto.DateCitiesDTO;
import railwayTransport.software.dto.PairScheduleDTO;
import railwayTransport.software.dto.ScheduleDto;
import railwayTransport.software.dto.TicketDto;
import railwayTransport.software.dto.TrainDto;
import railwayTransport.software.service.CarriageServiceImpl;
import railwayTransport.software.service.PersonServiceImpl;
import railwayTransport.software.service.ScheduleServiceImpl;
import railwayTransport.software.service.TicketServiceImpl;
import railwayTransport.software.service.TrainServiceImpl;

@RestController
@RequestMapping("/choose")
public class BuyTicketController {


  private final ScheduleServiceImpl scheduleService;
  private final TrainServiceImpl trainService;
  private final CarriageServiceImpl carriageService;
  private final TicketServiceImpl ticketService;
  private final PersonServiceImpl personService;

  public BuyTicketController(
      ScheduleServiceImpl scheduleService,
      TrainServiceImpl trainService,
      CarriageServiceImpl carriageService,
      TicketServiceImpl ticketService,
      PersonServiceImpl personService) {
    this.scheduleService = scheduleService;
    this.trainService = trainService;
    this.carriageService = carriageService;
    this.ticketService = ticketService;
    this.personService = personService;
  }

  @GetMapping("/schedule")
  public List<PairScheduleDTO> showScheduleAndTrain(
      @RequestParam Date date, @RequestParam String outCity, @RequestParam String inCity) {

    return scheduleService.findAllTrainAtDateByCities(
        DateCitiesDTO.builder().date(date).outCity(outCity).inCity(inCity).build());
  }

  @GetMapping("/carriages")
  public Set<CarriageDto> showCarriagesFromSelectedTrain(
      @RequestBody PairScheduleDTO pairScheduleDTO) {

    //TODO показывать цены в ваганоах относительно длины пути
    TrainDto trainDto = trainService.findById(pairScheduleDTO.getTrain().getId());
    return trainDto.getCarriages();
  }

  @PostMapping("/freeSeats")
  public Set<Integer> showFreeSeatsFromSelectedCarriage(
      @RequestBody CarriageTrainCitiesDateDto carriageTrainCitiesDateDto) {

    //TODO всё это рефактор скорее всего в один метод и поработать грамотно с сущностями DTO
    ScheduleDto scheduleOutDto = scheduleService
        .findScheduleByTrainIdAndCityId(carriageTrainCitiesDateDto.getIdTrain(),
            carriageTrainCitiesDateDto.getIdOutCity());
    ScheduleDto scheduleInDto = scheduleService
        .findScheduleByTrainIdAndCityId(carriageTrainCitiesDateDto.getIdTrain(),
            carriageTrainCitiesDateDto.getIdInCity());

    return ticketService
        .freeSeatsInCarriage(carriageTrainCitiesDateDto, scheduleOutDto, scheduleInDto);
  }

  @PostMapping("/buyTicket")
  public TicketDto buyTicket(@RequestBody BuyTicketDto buyTicketDto) {

    TicketDto ticketDto = TicketDto.builder()
        .numberSeat(buyTicketDto.getNumberSeat())
        .carriage(carriageService.findById(buyTicketDto.getIdCarriage()))
        .train(trainService.findById(buyTicketDto.getIdTrain()))
        .outSchedule(scheduleService.findById(buyTicketDto.getIdOutSchedule()))
        .inSchedule(scheduleService.findById(buyTicketDto.getIdInSchedule()))
        .date(buyTicketDto.getDate())
        .price(ticketService
            .calculatePrice(buyTicketDto.getIdOutSchedule(), buyTicketDto.getIdInSchedule(),
                buyTicketDto.getIdCarriage()))
        .idPerson(personService.findById(buyTicketDto.getIdPerson()).getId())
        .build();

    return ticketService.create(ticketDto);
  }


}
