package railwayTransport.software.controller;

import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import railwayTransport.software.dto.TrainDto;
import railwayTransport.software.entity.train.Train;
import railwayTransport.software.service.TrainServiceImpl;

@RestController
@RequestMapping("/train")
public class TrainController {

  final private TrainServiceImpl trainService;

  public TrainController(TrainServiceImpl trainService) {
    this.trainService = trainService;
  }


  @GetMapping("/all")
  public List<TrainDto> findAllTrains(){
    return trainService.findAll();
  }

  @GetMapping("/{id}")
  public TrainDto findTrainById(@PathVariable Long id) {
    return trainService.findById(id);
  }

  @PostMapping
  public TrainDto addTrain(@RequestBody TrainDto trainDto){
    return trainService.create(trainDto);
  }




}
