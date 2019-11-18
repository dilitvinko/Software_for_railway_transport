package railwayTransport.software.dto;

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
public class FreeTicketDTO {

  private long idCarriage;
  private long idTrain;
  private long idOutCity;
  private long idInCity;
  Date date;


}
