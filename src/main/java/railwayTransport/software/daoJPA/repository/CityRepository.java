package railwayTransport.software.daoJPA.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import railwayTransport.software.entity.schedule.City;


public interface CityRepository extends JpaRepository<City, Long> {

  City findFirstById(Long id);

  City findByName(String name);
}
