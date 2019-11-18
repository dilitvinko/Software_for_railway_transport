package railwayTransport.software.controller;

import com.ibm.icu.impl.Pair;
import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import railwayTransport.software.dto.DateCitiesDTO;
import railwayTransport.software.dto.PairScheduleDTO;
import railwayTransport.software.entity.schedule.Schedule;

@RestController
@RequestMapping("/choose")
public class BuyTicketController {

  @PostMapping
  public List<PairScheduleDTO> showSchedule(DateCitiesDTO dateCitiesDTO){
    return null;
  }

}
