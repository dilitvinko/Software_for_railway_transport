package railwaytransport.software.entity.schedule;

import javax.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import railwaytransport.software.entity.BaseEntity;

@Entity
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class City extends BaseEntity {

  private String name;


}
