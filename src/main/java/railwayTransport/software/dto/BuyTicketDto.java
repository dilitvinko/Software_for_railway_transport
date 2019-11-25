package railwayTransport.software.dto;

import java.sql.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.RequestParam;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BuyTicketDto {

  private Long idPerson;
  private int numberSeat;
  private Long idCarriage;
  private Long idTrain;
  private Date date;
  private String outCity;
  private String inCity;

}
