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
import railwayTransport.software.dto.CarriageFreeSeatsPriceDTO;
import railwayTransport.software.dto.PairScheduleDTO;
import railwayTransport.software.dto.TicketDto;
import railwayTransport.software.dto.TrainDto;
import railwayTransport.software.service.CarriageServiceImpl;
import railwayTransport.software.service.PersonServiceImpl;
import railwayTransport.software.service.ScheduleServiceImpl;
import railwayTransport.software.service.TicketServiceImpl;
import railwayTransport.software.service.TrainServiceImpl;
import railwayTransport.software.service.interfaces.BuyTicketService;

@RestController
@RequestMapping("/choose")
public class BuyTicketController {


  private final ScheduleServiceImpl scheduleService;
  private final TrainServiceImpl trainService;
  private final CarriageServiceImpl carriageService;
  private final TicketServiceImpl ticketService;
  private final PersonServiceImpl personService;
  private final BuyTicketService buyTicketService;

  public BuyTicketController(
      ScheduleServiceImpl scheduleService,
      TrainServiceImpl trainService,
      CarriageServiceImpl carriageService,
      TicketServiceImpl ticketService,
      PersonServiceImpl personService,
      BuyTicketService buyTicketService) {
    this.scheduleService = scheduleService;
    this.trainService = trainService;
    this.carriageService = carriageService;
    this.ticketService = ticketService;
    this.personService = personService;
    this.buyTicketService = buyTicketService;
  }

  @GetMapping("/schedule")
  public List<PairScheduleDTO> showScheduleAndTrain(@RequestParam Date date,
      @RequestParam String outCity, @RequestParam
      String inCity) {

    return scheduleService.findAllTrainAtDateByCities(date, outCity, inCity);
  }

  @GetMapping("/carriages")
  public List<CarriageFreeSeatsPriceDTO> showCarriagesFromSelectedTrain(
      @RequestParam Long idTrain, @RequestParam Date date,
      @RequestParam String outCity, @RequestParam
      String inCity) {

    //TODO показывать цены в ваганоах относительно длины пути

    return buyTicketService.findCarriageFreeSeatsPrice(idTrain, date, outCity, inCity);
  }

  @PostMapping("/freeSeats")
  public Set<Integer> showFreeSeatsFromSelectedCarriage(@RequestParam Long idCarriage,
      @RequestParam Long idTrain, @RequestParam Date date, @RequestParam String outCity,
      @RequestParam String inCity) {

    //TODO всё это рефактор скорее всего в один метод и поработать грамотно с сущностями DTO

    return ticketService
        .findFreeSeatsInCarriage(idCarriage, idTrain, date, outCity, inCity);
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
//        .price(ticketService
//            .calculatePrice(buyTicketDto.getIdOutSchedule(), buyTicketDto.getIdInSchedule(),
//                buyTicketDto.getIdCarriage()))
        .idPerson(personService.findById(buyTicketDto.getIdPerson()).getId())
        .build();

    return ticketService.create(ticketDto);
  }


}
