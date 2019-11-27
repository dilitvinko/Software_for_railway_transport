package railwayTransport.software.controller;


import java.sql.Date;
import java.util.List;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import railwayTransport.software.dto.BuyTicketDto;
import railwayTransport.software.dto.CarriageFreeSeatsPriceDTO;
import railwayTransport.software.dto.FreeSeatsDTO;
import railwayTransport.software.dto.PairScheduleDTO;
import railwayTransport.software.dto.TicketDto;
import railwayTransport.software.entity.person.Person;
import railwayTransport.software.service.CarriageServiceImpl;
import railwayTransport.software.service.PersonServiceImpl;
import railwayTransport.software.service.ScheduleServiceImpl;
import railwayTransport.software.service.TicketServiceImpl;
import railwayTransport.software.service.TrainServiceImpl;
import railwayTransport.software.service.interfaces.BuyTicketService;

@RestController
public class BuyTicketController {


  private final ScheduleServiceImpl scheduleService;
  private final TicketServiceImpl ticketService;
  private final BuyTicketService buyTicketService;

  public BuyTicketController(
      ScheduleServiceImpl scheduleService,
      TicketServiceImpl ticketService,
      BuyTicketService buyTicketService) {
    this.scheduleService = scheduleService;
    this.ticketService = ticketService;
    this.buyTicketService = buyTicketService;
  }

  @GetMapping("/schedule/choose")
  public List<PairScheduleDTO> showScheduleAndTrain(@RequestParam Date date,
      @RequestParam String outCity, @RequestParam
      String inCity) {

    return scheduleService.findAllTrainAtDateByCities(date, outCity, inCity);
  }

  @GetMapping("/carriage/choose")
  public List<CarriageFreeSeatsPriceDTO> showCarriagesFromSelectedTrain(@RequestParam Long idTrain,
      @RequestParam Date date, @RequestParam String outCity, @RequestParam String inCity) {

    return buyTicketService.findCarriageFreeSeatsPrice(idTrain, date, outCity, inCity);
  }

  @GetMapping("/freeSeat/choose")
  public FreeSeatsDTO showFreeSeatsFromSelectedCarriage(@RequestParam Long idCarriage,
      @RequestParam Long idTrain, @RequestParam Date date, @RequestParam String outCity,
      @RequestParam String inCity) {

    return ticketService
        .findFreeSeatsInCarriage(idCarriage, idTrain, date, outCity, inCity);
  }

  @PostMapping("/buyTicket")
  public TicketDto buyTicket(@RequestBody @Validated BuyTicketDto buyTicketDto) {

    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    Person currentPrincipal = (Person) authentication.getPrincipal();
    buyTicketDto.setIdPerson(currentPrincipal.getId());

    return buyTicketService.buyTicket(buyTicketDto);
  }




}
