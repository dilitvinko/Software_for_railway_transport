package railwayTransport;

import java.util.HashSet;
import railwayTransport.software.entity.TestLom;
import railwayTransport.software.entity.train.Train;

//
//import com.google.gson.Gson;
//import railwayTransport.software.daoJDBC.ScheduleDAOImpl;
//import railwayTransport.software.daoJDBC.TicketDAOImpl;
//import railwayTransport.software.daoJDBC.TrainDAOImpl;
//import railwayTransport.software.entity.schedule.Schedule;
//import railwayTransport.software.entity.ticket.Ticket;
//import railwayTransport.software.entity.train.Train;
//import java.sql.Date;
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//import railwayTransport.software.service.ScheduleServiceImpl;
//import railwayTransport.software.service.TicketServiceImpl;
//import railwayTransport.software.service.TrainServiceImpl;
//
public class MainClass {
//
  public static void main(String[] args) {
//
////        CarriageDAOImpl carriageDAO = new CarriageDAOImpl();
////        CityDAOImpl cityDAO = new CityDAOImpl();
////        ScheduleDAOImpl scheduleDAO = new ScheduleDAOImpl();
////        TicketDAOImpl ticketDAO = new TicketDAOImpl();
////        TrainDAOImpl trainDAO = new TrainDAOImpl();
////        TypeCarriageDAOImpl typeCarriageDAO = new TypeCarriageDAOImpl();
////
////        System.out.println(carriageDAO.findAll());
////        System.out.println(cityDAO.findAll());
////        System.out.println(scheduleDAO.findAll());
////        System.out.println(ticketDAO.findAll());
////        System.out.println(trainDAO.findAll());
////        System.out.println(typeCarriageDAO.findAll());
////
////        City city = new City();
////        city.setName("Grodno");
////
////        Train train = new Train();
////        train.setName("V-321");
////
////        Ticket ticket = new Ticket();
//////        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//////        String dateString = "2019-05-05";
////        Date date = new Date(2019,05,30);
//////        try {
//////            date = (Date) sdf.parse(dateString);
//////        } catch (ParseException e) {
//////            e.printStackTrace();
//////        }
////        ticket.setNumberSeat(10);
////        ticket.setDate(date);
////        ticket.setPrice(33);
////        ticket.setTrain(train);
////
////
////
////        Schedule schedule = new Schedule();
////        schedule.setDrivingOrder(1);
////        schedule.setTime(new Time(22,00,00));
////        schedule.setCity(city);
////        schedule.setTrain(train);
////
////        TypeCarriage typeCarriage = new TypeCarriage();
////        typeCarriage.setType("test");
////        typeCarriage.setAmountSeats(1);
////        typeCarriage.setCooffPrise(2.2);
////
////        CarriageMapper carriage = new CarriageMapper();
////        carriage.setNumber(11);
////        carriage.setTrain(train);
////        carriage.setTypeCarriage(typeCarriage);
////
////        System.out.println();
////        System.out.println();
////
////
////        System.out.println(trainDAO.create(train));
////        System.out.println(cityDAO.create(city));
////        System.out.println(typeCarriageDAO.create(typeCarriage));
////        carriage.setTrain(train);
////        carriage.setTypeCarriage(typeCarriage);
////        System.out.println(carriageDAO.create(carriage));
////        schedule.setTrain(train);
////        schedule.setCity(city);
////        System.out.println(scheduleDAO.create(schedule));
////        ticket.setCarriage(carriage);
////        ticket.setTrain(train);
////        ticket.setOutSchedule(schedule);
////        ticket.setInSchedule(schedule);
////        System.out.println(ticketDAO.create(ticket));
////
////        System.out.println();
////        System.out.println();
////
////        System.out.println(carriageDAO.findById(2));
////        System.out.println(cityDAO.findById(2));
////        System.out.println(scheduleDAO.findById(2));
////        System.out.println(ticketDAO.findById(2));
////        System.out.println(trainDAO.findById(2));
////        System.out.println(typeCarriageDAO.findById(2));
////
////        System.out.println();
////        System.out.println();
////
////        schedule.setDrivingOrder(11111);
////        schedule.setTime(new Time(00,00,00));
////        //System.out.println(scheduleDAO.deleteById(9));
////        System.out.println(scheduleDAO.update(schedule));
////
////        System.out.println();
////        System.out.println();
////
////        System.out.println(carriageDAO.findById(3));
////
////
////        Train train_2 = new Train();
////        train_2.setName("asd-123");
////        trainDAO.create(train_2);
////        TypeCarriage typeCarriage_2 = new TypeCarriage();
////
////        typeCarriage_2.setType("testtestqwe");
////        typeCarriage_2.setAmountSeats(999);
////        typeCarriage_2.setCooffPrise(111.11);
////        typeCarriageDAO.create(typeCarriage_2);
////
////        CarriageMapper carriage_2 = new CarriageMapper();
////        carriage_2.setTypeCarriage(typeCarriage_2);
////        carriage_2.setTrain(train_2);
////        carriage_2.setNumber(777);
////
////        System.out.println();
////        System.out.println();
////
////
////
////        carriageDAO.create(carriage_2);
////        System.out.println();
////        System.out.println();
////        System.out.println(carriage_2);
//
//    System.out.println();
//    System.out.println("Services");
//    TicketServiceImpl ticketService = new TicketServiceImpl();
//    ScheduleServiceImpl scheduleService = new ScheduleServiceImpl();
//
//    List<Ticket> tickets = new ArrayList<>();
//    tickets = ticketService.findAll();
//    for (Ticket tic :
//        tickets) {
//      System.out.println(tic);
//    }
//    System.out.println();
//    System.out.println();
//
//    List<Schedule> schedules = new ArrayList<>();
//    schedules = scheduleService.findAll();
//    for (Schedule sched :
//        schedules) {
//      System.out.println(sched);
//    }
//
//    ScheduleDAOImpl scheduleDAO = new ScheduleDAOImpl();
//    Date date = new Date(2019, 05, 30);
//    scheduleDAO.findAllTrainAtDateByCities(date, "Moscow", "Bereza");
//
//    System.out.println();
//    System.out.println();
//
//    TrainDAOImpl trainDAO = new TrainDAOImpl();
//    for (Train train :
//        trainDAO.findAll()) {
//      System.out.println(train);
//    }
//
//    LocalDate myDate3 = LocalDate.of(2019, 10, 20);
//    Date date_1 = Date.valueOf(myDate3);
//
//    System.out.println();
//    System.out.println();
//
//    TicketDAOImpl ticketDAO = new TicketDAOImpl();
//    for (Ticket tic :
//        ticketDAO.findByTrainCarriageDate(1, 1, date_1)) {
//      System.out.println(tic);
//    }
//
//    System.out.println();
//    System.out.println();
//
//    System.out.println(ticketService.freeSeatsInCarriage(1, 1, 1, 3, date_1));
//
//    //System.out.println(ticketService.buyTicket(6,1,1,1,3,date_1));
//
//    System.out.println();
//    System.out.println("GSON");
//    Gson gson = new Gson();
//
//    List<Train> trains = new TrainServiceImpl().findAll();
//    String JSON = gson.toJson(trains);
//
//    System.out.println(JSON);
//
////        PersonDAOImpl personDAO = new PersonDAOImpl();
////        person person = personDAO.findById(1);
////        System.out.println(person);
////        System.out.println("");
////        System.out.println(personDAO.deleteById(5));
////        personDAO.findAll();
////        Set<Role> roles = new HashSet<>();
////        roles.add(Role.USER);
////        roles.add(Role.ADMIN);
////        person person_1 = new person("Vikka", "zxc", "qwe", "1234", roles, 0);
////        System.out.println(personDAO.create(person_1));
////        person.setName("AAAAAAAAA");
////        person.setLogin("BBBBBBBBBB");
////        personDAO.update(person);
////        System.out.println();

    //TestLom testLom = new TestLom("qwe", 31);
    //Train train = new Train("qwe", new HashSet<>());


  }
}
