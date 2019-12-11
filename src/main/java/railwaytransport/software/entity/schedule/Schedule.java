package railwaytransport.software.entity.schedule;

import java.sql.Time;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import railwaytransport.software.entity.BaseEntity;
import railwaytransport.software.entity.train.Train;

@Entity
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Schedule extends BaseEntity {

  @ManyToOne
  @JoinColumn(name = "city_id")
  private City city;
  private int drivingOrder;
  private Time time;
  @ManyToOne
  @JoinColumn(name = "train_id")
  private Train train;


}
