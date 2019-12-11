package railwaytransport.software.daojpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import railwaytransport.software.entity.train.Carriage;

public interface CarriageRepository extends JpaRepository<Carriage, Long> {

  Carriage findFirstById(Long id);
}
