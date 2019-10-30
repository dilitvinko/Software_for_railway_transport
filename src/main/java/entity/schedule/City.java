package entity.schedule;

import entity.BaseEntity;

public class City extends BaseEntity {
    private String name;

    public City() {
    }

    public City(long id, String name) {
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
        return "City{" +
                "id=" + getId() +
                ", name='" + name + '\'' +
                '}';
    }
}
