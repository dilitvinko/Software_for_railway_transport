package railwayTransport.software.service;


import java.util.List;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;
import railwayTransport.software.daoJPA.repository.CarriageRepository;
import railwayTransport.software.dto.CarriageDto;
import railwayTransport.software.entity.train.Carriage;
import railwayTransport.software.service.interfaces.CarriageService;

@Service
public class CarriageServiceImpl implements CarriageService {

 private final CarriageRepository carriageRepository;
 private final ModelMapper modelMapper;

  public CarriageServiceImpl(
      CarriageRepository carriageRepository, ModelMapper modelMapper) {
    this.carriageRepository = carriageRepository;
    this.modelMapper = modelMapper;
  }


  @Override
  public List<CarriageDto> findAll() {
    List<Carriage> carriages = carriageRepository.findAll();
    List<CarriageDto> map = modelMapper.map(carriages, new TypeToken<List<CarriageDto>>() {
    }.getType());
    return map;
  }

  @Override
  public CarriageDto findById(long id) {
    return modelMapper.map(carriageRepository.getOne(id), new TypeToken<CarriageDto>() {
    }.getType());
  }

  @Override
  public boolean deleteById(long id) {
    boolean flag = false;
    try{
      carriageRepository.deleteById(id);
      flag = true;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return flag;
  }

  @Override
  public boolean delete(CarriageDto entity) {
    boolean flag = false;
    Carriage carriage = modelMapper.map(entity, new TypeToken<CarriageDto>() {
    }.getType());
    try{
      carriageRepository.delete(carriage);
      flag = true;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return flag;
  }

  @Override
  public CarriageDto create(CarriageDto entity) {
    Carriage carriage = new Carriage();
    modelMapper.map(entity, carriage);
    carriageRepository.saveAndFlush(carriage);
    entity = modelMapper.map(carriage, new TypeToken<CarriageDto>() {
    }.getType());
    return entity;
  }

  @Override
  public CarriageDto update(CarriageDto entity) {
    Carriage carriage = new Carriage();
    modelMapper.map(entity, carriage);
    carriageRepository.saveAndFlush(carriage);
    entity = modelMapper.map(carriage, new TypeToken<CarriageDto>() {
    }.getType());
    return entity;
  }
}
