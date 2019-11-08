package entity.schedule;

import entity.BaseEntity;
import entity.train.Train;
import java.sql.Time;

public class Schedule extends BaseEntity {

  private City city;
  private long id_city;
  private int order;
  private Time time;
  private Train train;
  private long id_train;

  public Schedule() {
  }

  public Schedule(long id, City city, long id_city, int order, Time time, Train train,
      long id_train) {
    super(id);
    this.city = city;
    this.id_city = id_city;
    this.order = order;
    this.time = time;
    this.train = train;
    this.id_train = id_train;
  }

  public City getCity() {
    return city;
  }

  public void setCity(City city) {
    this.city = city;
    id_city = city.getId();
  }

  public int getOrder() {
    return order;
  }

  public void setOrder(int order) {
    this.order = order;
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
    id_train = train.getId();
  }

  public long getId_city() {
    return id_city;
  }


  public long getId_train() {
    return id_train;
  }


  @Override
  public String toString() {
    return "Schedule{" +
        "id=" + getId() +
        ", city=" + city +
        ", id_city=" + id_city +
        ", order=" + order +
        ", time=" + time +
        ", train=" + train +
        ", id_train=" + id_train +
        '}';
  }
}
