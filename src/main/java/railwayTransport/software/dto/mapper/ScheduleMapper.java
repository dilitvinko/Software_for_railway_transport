package railwayTransport.software.dto.mapper;

import org.mapstruct.Mapper;
import railwayTransport.software.dto.ScheduleDto;
import railwayTransport.software.entity.schedule.Schedule;

@Mapper
public interface ScheduleMapper {
  ScheduleDto scheduleToScheduleDto(Schedule entity);


  Schedule scheduleDtoToCarriage(ScheduleDto dto);

}
