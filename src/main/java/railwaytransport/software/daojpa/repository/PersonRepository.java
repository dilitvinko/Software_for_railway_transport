package railwaytransport.software.daojpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import railwaytransport.software.entity.person.Person;


public interface PersonRepository extends JpaRepository<Person, Long> {

  Person findUserByLogin(String s);
}
