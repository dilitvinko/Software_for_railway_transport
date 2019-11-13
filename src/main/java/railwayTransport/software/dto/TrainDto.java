package railwayTransport.software.dto;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.Set;

public class TrainDto extends AbstractDto {

  private String name;
  @JsonManagedReference(value = "train-carriage")
  private Set<CarriageDto> carriages;

  public TrainDto() {
  }

  public TrainDto(String name, Set<CarriageDto> carriages) {
    this.name = name;
    this.carriages = carriages;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Set<CarriageDto> getCarriages() {
    return carriages;
  }

  public void setCarriages(Set<CarriageDto> carriages) {
    this.carriages = carriages;
  }
}
