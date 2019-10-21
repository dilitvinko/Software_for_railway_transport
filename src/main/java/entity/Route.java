package entity;

import entity.train.Train;

import java.util.Set;

public class Route {
    private long id;
    private String name;
    private Train train;
    private Set<CityTime> setCityTimes;

    public Route() {
    }

    public Route(String name, Train train, Set<CityTime> setCityTimes) {
        this.name = name;
        this.train = train;
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

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    public Set<CityTime> getSetCityTimes() {
        return setCityTimes;
    }

    public void setSetCityTimes(Set<CityTime> setCityTimes) {
        this.setCityTimes = setCityTimes;
    }
}
