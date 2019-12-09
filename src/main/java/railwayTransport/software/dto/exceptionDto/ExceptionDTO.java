package railwayTransport.software.dto.exceptionDto;

import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Data;

//  RFC - recommendation
@Data
@AllArgsConstructor
public class ExceptionDTO {
  private String type;
  private Timestamp timestamp;
  private Integer status;
  private String message;
  private String exceptionMessage;
}
