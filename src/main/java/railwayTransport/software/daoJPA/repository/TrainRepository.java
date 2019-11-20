package railwayTransport.software.daoJPA.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import railwayTransport.software.entity.train.Train;


public interface TrainRepository extends JpaRepository<Train, Long> {

  Train findFirstById(Long id);

}
