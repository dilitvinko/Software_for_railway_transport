package railwayTransport.software.entity.schedule;

import railwayTransport.software.entity.BaseEntity;
import railwayTransport.software.entity.train.Train;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.sql.Time;

@Entity
public class Schedule extends BaseEntity {

  @ManyToOne
  @JoinColumn(name = "city_id")
  private City city;
  private int drivingOrder;
  private Time time;
  @ManyToOne
  @JoinColumn(name = "train_id")
  private Train train;

  public Schedule() {
  }

  public Schedule(City city, int drivingOrder, Time time, Train train) {
    this.city = city;
//    this.id_city = id_city;
    this.drivingOrder = drivingOrder;
    this.time = time;
    this.train = train;
//    this.id_train = id_train;
  }

  public City getCity() {
    return city;
  }

  public void setCity(City city) {
    this.city = city;
//    id_city = city.getId();
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

  public Train getTrain() {
    return train;
  }

  public void setTrain(Train train) {
    this.train = train;
//    id_train = train.getId();
  }

//  public long getId_city() {
//    return id_city;
//  }
//
//
//  public long getId_train() {
//    return id_train;
//  }


  @Override
  public String toString() {
    return "Schedule{" +
        "id=" + getId() +
        ", city=" + city +
//        ", id_city=" + id_city +
        ", drivingOrder=" + drivingOrder +
        ", time=" + time +
        ", train=" + train +
//        ", id_train=" + id_train +
        '}';
  }
}
