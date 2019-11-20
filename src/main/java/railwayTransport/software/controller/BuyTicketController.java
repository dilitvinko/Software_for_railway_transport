package railwayTransport.software.controller;


import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import railwayTransport.software.controller.util.CookieManager;
import railwayTransport.software.dto.CarriageDto;
import railwayTransport.software.dto.DateCitiesDTO;
import railwayTransport.software.dto.PairScheduleDTO;
import railwayTransport.software.dto.ScheduleDto;
import railwayTransport.software.dto.TicketDto;
import railwayTransport.software.dto.TrainDto;
import railwayTransport.software.service.CarriageServiceImpl;
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

  public BuyTicketController(
      ScheduleServiceImpl scheduleService,
      TrainServiceImpl trainService,
      CarriageServiceImpl carriageService,
      TicketServiceImpl ticketService) {
    this.scheduleService = scheduleService;
    this.trainService = trainService;
    this.carriageService = carriageService;
    this.ticketService = ticketService;
  }

  @PostMapping("/schedule")
  public List<PairScheduleDTO> showScheduleAndTrain(@RequestBody DateCitiesDTO dateCitiesDTO,
      HttpServletResponse response) {

    List<PairScheduleDTO> pairScheduleDTOS = scheduleService
        .findAllTrainAtDateByCities(dateCitiesDTO);

    long idOutCity = 0;
    long idInCity = 0;
    if (!pairScheduleDTOS.isEmpty()) {
      idOutCity = pairScheduleDTOS.get(0).getOutScheduleDto().getCity().getId();
      idInCity = pairScheduleDTOS.get(0).getInScheduleDto().getCity().getId();
    }
    response.addCookie(new Cookie("idOutCity", String.valueOf(idOutCity)));
    response.addCookie(new Cookie("idInCity", String.valueOf(idInCity)));
    response.addCookie(new Cookie("date", String.valueOf(dateCitiesDTO.getDate())));

    return pairScheduleDTOS;
  }

  @PostMapping("/carriages")
  public List<CarriageDto> showCarriagesFromSelectedTrain(@RequestBody TrainDto trainDto,
      HttpServletResponse response) {
    long idTrain = trainDto.getId();
    response.addCookie(new Cookie("idTrain", String.valueOf(idTrain)));

    //TODO показывать цены в ваганоах относительно длины пути
    trainDto = trainService.findById(trainDto.getId());
    return new ArrayList<>(trainDto.getCarriages());
  }

  @PostMapping("/freeSeats")
  public List<Integer> showFreeSeatsFromSelectedCarriage(@RequestBody CarriageDto carriageDto,
      HttpServletRequest request, HttpServletResponse response) {

    Cookie[] cookies = request.getCookies();
    long idOutCity = CookieManager.getIdValueOfCookie(cookies, "idOutCity");
    long idInCity = CookieManager.getIdValueOfCookie(cookies, "idInCity");
    long idTrain = CookieManager.getIdValueOfCookie(cookies, "idTrain");
    Date date = CookieManager.getDateValueOfCookie(cookies, "date");

    Long idOutSchedule = scheduleService.findScheduleByTrainIdAndCityId(idTrain, idOutCity).getId();
    Long idInSchedule = scheduleService.findScheduleByTrainIdAndCityId(idTrain, idInCity).getId();

    ScheduleDto scheduleOutDto = scheduleService.findById(idOutSchedule);
    ScheduleDto scheduleInDto = scheduleService.findById(idInSchedule);

    response.addCookie(new Cookie("idCarriage", String.valueOf(carriageDto.getId())));
    response.addCookie(new Cookie("idOutSchedule", String.valueOf(scheduleOutDto.getId())));
    response.addCookie(new Cookie("idInSchedule", String.valueOf(scheduleInDto.getId())));

    return new ArrayList<>(
        ticketService.freeSeatsInCarriage(carriageDto, scheduleOutDto, scheduleInDto, date));
  }

  @PostMapping("/buyTicket")
  public TicketDto buyTicket(@RequestBody Integer numberSeat, HttpServletRequest request) {

    Cookie[] cookies = request.getCookies();
    long idOutSchedule = CookieManager.getIdValueOfCookie(cookies, "idOutSchedule");
    long idInSchedule = CookieManager.getIdValueOfCookie(cookies, "idInSchedule");
    long idCarriage = CookieManager.getIdValueOfCookie(cookies, "idCarriage");

    TicketDto ticketDto = new TicketDto();
    ticketDto.setNumberSeat(numberSeat);
    ticketDto.setDate(CookieManager.getDateValueOfCookie(cookies, "date"));
    ticketDto.setCarriage(carriageService.findById(idCarriage));
    ticketDto.setOutSchedule(scheduleService.findById(idOutSchedule));
    ticketDto.setInSchedule(scheduleService.findById(idInSchedule));
    ticketDto.setTrain(trainService.findById(CookieManager.getIdValueOfCookie(cookies, "idTrain")));
    ticketDto.setPrice(ticketService.calculatePrice(idOutSchedule, idInSchedule, idCarriage));
    //ticketDto.setPerson();

    return ticketService.create(ticketDto);
  }


}
