package railwayTransport.software.dto.mapper;

import org.mapstruct.Mapper;
import railwayTransport.software.dto.TrainDto;
import railwayTransport.software.entity.train.Train;

@Mapper
public interface TrainMapper {

  TrainDto trainToTrainDto(Train entity);


  Train trainDtoToTrain(TrainDto dto);


}
