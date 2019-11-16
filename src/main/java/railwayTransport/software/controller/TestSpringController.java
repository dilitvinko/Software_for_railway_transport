//package railwayTransport.software.controller;
//
//import java.util.Set;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import railwayTransport.software.daoJPA.repository.*;
//import railwayTransport.software.entity.person.Person;
//import railwayTransport.software.entity.person.Role;
//import railwayTransport.software.entity.schedule.City;
//import railwayTransport.software.entity.schedule.Schedule;
//import railwayTransport.software.entity.ticket.Ticket;
//import railwayTransport.software.entity.train.CarriageMapper;
//import railwayTransport.software.entity.train.Train;
//import railwayTransport.software.entity.train.TypeCarriage;
//
//import java.sql.Date;
//import java.sql.Time;
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.List;
//
//@RestController
//public class TestSpringController {
//
//
//  private final CarriageRepository carriageRepository;
//  private final CityRepository cityRepository;
//  private final ScheduleRepository scheduleRepository;
//  private final TicketRepository ticketRepository;
//  private final TrainRepository trainRepository;
//  private final TypeCarriageRepository typeCarriageRepository;
//  private final PersonRepository personRepository;
//
//  public TestSpringController(CarriageRepository carriageRepository, CityRepository cityRepository,
//      ScheduleRepository scheduleRepository, TicketRepository ticketRepository,
//      TrainRepository trainRepository, TypeCarriageRepository typeCarriageRepository,
//      PersonRepository personRepository) {
//    this.carriageRepository = carriageRepository;
//    this.cityRepository = cityRepository;
//    this.scheduleRepository = scheduleRepository;
//    this.ticketRepository = ticketRepository;
//    this.trainRepository = trainRepository;
//    this.typeCarriageRepository = typeCarriageRepository;
//    this.personRepository = personRepository;
//  }
//
//  @RequestMapping("/getString")
//  public Train getString() {
//
//    City city = new City("Minsk");
//    cityRepository.saveAndFlush(city);
//    City city1 = new City("Brest");
//    cityRepository.saveAndFlush(city1);
//
//    TypeCarriage typeCarriage = new TypeCarriage("Kupe", 5, 2);
//    typeCarriageRepository.saveAndFlush(typeCarriage);
//
//    CarriageMapper carriage = new CarriageMapper(1, typeCarriage);
//    carriageRepository.saveAndFlush(carriage);
//
//    HashSet<CarriageMapper> carriages = new HashSet<>();
//    carriages.add(carriageRepository.getOne(Long.valueOf(1)));
//
//    Train train = new Train("A-123", carriages);
//    trainRepository.saveAndFlush(train);
//
//    Train train1 = trainRepository.getOne(Long.valueOf(1));
//
//    carriage = carriageRepository.getOne(Long.valueOf(1));
//    carriage.setTrain(train1);
//
//    Schedule schedule = new Schedule(city, 1, new Time(12, 00, 00), train);
//    scheduleRepository.saveAndFlush(schedule);
//    Schedule schedule1 = new Schedule(city1, 2, new Time(15, 00, 00), train);
//    scheduleRepository.saveAndFlush(schedule1);
//
//    Set<Role> roles = new HashSet<>();
//    roles.add(Role.USER);
//
//
////    Ticket ticket = new Ticket(1, carriage, train, schedule, schedule1, new Date(2019, 10, 20), 50);
////    ticketRepository.saveAndFlush(ticket);
////
////    HashSet<Ticket> tickets = new HashSet<>();
////    tickets.add(ticket);
//
//    Person person = new Person("Bobby", "Smith", "bob123", "qwe123", roles, 25);
//    personRepository.saveAndFlush(person);
//
//    person = personRepository.getOne(Long.valueOf(1));
//
//    Ticket ticket = new Ticket(1, carriage, train, schedule, schedule1, new Date(2019, 10, 20), 50, person);
//    ticket.setPerson(person);
//    ticketRepository.saveAndFlush(ticket);
//
//    List<Person> personList = personRepository.findAll();
//
//
//
//    Train train2 = trainRepository.findFirstById(Long.valueOf(1));
//
//
//
//    return train1;
//  }
//}
