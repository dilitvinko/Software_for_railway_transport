package railwayTransport.software.dto;

import java.sql.Date;
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
public class FreeTicketDTO {

  private long idCarriage;
  private long idTrain;
  private long idOutCity;
  private long idInCity;
  Date date;

}
