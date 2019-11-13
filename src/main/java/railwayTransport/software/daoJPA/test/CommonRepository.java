package railwayTransport.software.daoJPA.test;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import railwayTransport.software.entity.BaseEntity;

@NoRepositoryBean
public interface CommonRepository<E extends BaseEntity> extends JpaRepository<E, Long> {
}
