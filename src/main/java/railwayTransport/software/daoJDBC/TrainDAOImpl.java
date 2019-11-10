package railwayTransport.software.daoJDBC;

import railwayTransport.software.daoJDBC.interfaces.TrainDAO;
import railwayTransport.software.entity.train.Carriage;
import railwayTransport.software.entity.train.Train;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TrainDAOImpl extends AbstractDAODB<Train> implements TrainDAO {

  @Override
  protected Class getClazz() {
    return Train.class;
  }

  //TODO жесткий костыльный метод переписать в JPA

  @Override
  public List<Train> findAll() {
    List<Train> trains = super.findAll();
    CarriageDAOImpl carriageDAO = new CarriageDAOImpl();
    List<Carriage> carriages = carriageDAO.findAll();
    for (Train train :
        trains) {
      Set<Carriage> tmpCarriage = new HashSet<>();
      for (Carriage carriage :
          carriages) {
        if (carriage.getId_train() == train.getId()) {
          tmpCarriage.add(carriage);
        }
      }
      train.setCarriages(tmpCarriage);
    }
    return trains;
  }
}
