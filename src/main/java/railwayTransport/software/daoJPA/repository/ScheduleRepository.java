package railwayTransport.software.daoJPA.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import railwayTransport.software.entity.schedule.Schedule;


public interface ScheduleRepository  extends JpaRepository<Schedule, Long> {

}
