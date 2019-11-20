package railwayTransport.software.controller;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import railwayTransport.software.dto.TicketDto;
import railwayTransport.software.dto.TrainDto;
import railwayTransport.software.service.TicketServiceImpl;


@RestController
@RequestMapping("/ticket")
public class TicketController  {

  private final TicketServiceImpl ticketService;

  public TicketController(TicketServiceImpl ticketService) {
    this.ticketService = ticketService;
  }


  @GetMapping("/all")
  public List<TicketDto> findAllTickets() {
    return ticketService.findAll();
  }

  @GetMapping("/{id}")
  public TicketDto getCarriage(@PathVariable Long id) {
    return ticketService.findById(id);
  }

  @PostMapping
  public TicketDto createTicket(@RequestBody TicketDto ticketDto) {
    return ticketService.create(ticketDto);
  }

  @DeleteMapping
  public Boolean deleteTicket(@RequestBody TicketDto ticketDto) {
    return ticketService.delete(ticketDto);
  }

  @DeleteMapping("/{id}")
  public Boolean deleteByIdTicket(@PathVariable Long id) {
    return ticketService.deleteById(id);
  }

  @PutMapping
  public TicketDto updateTicket(@RequestBody TicketDto ticketDto) {
    return ticketService.update(ticketDto);
  }


}
