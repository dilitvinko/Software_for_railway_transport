package railwayTransport.software.entity.schedule;

import railwayTransport.software.entity.BaseEntity;

import javax.persistence.Entity;

@Entity
public class City extends BaseEntity {

  private String name;

  public City() {
  }

  public City(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "City{" +
        "id=" + getId() +
        ", name='" + name + '\'' +
        '}';
  }
}
