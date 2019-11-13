package railwayTransport.software.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;

public class CarriageDto extends AbstractDto{

  private int number;
  private TypeCarriageDto typeCarriage;
  @JsonBackReference(value = "train-carriage")
  private TrainDto train;

  public CarriageDto(int number, TypeCarriageDto typeCarriage,
      TrainDto train) {
    this.number = number;
    this.typeCarriage = typeCarriage;
    this.train = train;
  }

  public CarriageDto() {
  }

  public int getNumber() {
    return number;
  }

  public void setNumber(int number) {
    this.number = number;
  }

  public TypeCarriageDto getTypeCarriage() {
    return typeCarriage;
  }

  public void setTypeCarriage(TypeCarriageDto typeCarriage) {
    this.typeCarriage = typeCarriage;
  }

  public TrainDto getTrain() {
    return train;
  }

  public void setTrain(TrainDto train) {
    this.train = train;
  }
}
