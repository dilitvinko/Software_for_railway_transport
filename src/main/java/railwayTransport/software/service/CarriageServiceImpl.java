package railwayTransport.software.service;


import java.util.List;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;
import railwayTransport.software.daoJPA.repository.CarriageRepository;
import railwayTransport.software.dto.CarriageDto;
import railwayTransport.software.dto.mapper.CarriageMapper;
import railwayTransport.software.entity.train.Carriage;
import railwayTransport.software.service.interfaces.CarriageService;

@Service
public class CarriageServiceImpl implements CarriageService {

 private final CarriageRepository carriageRepository;
 private final CarriageMapper mapper;

  public CarriageServiceImpl(
      CarriageRepository carriageRepository, CarriageMapper mapper) {
    this.carriageRepository = carriageRepository;
    this.mapper = mapper;
  }


  @Override
  public List<CarriageDto> findAll() {
    return mapper.listCarriageToListCarriageDto(carriageRepository.findAll());
  }

  @Override
  public CarriageDto findById(long id) {
    return mapper.carriageToCarriageDto(carriageRepository.getOne(id));
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
  public boolean delete(CarriageDto dto) {
    boolean flag = false;
    Carriage carriage = mapper.carriageDtoToCarriage(dto);
    try{
      carriageRepository.delete(carriage);
      flag = true;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return flag;
  }

  @Override
  public CarriageDto create(CarriageDto dto) {
    Carriage carriage = mapper.carriageDtoToCarriage(dto);
    carriageRepository.saveAndFlush(carriage);
    dto = mapper.carriageToCarriageDto(carriage);
    return dto;
  }

  @Override
  public CarriageDto update(CarriageDto dto) {
    Carriage carriage = mapper.carriageDtoToCarriage(dto);
    carriageRepository.saveAndFlush(carriage);
    dto = mapper.carriageToCarriageDto(carriage);
    return dto;
  }
}
