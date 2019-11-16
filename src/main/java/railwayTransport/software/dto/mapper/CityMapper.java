package railwayTransport.software.dto.mapper;

import org.mapstruct.Mapper;
import railwayTransport.software.dto.CityDto;
import railwayTransport.software.entity.schedule.City;

@Mapper
public interface CityMapper {

  CityDto cityToCityDto(City entity);


  City cityDtoToCity(CityDto dto);

}
