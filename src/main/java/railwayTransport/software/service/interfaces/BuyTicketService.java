package railwayTransport.software.service.interfaces;

import java.sql.Date;
import java.util.List;
import railwayTransport.software.dto.CarriageFreeSeatsPriceDTO;

public interface BuyTicketService {

  List<CarriageFreeSeatsPriceDTO> findCarriageFreeSeatsPrice(Long idTrain, Date date, String outCity,
      String inCity);



}
