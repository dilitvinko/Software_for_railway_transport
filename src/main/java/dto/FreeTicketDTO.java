package dto;

import java.sql.Date;

public class FreeTicketDTO {

  private long idCarriage;
  private long idTrain;
  private long idOutCity;
  private long idInCity;
  Date date;

  public FreeTicketDTO() {
  }

  public FreeTicketDTO(long idCarriage, long idTrain, long idOutCity, long idInCity,
      Date date) {
    this.idCarriage = idCarriage;
    this.idTrain = idTrain;
    this.idOutCity = idOutCity;
    this.idInCity = idInCity;
    this.date = date;
  }

  public long getIdCarriage() {
    return idCarriage;
  }

  public void setIdCarriage(long idCarriage) {
    this.idCarriage = idCarriage;
  }

  public long getIdTrain() {
    return idTrain;
  }

  public void setIdTrain(long idTrain) {
    this.idTrain = idTrain;
  }

  public long getIdOutCity() {
    return idOutCity;
  }

  public void setIdOutCity(long idOutCity) {
    this.idOutCity = idOutCity;
  }

  public long getIdInCity() {
    return idInCity;
  }

  public void setIdInCity(long idInCity) {
    this.idInCity = idInCity;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  @Override
  public String toString() {
    return "FreeTicketDTO{" +
        "idCarriage=" + idCarriage +
        ", idTrain=" + idTrain +
        ", idOutCity=" + idOutCity +
        ", idInCity=" + idInCity +
        ", date=" + date +
        '}';
  }
}
