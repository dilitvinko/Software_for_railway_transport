package railwayTransport.software.dto;

import java.sql.Date;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class TicketDto extends AbstractDto {

  @DecimalMax("100")
  @DecimalMin("1")
  private int numberSeat;
  @NotNull
  private CarriageDto carriage;
  @NotNull
  private TrainDto train;
  @NotNull
  private ScheduleDto inSchedule;
  @NotNull
  private ScheduleDto outSchedule;
  @NotNull
  private Date date;
  @DecimalMin("0")
  private double price;
  @NotNull
  private Long idPerson;

}
