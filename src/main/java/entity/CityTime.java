package entity;

import java.util.Date;

public class CityTime {
    private long id;
    private String city;
    private Date timeDate;

    public CityTime() {
    }

    public CityTime(String city, Date timeDate) {
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

    public Date getTimeDate() {
        return timeDate;
    }

    public void setTimeDate(Date timeDate) {
        this.timeDate = timeDate;
    }
}
