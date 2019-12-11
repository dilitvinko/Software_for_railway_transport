package railwaytransport.software.service.interfaces;

import java.sql.Date;
import java.util.List;
import railwaytransport.software.dto.BuyTicketDto;
import railwaytransport.software.dto.CarriageFreeSeatsPriceDTO;
import railwaytransport.software.dto.TicketDto;

public interface BuyTicketService {

  List<CarriageFreeSeatsPriceDTO> findCarriageFreeSeatsPrice(Long idTrain, Date date, String outCity,
      String inCity);

  TicketDto buyTicket(BuyTicketDto buyTicketDto);

}
