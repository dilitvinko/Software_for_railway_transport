//package railwayTransport.software.service;
//
//import railwayTransport.software.daoJDBC.AbstractDAODB;
//import railwayTransport.software.entity.BaseEntity;
//import java.util.List;
//import railwayTransport.software.service.interfaces.Service;
//
//public abstract class AbstractService<T extends BaseEntity> implements Service {
//
//  AbstractDAODB<T> abstractDAODB;
//
//  @Override
//  public List<T> findAll() {
//    return abstractDAODB.findAll();
//  }
//
//  @Override
//  public T findById(long id) {
//    return abstractDAODB.findById(id);
//  }
//
//  @Override
//  public boolean deleteById(long id) {
//    return abstractDAODB.deleteById(id);
//  }
//
//  @Override
//  public boolean delete(BaseEntity entity) {
//    return abstractDAODB.delete(entity);
//  }
//
//  @Override
//  public T create(BaseEntity entity) {
//    return abstractDAODB.create(entity);
//  }
//
//  @Override
//  public T update(BaseEntity entity) {
//    return abstractDAODB.update(entity);
//  }
//}
