package entity.ticket;

import entity.BaseEntity;
import entity.ticket.CityTime;
import entity.train.Train;

import java.util.LinkedHashSet;
import java.util.Set;

public class Route extends BaseEntity {

    private String name;
    private Set<Train> trains;
    private LinkedHashSet<CityTime> cityTimes;

    public Route() {
    }

    public Route(long id, String name, Set<Train> trains, LinkedHashSet<CityTime> cityTimes) {
        super(id);
        this.name = name;
        this.trains = trains;
        this.cityTimes = cityTimes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Train> getTrains() {
        return trains;
    }

    public void setTrains(Set<Train> trains) {
        this.trains = trains;
    }

    public Set<CityTime> getCityTimes() {
        return cityTimes;
    }

    public void setCityTimes(LinkedHashSet<CityTime> cityTimes) {
        this.cityTimes = cityTimes;
    }

    @Override
    public String toString() {
        return "Route{" +
                "id='" + getId() + '\'' +
                "name='" + name +
                ", trains=" + trains +
                ", cityTimes=" + cityTimes +
                '}';
    }
}
