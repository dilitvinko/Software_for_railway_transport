package railwayTransport.software.daoJPA.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import railwayTransport.software.entity.TestEntity;

@Repository
public interface TestRepository extends JpaRepository<TestEntity, Long> {

}
