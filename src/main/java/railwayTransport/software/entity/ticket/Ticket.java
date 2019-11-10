package railwayTransport.software.entity.ticket;

import railwayTransport.software.entity.BaseEntity;
import railwayTransport.software.entity.schedule.Schedule;
import railwayTransport.software.entity.train.Carriage;
import railwayTransport.software.entity.train.Train;
import java.sql.Date;

public class Ticket extends BaseEntity {

  private int numberSeat;
  private Carriage carriage;
  private long id_carriage;
  private Train train;
  private long id_train;
  private Schedule inSchedule;
  private long id_inSchedule;
  private Schedule outSchedule;
  private long id_outSchedule;
  private Date date;
  private double price;


  public Ticket() {
  }

  public Ticket(long id, int numberSeat, Carriage carriage, long id_carriage, Train train,
      long id_train, Schedule inSchedule, long id_inSchedule, Schedule outSchedule,
      long id_outSchedule, Date date, double price) {
    super(id);
    this.numberSeat = numberSeat;
    this.carriage = carriage;
    this.id_carriage = id_carriage;
    this.train = train;
    this.id_train = id_train;
    this.inSchedule = inSchedule;
    this.id_inSchedule = id_inSchedule;
    this.outSchedule = outSchedule;
    this.id_outSchedule = id_outSchedule;
    this.date = date;
    this.price = price;
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
    id_carriage = carriage.getId();
  }

  public Train getTrain() {
    return train;
  }

  public void setTrain(Train train) {
    this.train = train;
    id_train = train.getId();
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
    id_inSchedule = inSchedule.getId();
  }

  public Schedule getOutSchedule() {
    return outSchedule;
  }

  public void setOutSchedule(Schedule outSchedule) {
    this.outSchedule = outSchedule;
    id_outSchedule = outSchedule.getId();
  }

  public long getId_carriage() {
    return id_carriage;
  }

  public long getId_train() {
    return id_train;
  }

  public long getId_inSchedule() {
    return id_inSchedule;
  }

  public long getId_outSchedule() {
    return id_outSchedule;
  }


  @Override
  public String toString() {
    return "Ticket{" +
        "id=" + getId() +
        ", numberSeat=" + numberSeat +
        ", carriage=" + carriage +
        ", id_carriage=" + id_carriage +
        ", train=" + train +
        ", id_train=" + id_train +
        ", inSchedule=" + inSchedule +
        ", id_inSchedule=" + id_inSchedule +
        ", outSchedule=" + outSchedule +
        ", id_outSchedule=" + id_outSchedule +
        ", date=" + date +
        ", price=" + price +
        '}';
  }
}
