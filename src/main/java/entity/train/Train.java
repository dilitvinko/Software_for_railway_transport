package entity.train;

import java.util.Set;

public class Train {
    private long id;
    private int number;
    private Set<Carriage> carriages;

    public Train() {
    }

    public Train(int number, Set<Carriage> carriages) {
        this.number = number;
        this.carriages = carriages;
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

    public Set<Carriage> getCarriages() {
        return carriages;
    }

    public void setCarriages(Set<Carriage> carriages) {
        this.carriages = carriages;
    }
}
