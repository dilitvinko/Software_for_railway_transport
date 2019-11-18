package railwayTransport.software.entity.train;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import railwayTransport.software.entity.BaseEntity;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Carriage extends BaseEntity {

  private int number;
  @ManyToOne
  @JoinColumn(name = "type_carriage_id")
  private TypeCarriage typeCarriage;
  @JsonBackReference(value = "train-carriage")
  @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  @JoinColumn(name = "train_id")
  private Train train;


}
