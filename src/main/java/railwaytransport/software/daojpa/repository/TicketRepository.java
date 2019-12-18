package railwaytransport.software.daojpa.repository;

import java.sql.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import railwaytransport.software.entity.ticket.Ticket;


public interface TicketRepository extends JpaRepository<Ticket, Long> {

  List<Ticket> findAllByTrainIdAndCarriageIdAndDate(long trainId, long carriageId, Date date);

}
