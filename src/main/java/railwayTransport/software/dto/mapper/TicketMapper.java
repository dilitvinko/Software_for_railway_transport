package railwayTransport.software.dto.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import railwayTransport.software.dto.TicketDto;
import railwayTransport.software.entity.ticket.Ticket;

@Mapper
public interface TicketMapper {

  @Mappings({
      @Mapping(target = "idPerson", source = "entity.person.id")

  })
  TicketDto ticketToTicketDto(Ticket entity);

  @Mappings({
      @Mapping(target = "person.id", source = "dto.idPerson")

  })
  Ticket ticketDtotoTicket(TicketDto dto);

  List<TicketDto> listTicketToListTicketDto(List<Ticket> entities);

  List<Ticket> listTicketDtoToListTicket(List<TicketDto> dtos);

}
