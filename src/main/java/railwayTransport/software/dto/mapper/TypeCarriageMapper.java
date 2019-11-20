package railwayTransport.software.dto.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import railwayTransport.software.dto.TypeCarriageDto;
import railwayTransport.software.entity.train.TypeCarriage;

@Mapper
public interface TypeCarriageMapper {

  TypeCarriageDto typeCcarriageToTypeCarriageDto(TypeCarriage entity);

  TypeCarriage typeCarriageDtoToTypeCarriage(TypeCarriageDto dto);

  List<TypeCarriageDto> listTypeCarriageToListTypeCarriageDto(List<TypeCarriage> entities);

  List<TypeCarriage> listTypeCarriageDtoToListTypeCarriage(List<TypeCarriageDto> dtos);

}
