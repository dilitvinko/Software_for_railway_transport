package railwaytransport.software.entity.ticket;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import railwaytransport.software.entity.BaseEntity;
import railwaytransport.software.entity.person.Person;
import railwaytransport.software.entity.schedule.Schedule;
import railwaytransport.software.entity.train.Carriage;
import railwaytransport.software.entity.train.Train;

@Entity
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Ticket extends BaseEntity {

  private int numberSeat;
  @ManyToOne
  @JoinColumn(name = "carriage_id")
  private Carriage carriage;
  @ManyToOne
  @JoinColumn(name = "train_id")
  private Train train;
  @ManyToOne
  @JoinColumn(name = "in_schedule_id")
  private Schedule inSchedule;
  @ManyToOne
  @JoinColumn(name = "out_schedule_id")
  private Schedule outSchedule;
  private Date date;
  private double price;
  @JsonBackReference(value = "person-ticket")
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "person_id")
  private Person person;

}
