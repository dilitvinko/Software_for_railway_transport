package entity.train;

import entity.BaseEntity;

public class TypeCarriage extends BaseEntity {

  private String type;
  private int amountSeats;
  private double cooffPrise;

  public TypeCarriage() {
  }

  public TypeCarriage(long id, String type, int amountSeats, double cooffPrise) {
    super(id);
    this.type = type;
    this.amountSeats = amountSeats;
    this.cooffPrise = cooffPrise;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public int getAmountSeats() {
    return amountSeats;
  }

  public void setAmountSeats(int amountSeats) {
    this.amountSeats = amountSeats;
  }

  public double getCooffPrise() {
    return cooffPrise;
  }

  public void setCooffPrise(double cooffPrise) {
    this.cooffPrise = cooffPrise;
  }

  @Override
  public String toString() {
    return "TypeCarriage{" +
        "id=" + getId() +
        ", type='" + type + '\'' +
        ", amountSeats=" + amountSeats +
        ", cooffPrise=" + cooffPrise +
        '}';
  }
}
