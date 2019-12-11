package railwaytransport.software.daojpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import railwaytransport.software.entity.train.Train;


public interface TrainRepository extends JpaRepository<Train, Long> {

  Train findFirstById(Long id);

}
