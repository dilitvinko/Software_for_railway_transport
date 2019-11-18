package railwayTransport.software.service;


import java.util.List;
import javax.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;
import railwayTransport.software.daoJPA.repository.TypeCarriageRepository;
import railwayTransport.software.dto.TypeCarriageDto;
import railwayTransport.software.dto.mapper.TypeCarriageMapper;
import railwayTransport.software.entity.train.TypeCarriage;
import railwayTransport.software.service.interfaces.TypeCarriageService;

@Service
public class TypeCarriageServiceImpl implements TypeCarriageService {

  private final TypeCarriageRepository typeCarriageRepository;
  private final TypeCarriageMapper mapper;


  public TypeCarriageServiceImpl(
      TypeCarriageRepository typeCarriageRepository, TypeCarriageMapper mapper) {
    this.typeCarriageRepository = typeCarriageRepository;
    this.mapper = mapper;
  }

  @Override
  public List<TypeCarriageDto> findAll() {
    return mapper.listTypeCarriageToListTypeCarriageDto(typeCarriageRepository.findAll());
  }

  @Override
  public TypeCarriageDto findById(long id) {
    return mapper.typeCcarriageToTypeCarriageDto(typeCarriageRepository.getOne(id));
  }

  @Override
  public boolean deleteById(long id) {
    boolean flag = false;
    try {
      typeCarriageRepository.deleteById(id);
      flag = true;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return flag;
  }

  @Override
  public boolean delete(TypeCarriageDto dto) {
    boolean flag = false;
    TypeCarriage typeCarriage = mapper.typeCarriageDtoToTypeCarriage(dto);
    try {
      typeCarriageRepository.delete(typeCarriage);
      flag = true;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return flag;
  }

  @Override
  public TypeCarriageDto create(TypeCarriageDto dto) {
    TypeCarriage typeCarriage = mapper.typeCarriageDtoToTypeCarriage(dto);
    typeCarriageRepository.saveAndFlush(typeCarriage);
    dto = mapper.typeCcarriageToTypeCarriageDto(typeCarriage);
    return dto;
  }

  @Override
  public TypeCarriageDto update(TypeCarriageDto dto) {
    TypeCarriage typeCarriage = mapper.typeCarriageDtoToTypeCarriage(dto);
    typeCarriageRepository.saveAndFlush(typeCarriage);
    dto = mapper.typeCcarriageToTypeCarriageDto(typeCarriage);
    return dto;
  }
}
