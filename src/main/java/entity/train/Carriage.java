package entity.train;


import java.util.Set;

public class Carriage {
    private long id;
    private int number;
    private TypeCarriage type;
    private Set<Seat> seats;

    public Carriage() {
    }

    public Carriage(int number, TypeCarriage type, Set<Seat> seats) {
        this.number = number;
        this.type = type;
        this.seats = seats;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
