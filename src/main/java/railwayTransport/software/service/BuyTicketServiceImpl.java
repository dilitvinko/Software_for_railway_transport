package railwayTransport.software.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.springframework.stereotype.Service;
import railwayTransport.software.dto.CarriageDto;
import railwayTransport.software.dto.CarriageFreeSeatsPriceDTO;
import railwayTransport.software.service.interfaces.BuyTicketService;
import railwayTransport.software.service.interfaces.CarriageService;
import railwayTransport.software.service.interfaces.TicketService;
import railwayTransport.software.service.interfaces.TrainService;

@Service
public class BuyTicketServiceImpl implements BuyTicketService {

  private final CarriageService carriageService;
  private final TrainService trainService;
  private final TicketService ticketService;

  public BuyTicketServiceImpl(
      CarriageService carriageService,
      TrainService trainService,
      TicketService ticketService) {
    this.carriageService = carriageService;
    this.trainService = trainService;
    this.ticketService = ticketService;
  }


  @Override
  public List<CarriageFreeSeatsPriceDTO> findCarriageFreeSeatsPrice(Long idTrain, Date date,
      String outCity, String inCity) {
    List<CarriageFreeSeatsPriceDTO> carriageFreeSeatsPriceDTOS = new ArrayList<>();
    Set<CarriageDto> carriageDtos = trainService.findById(idTrain).getCarriages();
    for (CarriageDto carriage :
        carriageDtos) {
      CarriageFreeSeatsPriceDTO carriageFreeSeatsPriceDTO = new CarriageFreeSeatsPriceDTO();
      carriageFreeSeatsPriceDTO.setCarriage(carriage);
      carriageFreeSeatsPriceDTO.setAmountFreeSeats(ticketService
          .findAmountFreeSeatsInCarriage(carriage.getId(), idTrain, date, outCity, inCity));
      carriageFreeSeatsPriceDTO
          .setPrice(ticketService.calculatePrice(carriage.getId(), idTrain, outCity, inCity));

      carriageFreeSeatsPriceDTOS.add(carriageFreeSeatsPriceDTO);
    }
    return carriageFreeSeatsPriceDTOS;
  }
}
