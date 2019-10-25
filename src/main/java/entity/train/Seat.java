package entity.train;

import entity.BaseEntity;

public class Seat extends BaseEntity {

    private int number;

    public Seat() {
    }

    public Seat(long id, int number) {
        super(id);
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }


}
