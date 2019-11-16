package railwayTransport.software.dto.mapper;

import org.mapstruct.Mapper;
import railwayTransport.software.dto.TypeCarriageDto;
import railwayTransport.software.entity.train.TypeCarriage;

@Mapper
public interface TypeCarriageMapper {

  TypeCarriageDto typeCcarriageToTypeCarriageDto(TypeCarriage entity);


  TypeCarriage typeCarriageDtoToTypeCarriage(TypeCarriageDto dto);

}
