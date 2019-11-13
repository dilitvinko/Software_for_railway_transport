package railwayTransport.software.service.test;

import org.springframework.beans.factory.annotation.Autowired;
import railwayTransport.software.daoJPA.test.CommonRepository;
import railwayTransport.software.entity.BaseEntity;


public abstract class AbstractService<E extends BaseEntity, R extends CommonRepository<E>>
    implements CommonService<E> {

  protected final R repository;

  @Autowired
  public AbstractService(R rep) {
    this.repository = rep;
  }



  //другие методы, переопределённые из интерфейса
}
