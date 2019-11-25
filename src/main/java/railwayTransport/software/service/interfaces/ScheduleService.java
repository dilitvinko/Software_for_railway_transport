package railwayTransport.software.service.interfaces;

import railwayTransport.software.dto.ScheduleDto;

public interface ScheduleService extends Service<ScheduleDto> {

  ScheduleDto findScheduleByTrainIdAndCityId(long trainId, long cityId);

}
