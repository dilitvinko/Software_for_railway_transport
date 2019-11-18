package railwayTransport.software.dto.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import railwayTransport.software.dto.TicketDto;
import railwayTransport.software.entity.ticket.Ticket;

@Mapper
public interface TicketMapper {

  TicketDto ticketToTicketDto(Ticket entity);
  Ticket ticketDtotoTicket(TicketDto dto);

  List<TicketDto> listTicketToListTicketDto(List<Ticket> entities);
  List<Ticket> listTicketDtoToListTicket(List<TicketDto> dtos);

}
