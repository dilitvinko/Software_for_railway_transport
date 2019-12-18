package railwaytransport.software.daojpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import railwaytransport.software.entity.schedule.City;


public interface CityRepository extends JpaRepository<City, Long> {

  City findByName(String name);
}
