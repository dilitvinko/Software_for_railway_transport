package railwayTransport.software.daoJPA.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import railwayTransport.software.entity.train.TypeCarriage;


public interface TypeCarriageRepository extends JpaRepository<TypeCarriage, Long> {

}
