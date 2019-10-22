package entity;

import java.sql.Timestamp;

public class CityTime {
    private long id;
    private String city;
    private Timestamp timeDate;

    public CityTime() {
    }

    public CityTime(String city, Timestamp timeDate) {
        this.city = city;
        this.timeDate = timeDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Timestamp getTimeDate() {
        return timeDate;
    }

    public void setTimeDate(Timestamp timeDate) {
        this.timeDate = timeDate;
    }
}
