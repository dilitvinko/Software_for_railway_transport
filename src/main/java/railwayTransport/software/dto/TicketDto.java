package railwayTransport.software.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.sql.Date;

public class TicketDto extends AbstractDto{

  private int numberSeat;
  private CarriageDto carriage;
  private TrainDto train;
  private ScheduleDto inSchedule;
  private ScheduleDto outSchedule;
  private Date date;
  private double price;
  @JsonBackReference(value = "person-ticket")
  private PersonDto person;

  public TicketDto() {
  }

  public TicketDto(int numberSeat, CarriageDto carriage, TrainDto train,
      ScheduleDto inSchedule, ScheduleDto outSchedule, Date date, double price,
      PersonDto person) {
    this.numberSeat = numberSeat;
    this.carriage = carriage;
    this.train = train;
    this.inSchedule = inSchedule;
    this.outSchedule = outSchedule;
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

  public CarriageDto getCarriage() {
    return carriage;
  }

  public void setCarriage(CarriageDto carriage) {
    this.carriage = carriage;
  }

  public TrainDto getTrain() {
    return train;
  }

  public void setTrain(TrainDto train) {
    this.train = train;
  }

  public ScheduleDto getInSchedule() {
    return inSchedule;
  }

  public void setInSchedule(ScheduleDto inSchedule) {
    this.inSchedule = inSchedule;
  }

  public ScheduleDto getOutSchedule() {
    return outSchedule;
  }

  public void setOutSchedule(ScheduleDto outSchedule) {
    this.outSchedule = outSchedule;
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

  public PersonDto getPerson() {
    return person;
  }

  public void setPerson(PersonDto person) {
    this.person = person;
  }
}
