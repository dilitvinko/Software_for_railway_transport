package railwayTransport.software.controller;

import java.util.List;
import javax.ws.rs.core.Response;
import lombok.extern.log4j.Log4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import railwayTransport.software.dto.TicketDto;
import railwayTransport.software.service.TicketServiceImpl;

@Log4j
@RestController
@RequestMapping("/tickets")
public class TicketController {

  private final TicketServiceImpl ticketService;

  public TicketController(TicketServiceImpl ticketService) {
    this.ticketService = ticketService;
  }


  @GetMapping
  public List<TicketDto> findAllTickets() {
    log.info("Get List<Dto> ");
    return ticketService.findAll();
  }

  @GetMapping("/{id}")
  public TicketDto getCarriage(@PathVariable Long id) {
    log.info("Get Dto by id =  " + id);
    return ticketService.findById(id);
  }

  @PostMapping
  public TicketDto createTicket(@RequestBody TicketDto ticketDto) {
    log.info("Create Dto");
    return ticketService.create(ticketDto);
  }

  @DeleteMapping
  public @ResponseBody
  Response deleteTicket(@RequestBody TicketDto ticketDto) {
    log.info("Delete Dto by dto");
    ticketService.delete(ticketDto);
    return Response.status(Response.Status.OK.getStatusCode()).build();
  }

  @DeleteMapping("/{id}")
  public @ResponseBody
  Response deleteByIdTicket(@PathVariable Long id) {
    log.info("Delete Dto by id = " + id);
    ticketService.deleteById(id);
    return Response.status(Response.Status.OK.getStatusCode()).build();
  }

  @PutMapping
  public TicketDto updateTicket(@RequestBody TicketDto ticketDto) {
    log.info("Update Dto by dto");
    return ticketService.update(ticketDto);
  }


}
