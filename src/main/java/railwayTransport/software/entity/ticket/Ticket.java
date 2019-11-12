package railwayTransport.software.entity.ticket;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import railwayTransport.software.entity.BaseEntity;
import railwayTransport.software.entity.person.Person;
import railwayTransport.software.entity.schedule.Schedule;
import railwayTransport.software.entity.train.Carriage;
import railwayTransport.software.entity.train.Train;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.sql.Date;

@Entity
public class Ticket extends BaseEntity {

  private int numberSeat;
  @ManyToOne
  @JoinColumn(name = "carriage_id")
  private Carriage carriage;
  @ManyToOne
  @JoinColumn(name = "train_id")
  private Train train;
  @ManyToOne
  @JoinColumn(name = "in_schedule_id")
  private Schedule inSchedule;
  @ManyToOne
  @JoinColumn(name = "out_schedule_id")
  private Schedule outSchedule;
  private Date date;
  private double price;
  @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  @JoinColumn(name = "person_id")
  private Person person;


  public Ticket() {
  }

  public Ticket(int numberSeat, Carriage carriage, Train train, Schedule inSchedule,
      Schedule outSchedule, Date date, double price, Person person) {
    this.numberSeat = numberSeat;
    this.carriage = carriage;
//    this.id_carriage = id_carriage;
    this.train = train;
//    this.id_train = id_train;
    this.inSchedule = inSchedule;
//    this.id_inSchedule = id_inSchedule;
    this.outSchedule = outSchedule;
//    this.id_outSchedule = id_outSchedule;
    this.date = date;
    this.price = price;
    this.person = person;
  }

  public int getNumberSeat() {
    return numberSeat;
  }

  public void setNumberSeat(int numberSeat) {
    this.numberSeat = numberSeat;
  }

  public Carriage getCarriage() {
    return carriage;
  }

  public void setCarriage(Carriage carriage) {
    this.carriage = carriage;
//    id_carriage = carriage.getId();
  }

  public Train getTrain() {
    return train;
  }

  public void setTrain(Train train) {
    this.train = train;
//    id_train = train.getId();
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public Schedule getInSchedule() {
    return inSchedule;
  }

  public void setInSchedule(Schedule inSchedule) {
    this.inSchedule = inSchedule;
//    id_inSchedule = inSchedule.getId();
  }

  public Schedule getOutSchedule() {
    return outSchedule;
  }

  public void setOutSchedule(Schedule outSchedule) {
    this.outSchedule = outSchedule;
//    id_outSchedule = outSchedule.getId();
  }

//  public long getId_carriage() {
//    return id_carriage;
//  }
//
//  public long getId_train() {
//    return id_train;
//  }
//
//  public long getId_inSchedule() {
//    return id_inSchedule;
//  }
//
//  public long getId_outSchedule() {
//    return id_outSchedule;
//  }


  public Person getPerson() {
    return person;
  }

  public void setPerson(Person person) {
    this.person = person;
  }

  @Override
  public String toString() {
    return "Ticket{" +
        "id=" + getId() +
        ", numberSeat=" + numberSeat +
        ", carriage=" + carriage +
//        ", id_carriage=" + id_carriage +
        ", train=" + train +
//        ", id_train=" + id_train +
        ", inSchedule=" + inSchedule +
//        ", id_inSchedule=" + id_inSchedule +
        ", outSchedule=" + outSchedule +
//        ", id_outSchedule=" + id_outSchedule +
        ", date=" + date +
        ", price=" + price +
        ", person=" + person +
        '}';
  }
}
