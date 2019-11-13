package railwayTransport.software.service.test;

import java.util.List;
import org.springframework.stereotype.Service;
import railwayTransport.software.daoJPA.test.CarriageRepositoryTest;
import railwayTransport.software.entity.train.Carriage;

@Service
public class CarriageService extends AbstractService<Carriage, CarriageRepositoryTest> {

  public CarriageService(CarriageRepositoryTest repository) {
    super(repository);
  }

  public Carriage findById(Long id){
    Carriage one = repository.getOne(id);
    return one;
  }


}
