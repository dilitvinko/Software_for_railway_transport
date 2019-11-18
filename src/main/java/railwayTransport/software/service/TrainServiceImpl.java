package railwayTransport.software.service;


import java.util.List;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;
import railwayTransport.software.daoJPA.repository.TrainRepository;
import railwayTransport.software.dto.CarriageDto;
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
    return mapper.trainToTrainDto(trainRepository.getOne(id));
  }

  @Override
  public boolean deleteById(long id) {
    boolean flag = false;
    try {
      trainRepository.deleteById(id);
      flag = true;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return flag;
  }

  @Override
  public boolean delete(TrainDto dto) {
    boolean flag = false;
    Train train = mapper.trainDtoToTrain(dto);
    try {
      trainRepository.delete(train);
      flag = true;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return flag;
  }

  @Override
  public TrainDto create(TrainDto dto) {
    Train train = mapper.trainDtoToTrain(dto);
    trainRepository.saveAndFlush(train);
    dto = mapper.trainToTrainDto(train);
    return dto;
  }

  @Override
  public TrainDto update(TrainDto dto) {
    Train train = mapper.trainDtoToTrain(dto);
    trainRepository.saveAndFlush(train);
    dto = mapper.trainToTrainDto(train);
    return dto;
  }
}
