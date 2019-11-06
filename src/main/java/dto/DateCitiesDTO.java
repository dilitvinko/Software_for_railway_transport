package dto;

import java.util.Date;

public class DateCitiesDTO {
    private Date date;
    private String outCity;
    private String inCity;

    public DateCitiesDTO() {
    }

    public DateCitiesDTO(Date date, String outCity, String inCity) {
        this.date = date;
        this.outCity = outCity;
        this.inCity = inCity;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getOutCity() {
        return outCity;
    }

    public void setOutCity(String outCity) {
        this.outCity = outCity;
    }

    public String getInCity() {
        return inCity;
    }

    public void setInCity(String inCity) {
        this.inCity = inCity;
    }

    @Override
    public String toString() {
        return "DateCitiesDTO{" +
                "date=" + date +
                ", outCity='" + outCity + '\'' +
                ", inCity='" + inCity + '\'' +
                '}';
    }
}
