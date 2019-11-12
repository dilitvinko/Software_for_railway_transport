package railwayTransport.software.daoJPA.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import railwayTransport.software.entity.person.Person;
import railwayTransport.software.entity.train.Train;


public interface PersonRepository  extends JpaRepository<Person, Long> {
  Person findFirstById(Long id);
}
