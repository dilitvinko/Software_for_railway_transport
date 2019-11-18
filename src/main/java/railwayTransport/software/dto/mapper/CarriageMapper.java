package railwayTransport.software.dto.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import railwayTransport.software.dto.CarriageDto;
import railwayTransport.software.entity.train.Carriage;

@Mapper
public interface CarriageMapper {

  @Mappings({
      @Mapping(target="trainId", source="entity.train.id")

  })
  CarriageDto carriageToCarriageDto(Carriage entity);
  @Mappings({
      @Mapping(target="train.id", source="dto.trainId")

  })
  Carriage carriageDtoToCarriage(CarriageDto dto);

  List<CarriageDto> listCarriageToListCarriageDto(List<Carriage> entities);
  List<Carriage> listCarriageDtoToListCarriage(List<CarriageDto> dtos);

}
