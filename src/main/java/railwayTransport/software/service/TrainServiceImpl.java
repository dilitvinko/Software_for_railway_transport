package railwayTransport.software.service;


import java.util.List;
import javax.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import railwayTransport.software.daoJPA.repository.TrainRepository;
import railwayTransport.software.dto.TrainDto;
import railwayTransport.software.dto.mapper.TrainMapper;
import railwayTransport.software.entity.train.Train;
import railwayTransport.software.service.interfaces.TrainService;

@Service
public class TrainServiceImpl implements TrainService {

  private final TrainRepository trainRepository;
  private final TrainMapper mapper;

  public TrainServiceImpl(
      TrainRepository trainRepository, TrainMapper mapper) {
    this.trainRepository = trainRepository;
    this.mapper = mapper;
  }

  @Override
  public List<TrainDto> findAll() {
    return mapper.listTrainToListTrainDto(trainRepository.findAll());
  }

  @Override
  public TrainDto findById(long id) {
    Train train = trainRepository.findFirstById(id);
//    if (train == null) {
//      throw new EntityNotFoundException("train not found");
//    }
    return mapper.trainToTrainDto(train);
  }

  @Override
  public void deleteById(long id) {
    trainRepository.deleteById(id);
  }

  @Override
  public void delete(TrainDto dto) {
    Train train = mapper.trainDtoToTrain(dto);
    trainRepository.delete(train);
  }

  @Override
  public TrainDto create(TrainDto dto) {
    dto.setId(null);
    Train train = mapper.trainDtoToTrain(dto);
    trainRepository.saveAndFlush(train);
    dto = mapper.trainToTrainDto(train);
    return dto;
  }

  @Override
  public TrainDto update(TrainDto dto) {
    Train train = mapper.trainDtoToTrain(dto);
    if (null == trainRepository.getOne(train.getId())) {
      throw new EntityNotFoundException();
    }
    trainRepository.saveAndFlush(train);
    dto = mapper.trainToTrainDto(train);
    return dto;
  }
}
