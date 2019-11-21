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
public class CarriageTrainCitiesDateDto {

  private Long idCarriage;
  private Long idTrain;
  private Long idOutCity;
  private Long idInCity;
  private Date date;

}
