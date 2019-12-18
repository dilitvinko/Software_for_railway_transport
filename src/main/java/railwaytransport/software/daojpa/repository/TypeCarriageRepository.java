package railwaytransport.software.daojpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import railwaytransport.software.entity.train.TypeCarriage;


public interface TypeCarriageRepository extends JpaRepository<TypeCarriage, Long> {

}
