package railwayTransport.software.dto;

public class CityDto extends AbstractDto{

  private String name;

  public CityDto() {
  }

  public CityDto(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
