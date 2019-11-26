package railwayTransport.software.daoJPA.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import railwayTransport.software.entity.person.Person;


public interface PersonRepository extends JpaRepository<Person, Long> {

  Person findFirstById(Long id);

  Person findUserByLogin(String s);
}
