package railwayTransport.software.service.interfaces;

import java.sql.Date;
import java.util.List;
import org.springframework.web.bind.annotation.RequestParam;
import railwayTransport.software.dto.BuyTicketDto;
import railwayTransport.software.dto.CarriageFreeSeatsPriceDTO;
import railwayTransport.software.dto.TicketDto;

public interface BuyTicketService {

  List<CarriageFreeSeatsPriceDTO> findCarriageFreeSeatsPrice(Long idTrain, Date date, String outCity,
      String inCity);

  TicketDto buyTicket(BuyTicketDto buyTicketDto);

}
