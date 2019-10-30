package entity.ticket;

import entity.BaseEntity;
import entity.schedule.City;
import entity.train.*;

import java.sql.Date;
import java.sql.Time;

public class Ticket extends BaseEntity {
    private int numberSeat;
    private Carriage carriage;
    private long id_carriage;
    private Train train;
    private long id_train;
    private City outCity;
    private long id_out_city;
    private City inCity;
    private long id_in_city;
    private Time outTime;
    private Time inTime;
    private Date date;
    private double price;

    public Ticket() {
    }

    public Ticket(long id, int numberSeat, Carriage carriage, long id_carriage, Train train, long id_train, City outCity, long id_out_city, City inCity, long id_in_city, Time outTime, Time inTime, Date date, double price) {
        super(id);
        this.numberSeat = numberSeat;
        this.carriage = carriage;
        this.id_carriage = id_carriage;
        this.train = train;
        this.id_train = id_train;
        this.outCity = outCity;
        this.id_out_city = id_out_city;
        this.inCity = inCity;
        this.id_in_city = id_in_city;
        this.outTime = outTime;
        this.inTime = inTime;
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

    public City getOutCity() {
        return outCity;
    }

    public void setOutCity(City outCity) {
        this.outCity = outCity;
        id_out_city = outCity.getId();
    }

    public City getInCity() {
        return inCity;
    }

    public void setInCity(City inCity) {
        this.inCity = inCity;
        id_in_city = inCity.getId();
    }

    public Time getOutTime() {
        return outTime;
    }

    public void setOutTime(Time outTime) {
        this.outTime = outTime;
    }

    public Time getInTime() {
        return inTime;
    }

    public void setInTime(Time inTime) {
        this.inTime = inTime;
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

    public long getId_carriage() {
        return id_carriage;
    }

    public long getId_train() {
        return id_train;
    }

    public long getId_out_city() {
        return id_out_city;
    }

    public long getId_in_city() {
        return id_in_city;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + getId() +
                ", numberSeat=" + numberSeat +
                ", carriage=" + carriage +
                ", train=" + train +
                ", outCity=" + outCity +
                ", inCity=" + inCity +
                ", outTime=" + outTime +
                ", inTime=" + inTime +
                ", date=" + date +
                ", price=" + price +
                '}';
    }
}
