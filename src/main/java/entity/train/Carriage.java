package entity.train;


import entity.BaseEntity;

import java.util.Set;

public class Carriage extends BaseEntity {

    private int number;
    private TypeCarriage type;
    private Set<Seat> seats;

    public Carriage() {
    }

    public Carriage(long id, int number, TypeCarriage type, Set<Seat> seats) {
        super(id);
        this.number = number;
        this.type = type;
        this.seats = seats;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public TypeCarriage getType() {
        return type;
    }

    public void setType(TypeCarriage type) {
        this.type = type;
    }

    public Set<Seat> getSeats() {
        return seats;
    }

    public void setSeats(Set<Seat> seats) {
        this.seats = seats;
    }
}
