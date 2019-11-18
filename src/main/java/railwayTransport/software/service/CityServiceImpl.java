package railwayTransport.software.service;


import java.util.List;
import org.springframework.stereotype.Service;
import railwayTransport.software.daoJPA.repository.CityRepository;
import railwayTransport.software.dto.CityDto;
import railwayTransport.software.dto.mapper.CityMapper;
import railwayTransport.software.entity.schedule.City;
import railwayTransport.software.service.interfaces.CityService;

@Service
public class CityServiceImpl implements CityService {

  private final CityRepository cityRepository;
  private final CityMapper mapper;

  public CityServiceImpl(CityRepository cityRepository, CityMapper mapper) {
    this.cityRepository = cityRepository;
    this.mapper = mapper;
  }


  @Override
  public List<CityDto> findAll() {
    return mapper.listCityToListCityDto(cityRepository.findAll());
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
  public boolean delete(CityDto dto) {
    boolean flag = false;
    City city = mapper.cityDtoToCity(dto);
    try{
      cityRepository.delete(city);
      flag = true;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return flag;
  }

  @Override
  public CityDto create(CityDto dto) {
    City city = mapper.cityDtoToCity(dto);
    cityRepository.saveAndFlush(city);
    dto = mapper.cityToCityDto(city);
    return dto;
  }

  @Override
  public CityDto update(CityDto dto) {
    City city = mapper.cityDtoToCity(dto);
    cityRepository.saveAndFlush(city);
    dto = mapper.cityToCityDto(city);
    return dto;
  }
}
