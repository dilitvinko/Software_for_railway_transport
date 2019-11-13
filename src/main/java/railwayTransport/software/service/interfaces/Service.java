package railwayTransport.software.service.interfaces;

import java.util.List;
import railwayTransport.software.dto.AbstractDto;

public interface Service<T extends AbstractDto> {

  List<T> findAll();

  T findById(long id);

  boolean deleteById(long id);

  boolean delete(T entity);

  T create(T entity);

  T update(T entity);
}
