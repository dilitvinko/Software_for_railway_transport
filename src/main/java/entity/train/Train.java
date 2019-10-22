package entity.train;

import java.util.Set;

public class Train {
    private long id;
    private String name;
    private Set<Carriage> carriages;

    public Train() {
    }

    public Train(String number, Set<Carriage> carriages) {
        this.name = number;
        this.carriages = carriages;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Carriage> getCarriages() {
        return carriages;
    }

    public void setCarriages(Set<Carriage> carriages) {
        this.carriages = carriages;
    }
}
