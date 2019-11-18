package railwayTransport.software.entity.ticket;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import railwayTransport.software.entity.BaseEntity;
import railwayTransport.software.entity.person.Person;
import railwayTransport.software.entity.schedule.Schedule;
import railwayTransport.software.entity.train.Carriage;
import railwayTransport.software.entity.train.Train;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.sql.Date;

@Entity
@Getter
@Setter
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
  @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  @JoinColumn(name = "person_id")
  private Person person;



}