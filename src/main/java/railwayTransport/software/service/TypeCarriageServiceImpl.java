package railwayTransport.software.service;


import java.util.List;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;
import railwayTransport.software.daoJPA.repository.TypeCarriageRepository;
import railwayTransport.software.dto.TypeCarriageDto;
import railwayTransport.software.entity.train.TypeCarriage;
import railwayTransport.software.service.interfaces.TypeCarriageService;

@Service
public class TypeCarriageServiceImpl implements TypeCarriageService {

  private final TypeCarriageRepository typeCarriageRepository;
  private final ModelMapper modelMapper;

  public TypeCarriageServiceImpl(
      TypeCarriageRepository typeCarriageRepository, ModelMapper modelMapper) {
    this.typeCarriageRepository = typeCarriageRepository;
    this.modelMapper = modelMapper;
  }

  @Override
  public List<TypeCarriageDto> findAll() {
    List<TypeCarriage> typeCarriages = typeCarriageRepository.findAll();
    List<TypeCarriageDto> dtoList = modelMapper
        .map(typeCarriages, new TypeToken<List<TypeCarriageDto>>() {
        }.getType());
    return dtoList;
  }

  @Override
  public TypeCarriageDto findById(long id) {
    return modelMapper.map(typeCarriageRepository.getOne(id), new TypeToken<TypeCarriageDto>() {
    }.getType());
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
  public boolean delete(TypeCarriageDto entity) {
    boolean flag = false;
    TypeCarriage typeCarriage = modelMapper.map(entity, new TypeToken<TypeCarriageDto>() {
    }.getType());
    try {
      typeCarriageRepository.delete(typeCarriage);
      flag = true;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return flag;
  }

  @Override
  public TypeCarriageDto create(TypeCarriageDto entity) {
    TypeCarriage typeCarriage = new TypeCarriage();
    modelMapper.map(entity, typeCarriage);
    typeCarriageRepository.saveAndFlush(typeCarriage);
    entity = modelMapper.map(typeCarriage, new TypeToken<TypeCarriageDto>() {
    }.getType());
    return entity;
  }

  @Override
  public TypeCarriageDto update(TypeCarriageDto entity) {
    TypeCarriage typeCarriage = new TypeCarriage();
    modelMapper.map(entity, typeCarriage);
    typeCarriageRepository.saveAndFlush(typeCarriage);
    entity = modelMapper.map(typeCarriage, new TypeToken<TypeCarriageDto>() {
    }.getType());
    return entity;
  }
}
