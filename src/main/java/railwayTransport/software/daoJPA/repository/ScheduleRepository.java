package railwayTransport.software.daoJPA.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import railwayTransport.software.entity.schedule.Schedule;


public interface ScheduleRepository  extends JpaRepository<Schedule, Long> {

  Schedule findFirstById(Long id);

  //@Query("SELECT u FROM User u WHERE u.status = ?1 and u.name = ?2")
  List<Schedule> findSchedulesByCityIdOrCityId(long id1, long id2);
}
