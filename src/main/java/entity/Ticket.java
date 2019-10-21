package entity;

import entity.train.Carriage;
import entity.train.Seat;

public class Ticket {
    private long id;
    private Seat seat;
    private Carriage carriage;
    private Route route;
    private CityTime out;
    private CityTime in;

    public Ticket() {
    }

    public Ticket(Seat seat, Carriage carriage, Route route, CityTime out, CityTime in) {
        this.seat = seat;
        this.carriage = carriage;
        this.route = route;
        this.out = out;
        this.in = in;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public Carriage getCarriage() {
        return carriage;
    }

    public void setCarriage(Carriage carriage) {
        this.carriage = carriage;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public CityTime getOut() {
        return out;
    }

    public void setOut(CityTime out) {
        this.out = out;
    }

    public CityTime getIn() {
        return in;
    }

    public void setIn(CityTime in) {
        this.in = in;
    }
}
