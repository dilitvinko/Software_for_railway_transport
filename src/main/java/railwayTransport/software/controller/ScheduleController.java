package railwayTransport.software.controller;

import java.util.List;
import javax.ws.rs.core.Response;
import lombok.extern.log4j.Log4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import railwayTransport.software.dto.ScheduleDto;
import railwayTransport.software.service.ScheduleServiceImpl;

@Log4j
@RestController
@RequestMapping("/schedules")
public class ScheduleController {

  private final ScheduleServiceImpl scheduleService;

  public ScheduleController(ScheduleServiceImpl scheduleService) {
    this.scheduleService = scheduleService;
  }


  @GetMapping
  public List<ScheduleDto> findAllSchedules() {
    log.info("Get List<Dto> ");
    return scheduleService.findAll();
  }

  @GetMapping("/{id}")
  public ScheduleDto getCarriage(@PathVariable Long id) {
    log.info("Get Dto by id =  " + id);
    return scheduleService.findById(id);
  }

  @PostMapping
  public ScheduleDto createSchedule(@RequestBody ScheduleDto scheduleDto) {
    log.info("Create Dto");
    return scheduleService.create(scheduleDto);
  }

  @DeleteMapping
  public @ResponseBody
  Response deleteSchedule(@RequestBody ScheduleDto scheduleDto) {
    log.info("Delete Dto by dto");
    scheduleService.delete(scheduleDto);
    return Response.status(Response.Status.OK.getStatusCode()).build();
  }

  @DeleteMapping("/{id}")
  public @ResponseBody
  Response deleteByIdSchedule(@PathVariable Long id) {
    log.info("Delete Dto by id = " + id);
    scheduleService.deleteById(id);
    return Response.status(Response.Status.OK.getStatusCode()).build();
  }

  @PutMapping
  public ScheduleDto updateSchedule(@RequestBody ScheduleDto scheduleDto) {
    log.info("Update Dto by dto");
    return scheduleService.update(scheduleDto);
  }

}
