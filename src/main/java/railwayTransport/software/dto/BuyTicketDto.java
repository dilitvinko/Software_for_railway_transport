package railwayTransport.software.dto;

import java.sql.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BuyTicketDto {

  private int numberSeat;
  private Long idCarriage;
  private Long idTrain;
  private Long idOutSchedule;
  private Long idInSchedule;
  private Date date;
  private Long idPerson;

}
