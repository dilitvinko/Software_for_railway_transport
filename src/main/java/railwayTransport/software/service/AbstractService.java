//package railwayTransport.software.service;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import railwayTransport.software.entity.BaseEntity;
//import java.util.List;
//import railwayTransport.software.service.interfaces.Service;
//
//public abstract class AbstractService<T extends BaseEntity> implements Service {
//
//  JpaRepository<T, Long> jpaRepository;
//
//  public AbstractService(
//      JpaRepository<T, Long> jpaRepository) {
//    this.jpaRepository = jpaRepository;
//  }
//
//  public AbstractService() {
//
//  }
//
//  @Override
//  public List<T> findAll() {
//    return jpaRepository.findAll();
//  }
//
//  @Override
//  public T findById(long id) {
//    return jpaRepository.getOne(id);
//  }
//
//  @Override
//  public boolean deleteById(long id) {
//    boolean flag = false;
//    try{
//    jpaRepository.deleteById(id);
//      flag = true;
//    } catch (Exception e) {
//      e.printStackTrace();
//    }
//    return flag;
//  }
//
//  @Override
//  public boolean delete(BaseEntity entity) {
//    boolean flag = false;
//    try{
//      jpaRepository.delete((T) entity);
//      flag = true;
//    } catch (Exception e) {
//      e.printStackTrace();
//    }
//    return flag;
//  }
//
//  @Override
//  public T create(BaseEntity entity) {
//    return jpaRepository.saveAndFlush((T) entity);
//  }
//
//  @Override
//  public T update(BaseEntity entity) {
//    return jpaRepository.saveAndFlush((T) entity);
//  }
//}
