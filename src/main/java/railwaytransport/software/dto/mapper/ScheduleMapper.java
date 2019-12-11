package railwaytransport.software.dto.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import railwaytransport.software.dto.ScheduleDto;
import railwaytransport.software.entity.schedule.Schedule;

@Mapper
public interface ScheduleMapper {

  ScheduleDto scheduleToScheduleDto(Schedule entity);

  Schedule scheduleDtoToSchedule(ScheduleDto dto);

  List<ScheduleDto> listScheduleToListScheduleDto(List<Schedule> entities);

  List<Schedule> listScheduleDtoToListSchedule(List<ScheduleDto> dtos);

}
