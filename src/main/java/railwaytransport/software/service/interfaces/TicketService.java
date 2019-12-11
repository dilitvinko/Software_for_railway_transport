package railwaytransport.software.service.interfaces;

import java.sql.Date;
import railwaytransport.software.dto.FreeSeatsDTO;
import railwaytransport.software.dto.TicketDto;

public interface TicketService extends Service<TicketDto> {

  FreeSeatsDTO findFreeSeatsInCarriage(Long idCarriage, Long idTrain, Date date, String outCity,
      String inCity);

  int findAmountFreeSeatsInCarriage(Long idCarriage, Long idTrain, Date date, String outCity,
      String inCity);

  double calculatePrice(Long idCarriage, Long idTrain, String outCity, String inCity);

}
