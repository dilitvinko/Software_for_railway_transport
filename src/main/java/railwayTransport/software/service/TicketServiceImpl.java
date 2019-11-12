//package railwayTransport.software.service;
//
//import railwayTransport.software.daoJDBC.CarriageDAOImpl;
//import railwayTransport.software.daoJDBC.ScheduleDAOImpl;
//import railwayTransport.software.daoJDBC.TicketDAOImpl;
//import railwayTransport.software.daoJDBC.TrainDAOImpl;
//import railwayTransport.software.daoJDBC.TypeCarriageDAOImpl;
//import railwayTransport.software.entity.schedule.Schedule;
//import railwayTransport.software.entity.ticket.Ticket;
//import java.sql.Date;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//import railwayTransport.software.service.interfaces.TicketService;
//
//public class TicketServiceImpl extends AbstractService implements TicketService {
//
//  public TicketServiceImpl() {
//    abstractDAODB = new TicketDAOImpl();
//  }
//
//
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
//}
