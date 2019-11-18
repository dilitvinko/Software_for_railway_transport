package railwayTransport.software.entity.train;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import railwayTransport.software.entity.BaseEntity;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TypeCarriage extends BaseEntity {

  private String type;
  private int amountSeats;
  private double cooffPrise;


}
