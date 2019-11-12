package railwayTransport.software.entity.train;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import railwayTransport.software.entity.BaseEntity;

@Entity
public class Train extends BaseEntity{

  private String name;
  @OneToMany(mappedBy = "train", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  private Set<Carriage> carriages;

  public Train() {
  }

  public Train(String name, Set<Carriage> carriages) {
    this.name = name;
    this.carriages = carriages;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Set<Carriage> getCarriages() {
    return carriages;
  }

  public void setCarriages(Set<Carriage> carriages) {
    this.carriages = carriages;
  }


  @Override
  public String toString() {
    return "Train{" +
        "id=" + getId() +
        ", name='" + name + '\'' +
        ", carriages=" + carriages +
        '}';
  }
}
