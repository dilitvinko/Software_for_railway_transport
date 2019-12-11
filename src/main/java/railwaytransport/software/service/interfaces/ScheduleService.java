package railwaytransport.software.service.interfaces;

import railwaytransport.software.dto.ScheduleDto;

public interface ScheduleService extends Service<ScheduleDto> {

  ScheduleDto findScheduleByTrainIdAndCityId(long trainId, long cityId);

}
