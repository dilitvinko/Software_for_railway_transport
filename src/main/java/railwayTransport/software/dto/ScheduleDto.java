package railwayTransport.software.dto;

import java.sql.Time;

public class ScheduleDto extends AbstractDto {


  private CityDto city;
  private int drivingOrder;
  private Time time;
  private TrainDto train;

  public ScheduleDto() {
  }

  public ScheduleDto(CityDto city, int drivingOrder, Time time,
      TrainDto train) {
    this.city = city;
    this.drivingOrder = drivingOrder;
    this.time = time;
    this.train = train;
  }

  public CityDto getCity() {
    return city;
  }

  public void setCity(CityDto city) {
    this.city = city;
  }

  public int getDrivingOrder() {
    return drivingOrder;
  }

  public void setDrivingOrder(int drivingOrder) {
    this.drivingOrder = drivingOrder;
  }

  public Time getTime() {
    return time;
  }

  public void setTime(Time time) {
    this.time = time;
  }

  public TrainDto getTrain() {
    return train;
  }

  public void setTrain(TrainDto train) {
    this.train = train;
  }
}
