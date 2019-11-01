package entity.train;

import entity.BaseEntity;

import java.util.Set;

public class Train extends BaseEntity {

    private String name;
    private Set<Carriage> carriages;

    public Train() {
    }

    public Train(long id, String name, Set<Carriage> carriages) {
        super(id);
        this.name = name;
        this.carriages = carriages;
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

    @Override
    public String toString() {
        return "Train{" +
                "id=" + getId() +
                ", name='" + name + '\'' +
                ", carriages=" + carriages +
                '}';
    }
}
