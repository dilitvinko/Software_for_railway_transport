package railwayTransport.software.dto;

public class TypeCarriageDto extends AbstractDto {

  private String type;
  private int amountSeats;
  private double cooffPrise;

  public TypeCarriageDto() {
  }

  public TypeCarriageDto(String type, int amountSeats, double cooffPrise) {
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
}
