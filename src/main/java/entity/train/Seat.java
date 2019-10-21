package entity.train;

public class Seat {
    private long id;
    private int number;
    private boolean isFree;

    public Seat() {
    }

    public Seat(int number, boolean isFree) {
        this.number = number;
        this.isFree = isFree;
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

    public boolean isFree() {
        return isFree;
    }

    public void setFree(boolean free) {
        isFree = free;
    }
}
