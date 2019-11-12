package railwayTransport.software.entity.train;

import railwayTransport.software.entity.BaseEntity;

import javax.persistence.Entity;

@Entity
public class TypeCarriage extends BaseEntity {

  private String type;
  private int amountSeats;
  private double cooffPrise;

  public TypeCarriage() {
  }

  public TypeCarriage(String type, int amountSeats, double cooffPrise) {
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
