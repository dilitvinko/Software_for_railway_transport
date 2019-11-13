package railwayTransport.software.controller;

import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import railwayTransport.software.daoJPA.repository.CarriageRepository;
import railwayTransport.software.daoJPA.repository.TrainRepository;
import railwayTransport.software.dto.CarriageDto;
import railwayTransport.software.dto.TrainDto;
import railwayTransport.software.entity.train.Carriage;
import railwayTransport.software.entity.train.Train;
import railwayTransport.software.service.CarriageServiceImpl;

@RestController
@RequestMapping("/train")
public class TrainController {

  final private TrainRepository trainRepository;
  final private CarriageRepository carriageRepository;
  final private CarriageServiceImpl carriageService;

  public TrainController(TrainRepository trainRepository,
      CarriageRepository carriageRepository,
      CarriageServiceImpl carriageService) {
    this.trainRepository = trainRepository;
    this.carriageRepository = carriageRepository;
    this.carriageService = carriageService;
  }

  @GetMapping("/all")
  public List<Train> findAllTrains(){
    return trainRepository.findAll();
  }

  @GetMapping("/{id}")
  public TrainDto findTrainById(@PathVariable Long id) {
    Train train = trainRepository.findFirstById(id);
    Train train2 = trainRepository.getOne(id);
    ModelMapper modelMapper = new ModelMapper();
    TrainDto trainDto = new TrainDto();
    modelMapper.map(train2, trainDto);
    return trainDto;
  }

  @PostMapping
  public Train addTrain(@RequestBody Train train){
    return trainRepository.saveAndFlush(train);
  }

   @GetMapping("/carriages")
  public List<CarriageDto> getCarriages(){
    return carriageService.findAll();
   }

   @GetMapping("/carriage")
  public CarriageDto getCarriage(){
     return carriageService.findById(Long.valueOf(1));
   }

  @PostMapping("/createcarrriage")
  public CarriageDto createCarriage(@RequestBody CarriageDto carriageDto){
    return carriageService.create(carriageDto);
  }


}
