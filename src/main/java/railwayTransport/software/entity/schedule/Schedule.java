package railwayTransport.software.entity.schedule;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import railwayTransport.software.entity.BaseEntity;
import railwayTransport.software.entity.train.Train;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.sql.Time;

@Entity
@Data
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
