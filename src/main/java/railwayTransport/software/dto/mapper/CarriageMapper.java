package railwayTransport.software.dto.mapper;

import org.mapstruct.Mapper;
import railwayTransport.software.dto.CarriageDto;
import railwayTransport.software.entity.train.Carriage;

@Mapper
public interface CarriageMapper {

  CarriageDto carriageToCarriageDto(Carriage entity);


  Carriage carriageDtoToCarriage(CarriageDto dto);

}
