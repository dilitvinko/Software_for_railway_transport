package railwaytransport.software.dto.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import railwaytransport.software.dto.TrainDto;
import railwaytransport.software.entity.train.Train;

@Mapper
public interface TrainMapper {


  TrainDto trainToTrainDto(Train entity);

  Train trainDtoToTrain(TrainDto dto);

  List<TrainDto> listTrainToListTrainDto(List<Train> entities);

  List<Train> listTrainDtoToListTrain(List<TrainDto> dtos);


}
