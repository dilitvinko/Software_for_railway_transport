package railwayTransport.software.daoJPA.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import railwayTransport.software.entity.train.Train;

import java.util.Optional;


public interface TrainRepository  extends JpaRepository<Train, Long> {

    Train findFirstById(Long id);

}
