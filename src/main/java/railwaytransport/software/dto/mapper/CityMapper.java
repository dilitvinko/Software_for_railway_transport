package railwaytransport.software.dto.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import railwaytransport.software.dto.CityDto;
import railwaytransport.software.entity.schedule.City;

@Mapper
public interface CityMapper {

  CityDto cityToCityDto(City entity);

  City cityDtoToCity(CityDto dto);

  List<CityDto> listCityToListCityDto(List<City> entities);

  List<City> listCityDtoToListCity(List<CityDto> dtos);


}
