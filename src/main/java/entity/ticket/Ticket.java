package entity.ticket;

import entity.BaseEntity;
import entity.ticket.CityTime;
import entity.ticket.Route;
import entity.train.Carriage;
import entity.train.Seat;
import entity.train.Train;

public class Ticket extends BaseEntity {
    private Seat seat;
    private Carriage carriage;
    private Train train;
    private Route route;
    private CityTime out;
    private CityTime in;

    public Ticket() {
    }

    public Ticket(long id, Seat seat, Carriage carriage, Train train, Route route, CityTime out, CityTime in) {
        super(id);
        this.seat = seat;
        this.carriage = carriage;
        this.train = train;
        this.route = route;
        this.out = out;
        this.in = in;
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

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
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
