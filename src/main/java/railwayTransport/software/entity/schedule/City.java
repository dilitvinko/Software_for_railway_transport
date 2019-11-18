package railwayTransport.software.entity.schedule;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import railwayTransport.software.entity.BaseEntity;

import javax.persistence.Entity;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class City extends BaseEntity {

  private String name;


}
