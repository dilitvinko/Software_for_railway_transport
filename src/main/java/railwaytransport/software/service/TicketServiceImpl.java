package railwaytransport.software.service;

import java.sql.Date;
import java.time.Duration;
import java.time.LocalTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import javax.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import railwaytransport.software.daojpa.repository.CarriageRepository;
import railwaytransport.software.daojpa.repository.CityRepository;
import railwaytransport.software.daojpa.repository.ScheduleRepository;
import railwaytransport.software.daojpa.repository.TicketRepository;
import railwaytransport.software.dto.FreeSeatsDTO;
import railwaytransport.software.dto.TicketDto;
import railwaytransport.software.dto.mapper.TicketMapper;
import railwaytransport.software.entity.schedule.Schedule;
import railwaytransport.software.entity.ticket.Ticket;
import railwaytransport.software.entity.train.Carriage;
import railwaytransport.software.exception.WrongOrderInSchedulesForCalculatePriceException;
import railwaytransport.software.service.interfaces.TicketService;

@Service
public class TicketServiceImpl implements TicketService {

  private final TicketRepository ticketRepository;
  private final TicketMapper mapper;
  private final CarriageRepository carriageRepository;
  private final ScheduleRepository scheduleRepository;
  private final CityRepository cityRepository;

  private final static long MINUT_IN_DAY = 60 * 24;
  private final static long START_PRICE = 60;

  public TicketServiceImpl(
      TicketRepository ticketRepository, TicketMapper mapper,
      CarriageRepository carriageRepository,
      ScheduleRepository scheduleRepository,
      CityRepository cityRepository) {
    this.ticketRepository = ticketRepository;
    this.mapper = mapper;
    this.carriageRepository = carriageRepository;
    this.scheduleRepository = scheduleRepository;
    this.cityRepository = cityRepository;
  }

  @Override
  public List<TicketDto> findAll() {
    return mapper.listTicketToListTicketDto(ticketRepository.findAll());
  }

  @Override
  public TicketDto findById(long id) {
    return mapper.ticketToTicketDto(ticketRepository.getOne(id));
  }

  @Override
  public void deleteById(long id) {
    ticketRepository.deleteById(id);
  }

  @Override
  public void delete(TicketDto dto) {
    Ticket ticket = mapper.ticketDtotoTicket(dto);
    ticketRepository.delete(ticket);
  }

  @Override
  public TicketDto create(TicketDto dto) {
    dto.setId(null);
    Ticket ticket = mapper.ticketDtotoTicket(dto);
    ticketRepository.saveAndFlush(ticket);
    dto = mapper.ticketToTicketDto(ticket);
    return dto;
  }

  @Override
  public TicketDto update(TicketDto dto) {
    Ticket ticket = mapper.ticketDtotoTicket(dto);
    if (null == ticketRepository.getOne(ticket.getId())) {
      throw new EntityNotFoundException();
    }
    ticketRepository.saveAndFlush(ticket);
    dto = mapper.ticketToTicketDto(ticket);
    return dto;
  }

  @Override
  public FreeSeatsDTO findFreeSeatsInCarriage(Long idCarriage, Long idTrain, Date date,
      String outCity, String inCity) {

    List<Ticket> reservedTickets = ticketRepository
        .findAllByTrainIdAndCarriageIdAndDate(idTrain, idCarriage, date);

    Long idOutCity = cityRepository.findByName(outCity).getId();
    Long idInCity = cityRepository.findByName(inCity).getId();

    Schedule outSchedule = scheduleRepository.findScheduleByTrainIdAndCityId(idTrain, idOutCity);
    Schedule inSchedule = scheduleRepository.findScheduleByTrainIdAndCityId(idTrain, idInCity);

    int idOrderOutCity = outSchedule.getDrivingOrder();
    int idOrderInCity = inSchedule.getDrivingOrder();
    int amountSeats = carriageRepository.getOne(idCarriage).getTypeCarriage().getAmountSeats();

    Set<Integer> seats = IntStream.range(1, amountSeats).boxed().collect(Collectors.toSet());


    for (Ticket ticket :
        reservedTickets) {
      if (!((idOrderOutCity >= ticket.getInSchedule().getId() && idOrderOutCity >= ticket
          .getInSchedule().getId()) ||
          (idOrderOutCity <= ticket.getOutSchedule().getId() && idOrderInCity <= ticket
              .getOutSchedule().getId()))) {
        seats.remove(ticket.getNumberSeat());
      }
    }

    return FreeSeatsDTO.builder().freeSeats(seats).build();
  }

  @Override
  public int findAmountFreeSeatsInCarriage(Long idCarriage, Long idTrain, Date date, String outCity,
      String inCity) {

    return findFreeSeatsInCarriage(idCarriage, idTrain, date, outCity, inCity)
        .getFreeSeats().size();
  }

  @Override
  public double calculatePrice(Long idCarriage, Long idTrain, String outCity, String inCity) {

    Long idOutCity = cityRepository.findByName(outCity).getId();
    Long idInCity = cityRepository.findByName(inCity).getId();

    Schedule outSchedule = scheduleRepository.findScheduleByTrainIdAndCityId(idTrain, idOutCity);
    Schedule inSchedule = scheduleRepository.findScheduleByTrainIdAndCityId(idTrain, idInCity);

    if (!(outSchedule.getDrivingOrder() < inSchedule.getDrivingOrder())) {
      throw new WrongOrderInSchedulesForCalculatePriceException();
    }

    LocalTime outTime = outSchedule.getTime().toLocalTime();
    LocalTime inTime = inSchedule.getTime().toLocalTime();
    long minutes = Duration.between(outTime, inTime).toMinutes();
    if (minutes < 0) {
      minutes += MINUT_IN_DAY;
    }

    Carriage carriage = carriageRepository.getOne(idCarriage);

    double price = START_PRICE;
    price += carriage.getTypeCarriage().getCooffPrise() * minutes;

    return price;
  }



}
