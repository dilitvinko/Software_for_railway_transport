package railwayTransport.software.service.interfaces;

import java.util.List;
import railwayTransport.software.dto.AbstractDto;

public interface Service<T extends AbstractDto> {

  List<T> findAll();

  T findById(long id);

  void deleteById(long id);

  void delete(T dto);

  T create(T dto);

  T update(T dto);
}
