package railwaytransport.software.dto.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import railwaytransport.software.dto.CarriageDto;
import railwaytransport.software.entity.train.Carriage;

@Mapper
public interface CarriageMapper {

  @Mappings({
      @Mapping(target = "idTrain", source = "entity.train.id")

  })
  CarriageDto carriageToCarriageDto(Carriage entity);

  @Mappings({
      @Mapping(target = "train.id", source = "dto.idTrain")

  })
  Carriage carriageDtoToCarriage(CarriageDto dto);

  List<CarriageDto> listCarriageToListCarriageDto(List<Carriage> entities);

  List<Carriage> listCarriageDtoToListCarriage(List<CarriageDto> dtos);

}
