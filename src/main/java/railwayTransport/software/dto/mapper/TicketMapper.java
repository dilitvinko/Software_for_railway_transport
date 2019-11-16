package railwayTransport.software.dto.mapper;

import org.mapstruct.Mapper;
import railwayTransport.software.dto.TicketDto;
import railwayTransport.software.entity.ticket.Ticket;

@Mapper
public interface TicketMapper {

  TicketDto ticketToTicketDto(Ticket entity);


  Ticket ticketDtotoTicket(TicketDto dto);

}
