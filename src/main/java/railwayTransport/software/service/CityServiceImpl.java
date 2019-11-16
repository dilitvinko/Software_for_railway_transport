package railwayTransport.software.service;


import java.util.List;
import org.mapstruct.factory.Mappers;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;
import railwayTransport.software.daoJPA.repository.CityRepository;
import railwayTransport.software.dto.CityDto;
import railwayTransport.software.dto.mapper.CityMapper;
import railwayTransport.software.entity.schedule.City;
import railwayTransport.software.service.interfaces.CityService;

@Service
public class CityServiceImpl implements CityService {

  private final CityRepository cityRepository;
  private final ModelMapper modelMapper;
  private CityMapper mapper
      = Mappers.getMapper(CityMapper.class);

  public CityServiceImpl(CityRepository cityRepository, ModelMapper modelMapper) {
    this.cityRepository = cityRepository;
    this.modelMapper = modelMapper;
  }


  @Override
  public List<CityDto> findAll() {
    List<City> cities = cityRepository.findAll();
    return modelMapper.map(cities, new TypeToken<List<CityDto>>() {
    }.getType());
  }

  @Override
  public CityDto findById(long id) {
//    return modelMapper.map(cityRepository.getOne(id), new TypeToken<CityDto>() {
//    }.getType());
    return mapper.cityToCityDto(cityRepository.getOne(id));
  }

  @Override
  public boolean deleteById(long id) {
    boolean flag = false;
    try{
      cityRepository.deleteById(id);
      flag = true;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return flag;
  }

  @Override
  public boolean delete(CityDto entity) {
    boolean flag = false;
    City city = modelMapper.map(entity, new TypeToken<CityDto>() {
    }.getType());
    try{
      cityRepository.delete(city);
      flag = true;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return flag;
  }

  @Override
  public CityDto create(CityDto entity) {
    City city = new City();
    modelMapper.map(entity, city);
    cityRepository.saveAndFlush(city);
    entity = modelMapper.map(city, new TypeToken<CityDto>() {
    }.getType());
    return entity;
  }

  @Override
  public CityDto update(CityDto entity) {
    City city = new City();
    modelMapper.map(entity, city);
    cityRepository.saveAndFlush(city);
    entity = modelMapper.map(city, new TypeToken<CityDto>() {
    }.getType());
    return entity;
  }
}
