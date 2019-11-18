package railwayTransport.software.controller;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import railwayTransport.software.dto.ScheduleDto;
import railwayTransport.software.service.ScheduleServiceImpl;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {

  private final ScheduleServiceImpl scheduleService;

  public ScheduleController(ScheduleServiceImpl scheduleService) {
    this.scheduleService = scheduleService;
  }


  @GetMapping("/all")
  public List<ScheduleDto> findAllSchedules() {
    return scheduleService.findAll();
  }

  @GetMapping("/{id}")
  public ScheduleDto getCarriage(@PathVariable Long id) {
    return scheduleService.findById(id);
  }

  @PostMapping
  public ScheduleDto createSchedules(@RequestBody ScheduleDto scheduleDto) {
    return scheduleService.create(scheduleDto);
  }

  @DeleteMapping
  public Boolean deleteSchedules(@RequestBody ScheduleDto scheduleDto) {
    return scheduleService.delete(scheduleDto);
  }

  @DeleteMapping("/{id}")
  public Boolean deleteByIdSchedules(@PathVariable Long id) {
    return scheduleService.deleteById(id);
  }

  @PutMapping
  public ScheduleDto updateSchedules(@RequestBody ScheduleDto scheduleDto) {
    return scheduleService.update(scheduleDto);
  }

}
