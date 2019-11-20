package railwayTransport.software.daoJPA.repository;

import java.sql.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import railwayTransport.software.entity.ticket.Ticket;


public interface TicketRepository extends JpaRepository<Ticket, Long> {

  Ticket findFirstById(Long id);

  List<Ticket> findAllByTrainIdAndCarriageIdAndDate(long trainId, long carriageId, Date date);
}
