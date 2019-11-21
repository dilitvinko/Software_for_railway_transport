package railwayTransport.software.service;

import java.time.Duration;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.stereotype.Service;
import railwayTransport.software.daoJPA.repository.CarriageRepository;
import railwayTransport.software.daoJPA.repository.ScheduleRepository;
import railwayTransport.software.daoJPA.repository.TicketRepository;
import railwayTransport.software.dto.CarriageDto;
import railwayTransport.software.dto.CarriageTrainCitiesDateDto;
import railwayTransport.software.dto.ScheduleDto;
import railwayTransport.software.dto.TicketDto;
import railwayTransport.software.dto.mapper.TicketMapper;
import railwayTransport.software.entity.ticket.Ticket;
import railwayTransport.software.entity.train.Carriage;
import railwayTransport.software.service.interfaces.TicketService;

@Service
public class TicketServiceImpl implements TicketService {

  private final TicketRepository ticketRepository;
  private final TicketMapper mapper;
  private final CarriageRepository carriageRepository;
  private final CarriageServiceImpl carriageService;
  private final ScheduleRepository scheduleRepository;

  public TicketServiceImpl(
      TicketRepository ticketRepository, TicketMapper mapper,
      CarriageRepository carriageRepository,
      CarriageServiceImpl carriageService,
      ScheduleRepository scheduleRepository) {
    this.ticketRepository = ticketRepository;
    this.mapper = mapper;
    this.carriageRepository = carriageRepository;
    this.carriageService = carriageService;
    this.scheduleRepository = scheduleRepository;
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

  public Set<Integer> freeSeatsInCarriage(CarriageTrainCitiesDateDto carriageTrainCitiesDateDto,
      ScheduleDto scheduleOutDto,
      ScheduleDto scheduleInDto) {
    CarriageDto carriageDto = carriageService.findById(carriageTrainCitiesDateDto.getIdCarriage());
    List<Ticket> reservedTickets = ticketRepository
        .findAllByTrainIdAndCarriageIdAndDate(carriageDto.getIdTrain(), carriageDto.getId(),
            carriageTrainCitiesDateDto.getDate());

    Set<Integer> seats = new HashSet<>();
    for (int i = 1; i <= carriageDto.getTypeCarriage().getAmountSeats(); i++) {
      seats.add(i);
    }

    int idOrderOutCity = scheduleOutDto.getDrivingOrder();
    int idOrderInCity = scheduleInDto.getDrivingOrder();
    for (Ticket ticket :
        reservedTickets) {
      if (!((idOrderOutCity >= ticket.getInSchedule().getId() && idOrderOutCity >= ticket
          .getInSchedule().getId()) ||
          (idOrderOutCity <= ticket.getOutSchedule().getId() && idOrderInCity <= ticket
              .getOutSchedule().getId()))) {
        seats.remove(ticket.getNumberSeat());
      }
    }
    return seats;
  }

  public double calculatePrice(long idOutScheduleDto, long idInScheduleDto, long idCarriageDto) {

    LocalTime outTime = scheduleRepository.getOne(idOutScheduleDto).getTime().toLocalTime();
    LocalTime inTime = scheduleRepository.getOne(idInScheduleDto).getTime().toLocalTime();
    long minutes = Duration.between(outTime, inTime).toMinutes();

    Carriage carriage = carriageRepository.getOne(idCarriageDto);

    double price = carriage.getTypeCarriage().getCooffPrise() * minutes;

    return price;

  }
//  WITH
//  t1 AS (SELECT time FROM schedule where id =104),
//  t2 AS (SELECT time FROM schedule where id = 103)
//  SELECT timediff(t1.time, t2.time) from t1,t2;


}
