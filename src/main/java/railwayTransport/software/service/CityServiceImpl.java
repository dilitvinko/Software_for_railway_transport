package railwayTransport.software.service;


import java.util.List;
import org.modelmapper.ModelMapper;
import railwayTransport.software.daoJPA.repository.CityRepository;
import railwayTransport.software.dto.CityDto;
import railwayTransport.software.service.interfaces.CityService;

public class CityServiceImpl implements CityService {

  private final CityRepository cityRepository;
  private final ModelMapper modelMapper;

  public CityServiceImpl(CityRepository cityRepository, ModelMapper modelMapper) {
    this.cityRepository = cityRepository;
    this.modelMapper = modelMapper;
  }


  @Override
  public List<CityDto> findAll() {
    return null;
  }

  @Override
  public CityDto findById(long id) {
    return null;
  }

  @Override
  public boolean deleteById(long id) {
    return false;
  }

  @Override
  public boolean delete(CityDto entity) {
    return false;
  }

  @Override
  public CityDto create(CityDto entity) {
    return null;
  }

  @Override
  public CityDto update(CityDto entity) {
    return null;
  }
}
