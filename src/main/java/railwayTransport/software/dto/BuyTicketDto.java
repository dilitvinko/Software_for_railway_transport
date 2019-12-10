package railwayTransport.software.dto;

import java.sql.Date;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
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


  private Long idPerson;
  @DecimalMax("100")
  @DecimalMin("1")
  private int numberSeat;
  @NotNull
  private Long idCarriage;
  @NotNull
  private Long idTrain;
  @NotNull
  private Date date;
  @NotEmpty
  private String outCity;
  @NotEmpty
  private String inCity;

}
