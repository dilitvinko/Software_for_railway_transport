package railwaytransport.software.daojpa.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import railwaytransport.software.entity.schedule.Schedule;


public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

  Schedule findFirstById(Long id);

  List<Schedule> findSchedulesByCityIdOrCityId(long id1, long id2);

  Schedule findScheduleByTrainIdAndCityId(long trainId, long cityId);
}
