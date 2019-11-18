package railwayTransport.software.service;

import java.util.List;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;
import railwayTransport.software.daoJPA.repository.TicketRepository;
import railwayTransport.software.dto.TicketDto;
import railwayTransport.software.dto.mapper.TicketMapper;
import railwayTransport.software.entity.ticket.Ticket;
import railwayTransport.software.service.interfaces.TicketService;

@Service
public class TicketServiceImpl  implements TicketService {

  private final TicketRepository ticketRepository;
  private final TicketMapper mapper;

  public TicketServiceImpl(
      TicketRepository ticketRepository, TicketMapper mapper) {
    this.ticketRepository = ticketRepository;
    this.mapper = mapper;
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
  public boolean deleteById(long id) {
    boolean flag = false;
    try{
      ticketRepository.deleteById(id);
      flag = true;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return flag;
  }

  @Override
  public boolean delete(TicketDto dto) {
    boolean flag = false;
    Ticket ticket = mapper.ticketDtotoTicket(dto);
    try{
      ticketRepository.delete(ticket);
      flag = true;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return flag;
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

//  //TODO Костыльный метод будет переписан нормально через JPA
//  //МОЖЕТ ВОЗРАЩАТЬ seats ?? только
//  public Set<Integer> freeSeatsInCarriage(long idCarriage, long idTrain, long idOutCity,
//      long idInCity, Date date) {
//    TicketDAOImpl ticketDAO = new TicketDAOImpl();
//    List<Ticket> reservedTickets = ticketDAO.findByTrainCarriageDate(idTrain, idCarriage, date);
//    CarriageDAOImpl carriageDAO = new CarriageDAOImpl();
//    long idTypeCarriage = carriageDAO.findById(idCarriage).getId_typeCarriage();
//    TypeCarriageDAOImpl typeCarriageDAO = new TypeCarriageDAOImpl();
//    Set<Integer> seats = new HashSet<>();
//    for (int i = 1; i <= typeCarriageDAO.findById(idTypeCarriage).getAmountSeats(); i++) {
//      seats.add(i);
//    }
//    // TODO метод c ORDER long idOutCity, long idInCity и для тикета доставать Order
//    int idOrderOutCity = 1;
//    int idOrderInCity = 3;
//    for (Ticket ticket :
//        reservedTickets) {
//      if (!((idOrderOutCity >= ticket.getId_inSchedule() && idOrderOutCity >= ticket
//          .getId_inSchedule()) ||
//          (idOrderOutCity <= ticket.getId_outSchedule() && idOrderInCity <= ticket
//              .getId_outSchedule()))) {
//        seats.remove(ticket.getNumberSeat());
//      }
//    }
//    return seats;
//  }
//
//  //TODO Костыльный метод будет переписан нормально через JPA
//  public Ticket buyTicket(int numberSeat, long idCarriage, long idTrain, long idOutCity,
//      long idInCity, Date date) {
//    ScheduleDAOImpl scheduleDAO = new ScheduleDAOImpl();
//    List<Schedule> schedules = scheduleDAO.findAll();
//    long idOutSchedule = 0;
//    long idInSchedule = 0;
//    for (Schedule schedule :
//        schedules) {
//      if (schedule.getTrain().getId() == idTrain) {
//        if (schedule.getId_city() == idOutCity) {
//          idOutSchedule = schedule.getId();
//        }
//        if (schedule.getId_city() == idInCity) {
//          idInSchedule = schedule.getId();
//        }
//      }
//    }
//
//    //TODO метод чтобы достать время и посчитать разность, достать кооэф вагона и перемножить
//
//    double price = 999;
//
//    CarriageDAOImpl carriageDAO = new CarriageDAOImpl();
//    TrainDAOImpl trainDAO = new TrainDAOImpl();
//
//    TicketDAOImpl ticketDAO = new TicketDAOImpl();
//    Ticket ticket = new Ticket();
//    ticket.setNumberSeat(numberSeat);
//    ticket.setCarriage(carriageDAO.findById(idCarriage));
//    ticket.setTrain(trainDAO.findById(idTrain));
//    ticket.setOutSchedule(scheduleDAO.findById(idOutSchedule));
//    ticket.setInSchedule(scheduleDAO.findById(idInSchedule));
//    ticket.setDate(date);
//    ticket.setPrice(price);
//
//    ticketDAO.create(ticket);
//
//    return ticket;
//
//  }
}
