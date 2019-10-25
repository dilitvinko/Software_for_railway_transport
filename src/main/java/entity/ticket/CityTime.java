package entity.ticket;

import entity.BaseEntity;

import java.sql.Timestamp;

public class CityTime extends BaseEntity {
    private String city;
    private Timestamp timeDate;

    public CityTime() {
    }

    public CityTime(long id, String city, Timestamp timeDate) {
        super(id);
        this.city = city;
        this.timeDate = timeDate;
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
