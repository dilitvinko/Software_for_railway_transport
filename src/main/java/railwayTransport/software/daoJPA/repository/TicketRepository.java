package railwayTransport.software.daoJPA.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import railwayTransport.software.entity.ticket.Ticket;


public interface TicketRepository  extends JpaRepository<Ticket, Long> {

}
