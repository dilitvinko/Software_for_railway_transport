package railwayTransport.software.dto.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import railwayTransport.software.dto.ScheduleDto;
import railwayTransport.software.entity.schedule.Schedule;

@Mapper
public interface ScheduleMapper {

  ScheduleDto scheduleToScheduleDto(Schedule entity);

  Schedule scheduleDtoToSchedule(ScheduleDto dto);

  List<ScheduleDto> listScheduleToListScheduleDto(List<Schedule> entities);

  List<Schedule> listScheduleDtoToListSchedule(List<ScheduleDto> dtos);

}
