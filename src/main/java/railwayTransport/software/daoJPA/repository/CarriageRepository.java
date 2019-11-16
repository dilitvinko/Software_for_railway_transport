package railwayTransport.software.daoJPA.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import railwayTransport.software.entity.train.Carriage;

public interface CarriageRepository  extends JpaRepository<Carriage, Long> {

  Carriage findFirstById(Long id);
}
