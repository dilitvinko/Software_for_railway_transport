package railwayTransport.software.dto;

import java.sql.Date;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
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
  @DecimalMax("100")
  @DecimalMin("1")
  private int numberSeat;
  @NotNull
  private Long idCarriage;
  @NotNull
  private Long idTrain;
  @NotNull
  //@Future
  private Date date;
  @NotEmpty
  private String outCity;
  @NotEmpty
  private String inCity;

//  @NotBlank: поле обязательно для заполнения.
//  @Email: значение должно по формату подходить для использования в качестве email.
//  @Pattern: значение должно удовлетворять регулярному выражению.
//  @Past: дата/время должно быть в прошлом
//  @Pattern(regexp = "\\+7[0-9]{10}", message = "Телефонный номер должен начинаться с +7, затем - 10 цифр")

}
