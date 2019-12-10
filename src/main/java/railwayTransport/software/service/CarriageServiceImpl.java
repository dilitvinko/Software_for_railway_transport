package railwayTransport.software.service;


import java.util.List;
import javax.persistence.EntityNotFoundException;
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
  public void deleteById(long id) {
    carriageRepository.deleteById(id);
  }

  @Override
  public void delete(CarriageDto dto) {
    Carriage carriage = mapper.carriageDtoToCarriage(dto);
    carriageRepository.delete(carriage);
  }

  @Override
  public CarriageDto create(CarriageDto dto) {
    dto.setId(null);
    Carriage carriage = mapper.carriageDtoToCarriage(dto);
    carriageRepository.saveAndFlush(carriage);
    dto = mapper.carriageToCarriageDto(carriage);
    return dto;
  }

  @Override
  public CarriageDto update(CarriageDto dto) {
    Carriage carriage = mapper.carriageDtoToCarriage(dto);
    if (null == carriageRepository.getOne(carriage.getId())) {
      throw new EntityNotFoundException();
    }
    carriageRepository.saveAndFlush(carriage);
    dto = mapper.carriageToCarriageDto(carriage);
    return dto;
  }
}
