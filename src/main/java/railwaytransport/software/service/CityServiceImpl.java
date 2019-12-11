package railwaytransport.software.service;


import java.util.List;
import javax.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import railwaytransport.software.daojpa.repository.CityRepository;
import railwaytransport.software.dto.CityDto;
import railwaytransport.software.dto.mapper.CityMapper;
import railwaytransport.software.entity.schedule.City;
import railwaytransport.software.service.interfaces.CityService;

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
    return mapper.cityToCityDto(cityRepository.getOne(id));
  }

  @Override
  public void deleteById(long id) {
    cityRepository.deleteById(id);
  }


  @Override
  public void delete(CityDto dto) {
    City city = mapper.cityDtoToCity(dto);
    cityRepository.delete(city);
  }

  @Override
  public CityDto create(CityDto dto) {
    dto.setId(null);
    City city = mapper.cityDtoToCity(dto);
    cityRepository.saveAndFlush(city);
    dto = mapper.cityToCityDto(city);
    return dto;
  }

  @Override
  public CityDto update(CityDto dto) {
    City city = mapper.cityDtoToCity(dto);
    if (null == cityRepository.getOne(city.getId())) {
      throw new EntityNotFoundException();
    }
    cityRepository.saveAndFlush(city);
    dto = mapper.cityToCityDto(city);
    return dto;
  }

  @Override
  public CityDto findByName(String nameCity) {
    return mapper.cityToCityDto(cityRepository.findByName(nameCity));
  }
}
