package entity;

import entity.train.Train;

import java.util.Set;

public class Route {
    private long id;
    private String name;
    private Set<Train> trains;
    private Set<CityTime> setCityTimes;

    public Route() {
    }

    public Route(String name, Set<Train> train, Set<CityTime> setCityTimes) {
        this.name = name;
        this.trains = train;
        this.setCityTimes = setCityTimes;
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

    public Set<Train> getTrains() {
        return trains;
    }

    public void setTrains(Set<Train> trains) {
        this.trains = trains;
    }

    public Set<CityTime> getSetCityTimes() {
        return setCityTimes;
    }

    public void setSetCityTimes(Set<CityTime> setCityTimes) {
        this.setCityTimes = setCityTimes;
    }
}
