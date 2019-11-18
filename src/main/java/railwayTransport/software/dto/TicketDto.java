package railwayTransport.software.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.sql.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TicketDto extends AbstractDto{

  private int numberSeat;
  private CarriageDto carriage;
  private TrainDto train;
  private ScheduleDto inSchedule;
  private ScheduleDto outSchedule;
  private Date date;
  private double price;
  @JsonBackReference(value = "person-ticket")
  private PersonDto person;


}
