package railwayTransport.software.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.springframework.stereotype.Service;
import railwayTransport.software.dto.BuyTicketDto;
import railwayTransport.software.dto.CarriageDto;
import railwayTransport.software.dto.CarriageFreeSeatsPriceDTO;
import railwayTransport.software.dto.ScheduleDto;
import railwayTransport.software.dto.TicketDto;
import railwayTransport.software.service.interfaces.BuyTicketService;
import railwayTransport.software.service.interfaces.CarriageService;
import railwayTransport.software.service.interfaces.CityService;
import railwayTransport.software.service.interfaces.PersonService;
import railwayTransport.software.service.interfaces.ScheduleService;
import railwayTransport.software.service.interfaces.TicketService;
import railwayTransport.software.service.interfaces.TrainService;

@Service
public class BuyTicketServiceImpl implements BuyTicketService {

  private final CarriageService carriageService;
  private final TrainService trainService;
  private final TicketService ticketService;
  private final ScheduleService scheduleService;
  private final CityService cityService;
  private final PersonService personService;

  public BuyTicketServiceImpl(
      CarriageService carriageService,
      TrainService trainService,
      TicketService ticketService,
      ScheduleService scheduleService,
      CityService cityService,
      PersonService personService) {
    this.carriageService = carriageService;
    this.trainService = trainService;
    this.ticketService = ticketService;
    this.scheduleService = scheduleService;
    this.cityService = cityService;
    this.personService = personService;
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

  @Override
  public TicketDto buyTicket(BuyTicketDto buyTicketDto) {

    Long idOutCity = cityService.findByName(buyTicketDto.getOutCity()).getId();
    Long idInCity = cityService.findByName(buyTicketDto.getInCity()).getId();

    ScheduleDto outScheduleDto = scheduleService.findScheduleByTrainIdAndCityId(buyTicketDto.getIdTrain(), idOutCity);
    ScheduleDto inScheduleDto = scheduleService.findScheduleByTrainIdAndCityId(buyTicketDto.getIdTrain(), idInCity);

    TicketDto ticketDto = TicketDto.builder()
        .numberSeat(buyTicketDto.getNumberSeat())
        .carriage(carriageService.findById(buyTicketDto.getIdCarriage()))
        .train(trainService.findById(buyTicketDto.getIdTrain()))
        .outSchedule(outScheduleDto)
        .inSchedule(inScheduleDto)
        .date(buyTicketDto.getDate())
        .price(ticketService
            .calculatePrice(buyTicketDto.getIdCarriage(), buyTicketDto.getIdTrain(), buyTicketDto.getOutCity(), buyTicketDto.getInCity()))
        .idPerson(personService.findById(buyTicketDto.getIdPerson()).getId())
        .build();

    return ticketService.create(ticketDto);
  }
}
