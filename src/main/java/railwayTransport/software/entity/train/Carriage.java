package railwayTransport.software.entity.train;


import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
public class Carriage extends BaseEntity {

  private int number;
  @ManyToOne
  @JoinColumn(name = "type_carriage_id")
  private TypeCarriage typeCarriage;
  @JsonBackReference(value = "train-carriage")
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "train_id")
  private Train train;


}
