package railwayTransport.software.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import railwayTransport.software.daoJPA.repository.TrainRepository;
import railwayTransport.software.entity.train.Train;

@RestController
@RequestMapping("/train")
public class TrainController {

  final private TrainRepository trainRepository;

  public TrainController(TrainRepository trainRepository) {
    this.trainRepository = trainRepository;
  }

  @GetMapping(path = "/{id}")
  public Train findTrainById(@PathVariable Long id) {
    Train train = trainRepository.findFirstById(id);
    Train train2 = trainRepository.getOne(id);
    return trainRepository.getOne(id);
  }
}
