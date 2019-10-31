import dao.*;
import entity.schedule.City;
import entity.schedule.Schedule;
import entity.ticket.Ticket;
import entity.train.Carriage;
import entity.train.Train;
import entity.train.TypeCarriage;
import service.ScheduleServiceImpl;
import service.TicketServiceImpl;
import service.interfaces.ScheduleService;
import service.interfaces.TicketService;

import java.sql.Time;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class MainClass {

    public static void main(String[] args) {


        CarriageDAOImpl carriageDAO = new CarriageDAOImpl();
        CityDAOImpl cityDAO = new CityDAOImpl();
        ScheduleDAOImpl scheduleDAO = new ScheduleDAOImpl();
        TicketDAOImpl ticketDAO = new TicketDAOImpl();
        TrainDAOImpl trainDAO = new TrainDAOImpl();
        TypeCarriageDAOImpl typeCarriageDAO = new TypeCarriageDAOImpl();

        System.out.println(carriageDAO.findAll());
        System.out.println(cityDAO.findAll());
        System.out.println(scheduleDAO.findAll());
        System.out.println(ticketDAO.findAll());
        System.out.println(trainDAO.findAll());
        System.out.println(typeCarriageDAO.findAll());

        City city = new City();
        city.setName("Grodno");

        Train train = new Train();
        train.setName("V-321");

        Ticket ticket = new Ticket();
//        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        String dateString = "2019-05-05";
        Date date = new Date(2019,20,30);
//        try {
//            date = (Date) sdf.parse(dateString);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
        ticket.setNumberSeat(10);
        ticket.setDate(date);
        ticket.setPrice(33);
        ticket.setTrain(train);



        Schedule schedule = new Schedule();
        schedule.setOrder(1);
        schedule.setTime(new Time(22,00,00));
        schedule.setCity(city);
        schedule.setTrain(train);

        TypeCarriage typeCarriage = new TypeCarriage();
        typeCarriage.setType("test");
        typeCarriage.setAmountSeats(1);
        typeCarriage.setCooffPrise(2.2);

        Carriage carriage = new Carriage();
        carriage.setNumber(11);
        carriage.setTrain(train);
        carriage.setTypeCarriage(typeCarriage);

        System.out.println();
        System.out.println();


        System.out.println(trainDAO.create(train));
        System.out.println(cityDAO.create(city));
        System.out.println(typeCarriageDAO.create(typeCarriage));
        carriage.setTrain(train);
        carriage.setTypeCarriage(typeCarriage);
        System.out.println(carriageDAO.create(carriage));
        schedule.setTrain(train);
        schedule.setCity(city);
        System.out.println(scheduleDAO.create(schedule));
        ticket.setCarriage(carriage);
        ticket.setTrain(train);
        ticket.setOutSchedule(schedule);
        ticket.setInSchedule(schedule);
        System.out.println(ticketDAO.create(ticket));

        System.out.println();
        System.out.println();

        System.out.println(carriageDAO.findById(2));
        System.out.println(cityDAO.findById(2));
        System.out.println(scheduleDAO.findById(2));
        System.out.println(ticketDAO.findById(2));
        System.out.println(trainDAO.findById(2));
        System.out.println(typeCarriageDAO.findById(2));

        System.out.println();
        System.out.println();

        schedule.setOrder(11111);
        schedule.setTime(new Time(00,00,00));
        //System.out.println(scheduleDAO.deleteById(9));
        System.out.println(scheduleDAO.update(schedule));

        System.out.println();
        System.out.println();

        System.out.println(carriageDAO.findById(3));


        Train train_2 = new Train();
        train_2.setName("asd-123");
        trainDAO.create(train_2);
        TypeCarriage typeCarriage_2 = new TypeCarriage();

        typeCarriage_2.setType("testtestqwe");
        typeCarriage_2.setAmountSeats(999);
        typeCarriage_2.setCooffPrise(111.11);
        typeCarriageDAO.create(typeCarriage_2);

        Carriage carriage_2 = new Carriage();
        carriage_2.setTypeCarriage(typeCarriage_2);
        carriage_2.setTrain(train_2);
        carriage_2.setNumber(777);

        System.out.println();
        System.out.println();



        carriageDAO.create(carriage_2);
        System.out.println();
        System.out.println();
        System.out.println(carriage_2);

        System.out.println();
        System.out.println("Services");
        TicketServiceImpl ticketService = new TicketServiceImpl();
        ScheduleServiceImpl scheduleService = new ScheduleServiceImpl();

        List<Ticket> tickets = new ArrayList<>();
        tickets = ticketService.findAll();
        for (Ticket tic :
                tickets) {
            System.out.println(tic);
        }
        scheduleService.create(tickets.get(2).getInSchedule());


//        PersonDAOImpl personDAO = new PersonDAOImpl();
//        person person = personDAO.findById(1);
//        System.out.println(person);
//        System.out.println("");
//        System.out.println(personDAO.deleteById(5));
//        personDAO.findAll();
//        Set<Role> roles = new HashSet<>();
//        roles.add(Role.USER);
//        roles.add(Role.ADMIN);
//        person person_1 = new person("Vikka", "zxc", "qwe", "1234", roles, 0);
//        System.out.println(personDAO.create(person_1));
//        person.setName("AAAAAAAAA");
//        person.setLogin("BBBBBBBBBB");
//        personDAO.update(person);
//        System.out.println();
    }
}
