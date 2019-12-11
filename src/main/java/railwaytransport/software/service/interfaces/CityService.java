package railwaytransport.software.service.interfaces;

import railwaytransport.software.dto.CityDto;

public interface CityService extends Service<CityDto> {

  CityDto findByName(String nameCity);

}
