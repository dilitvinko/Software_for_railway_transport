package railwayTransport.software.service;

import java.sql.Date;
import java.time.Duration;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.stereotype.Service;
import railwayTransport.software.daoJPA.repository.CarriageRepository;
import railwayTransport.software.daoJPA.repository.CityRepository;
import railwayTransport.software.daoJPA.repository.ScheduleRepository;
import railwayTransport.software.daoJPA.repository.TicketRepository;
import railwayTransport.software.dto.FreeSeatsDTO;
import railwayTransport.software.dto.TicketDto;
import railwayTransport.software.dto.mapper.TicketMapper;
import railwayTransport.software.entity.schedule.Schedule;
import railwayTransport.software.entity.ticket.Ticket;
import railwayTransport.software.entity.train.Carriage;
import railwayTransport.software.service.interfaces.TicketService;

@Service
public class TicketServiceImpl implements TicketService {

  private final TicketRepository ticketRepository;
  private final TicketMapper mapper;
  private final CarriageRepository carriageRepository;
  private final ScheduleRepository scheduleRepository;
  private final CityRepository cityRepository;

  private final static long MINUT_IN_HOUR = 60 * 24;
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
    Ticket ticket = mapper.ticketDtotoTicket(dto);
    ticketRepository.saveAndFlush(ticket);
    dto = mapper.ticketToTicketDto(ticket);
    return dto;
  }

  @Override
  public TicketDto update(TicketDto dto) {
    Ticket ticket = mapper.ticketDtotoTicket(dto);
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

    Set<Integer> seats = new HashSet<>();
    for (int i = 1; i <= amountSeats; i++) {
      seats.add(i);
    }

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

    LocalTime outTime = outSchedule.getTime().toLocalTime();
    LocalTime inTime = inSchedule.getTime().toLocalTime();
    long minutes = Duration.between(outTime, inTime).toMinutes();
    if (minutes < 0){
      minutes += MINUT_IN_HOUR;
    }

    Carriage carriage = carriageRepository.getOne(idCarriage);

    double price = START_PRICE;
    price += carriage.getTypeCarriage().getCooffPrise() * minutes;

    return price;
  }
//  WITH
//  t1 AS (SELECT time FROM schedule where id =104),
//  t2 AS (SELECT time FROM schedule where id = 103)
//  SELECT timediff(t1.time, t2.time) from t1,t2;


}
