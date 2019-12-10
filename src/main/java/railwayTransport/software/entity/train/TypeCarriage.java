package railwayTransport.software.entity.train;

import javax.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import railwayTransport.software.entity.BaseEntity;

@Entity
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class TypeCarriage extends BaseEntity {

  private String type;
  private int amountSeats;
  private double cooffPrise;

}
