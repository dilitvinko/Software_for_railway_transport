package railwaytransport.software.entity.train;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import railwaytransport.software.entity.BaseEntity;

@Entity
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Train extends BaseEntity {

  private String name;
  @JsonManagedReference(value = "train-carriage")
  @OneToMany(mappedBy = "train", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  private Set<Carriage> carriages;


}
