package railwayTransport.software.service;


import java.util.List;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;
import railwayTransport.software.daoJPA.repository.TrainRepository;
import railwayTransport.software.dto.CarriageDto;
import railwayTransport.software.dto.TrainDto;
import railwayTransport.software.entity.train.Carriage;
import railwayTransport.software.entity.train.Train;
import railwayTransport.software.service.interfaces.TrainService;

@Service
public class TrainServiceImpl implements TrainService {

  private final TrainRepository trainRepository;
  private final ModelMapper modelMapper;

  public TrainServiceImpl(
      TrainRepository trainRepository, ModelMapper modelMapper) {
    this.trainRepository = trainRepository;
    this.modelMapper = modelMapper;
  }

  @Override
  public List<TrainDto> findAll() {
    List<Train> carriages = trainRepository.findAll();
    List<TrainDto> dtoList = modelMapper.map(carriages, new TypeToken<List<TrainDto>>() {
    }.getType());
    return dtoList;
  }

  @Override
  public TrainDto findById(long id) {
    return modelMapper.map(trainRepository.getOne(id), new TypeToken<CarriageDto>() {
    }.getType());
  }

  @Override
  public boolean deleteById(long id) {
    boolean flag = false;
    try{
      trainRepository.deleteById(id);
      flag = true;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return flag;
  }

  @Override
  public boolean delete(TrainDto entity) {
    boolean flag = false;
    Train train = modelMapper.map(entity, new TypeToken<TrainDto>() {
    }.getType());
    try{
      trainRepository.delete(train);
      flag = true;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return flag;
  }

  @Override
  public TrainDto create(TrainDto entity) {
    Train train = new Train();
    modelMapper.map(entity, train);
    trainRepository.saveAndFlush(train);
    entity = modelMapper.map(train, new TypeToken<TrainDto>() {
    }.getType());
    return entity;
  }

  @Override
  public TrainDto update(TrainDto entity) {
    Train train = new Train();
    modelMapper.map(entity, train);
    trainRepository.saveAndFlush(train);
    entity = modelMapper.map(train, new TypeToken<TrainDto>() {
    }.getType());
    return entity;
  }
}
