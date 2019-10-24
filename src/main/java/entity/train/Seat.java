package entity.train;

public class Seat {
    private long id;
    private int number;

    public Seat() {
    }

    public Seat(int number) {
        this.number = number;
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


}
