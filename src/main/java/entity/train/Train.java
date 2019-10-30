package entity.train;

import entity.BaseEntity;

import java.util.Set;

public class Train extends BaseEntity {

    private String name;

    public Train() {
    }

    public Train(long id, String name) {
        super(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Train{" +
                "id=" + getId() +
                ", name='" + name + '\'' +
                '}';
    }
}
