package railwaytransport.software.controller;


import java.sql.Date;
import java.util.List;
import java.util.Set;
import javax.validation.Valid;
import lombok.extern.log4j.Log4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import railwaytransport.software.dto.BuyTicketDto;
import railwaytransport.software.dto.CarriageFreeSeatsPriceDTO;
import railwaytransport.software.dto.FreeSeatsDTO;
import railwaytransport.software.dto.PairScheduleDTO;
import railwaytransport.software.dto.TicketDto;
import railwaytransport.software.entity.person.Person;
import railwaytransport.software.service.PersonServiceImpl;
import railwaytransport.software.service.ScheduleServiceImpl;
import railwaytransport.software.service.TicketServiceImpl;
import railwaytransport.software.service.interfaces.BuyTicketService;

@Log4j
@RestController
public class BuyTicketController {


  private final ScheduleServiceImpl scheduleService;
  private final TicketServiceImpl ticketService;
  private final BuyTicketService buyTicketService;
  private final PersonServiceImpl personService;

  public BuyTicketController(
      ScheduleServiceImpl scheduleService,
      TicketServiceImpl ticketService,
      BuyTicketService buyTicketService,
      PersonServiceImpl personService) {
    this.scheduleService = scheduleService;
    this.ticketService = ticketService;
    this.buyTicketService = buyTicketService;
    this.personService = personService;
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

  @PostMapping("/ticket/buy")
  public TicketDto buyTicket(@Valid BuyTicketDto buyTicketDto) {

    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    Person currentPrincipal = (Person) authentication.getPrincipal();
    buyTicketDto.setIdPerson(currentPrincipal.getId());

    return buyTicketService.buyTicket(buyTicketDto);
  }

  @GetMapping("/you/tickets")
  public Set<TicketDto> getTicketsFromPerson() {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    Person currentPrincipal = (Person) authentication.getPrincipal();
    log.info("Get Dto by id =  " + currentPrincipal.getId());
    return personService.findById(currentPrincipal.getId()).getTickets();
  }


}
