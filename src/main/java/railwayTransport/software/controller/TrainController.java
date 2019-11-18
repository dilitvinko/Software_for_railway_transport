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
import railwayTransport.software.dto.TrainDto;
import railwayTransport.software.service.TrainServiceImpl;

@RestController
@RequestMapping("/train")
public class TrainController {

  private final TrainServiceImpl trainService;

  public TrainController(TrainServiceImpl trainService) {
    this.trainService = trainService;
  }


  @GetMapping("/all")
  public List<TrainDto> findAllTrains() {
    return trainService.findAll();
  }

  @GetMapping("/{id}")
  public TrainDto getCarriage(@PathVariable Long id) {
    return trainService.findById(id);
  }

  @PostMapping
  public TrainDto createTrains(@RequestBody TrainDto trainDto) {
    return trainService.create(trainDto);
  }

  @DeleteMapping
  public Boolean deleteTrains(@RequestBody TrainDto trainDto) {
    return trainService.delete(trainDto);
  }

  @DeleteMapping("/{id}")
  public Boolean deleteByIdTrains(@PathVariable Long id) {
    return trainService.deleteById(id);
  }

  @PutMapping
  public TrainDto updateTrains(@RequestBody TrainDto trainDto) {
    return trainService.update(trainDto);
  }


}
