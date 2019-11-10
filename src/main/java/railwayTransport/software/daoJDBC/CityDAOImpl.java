package railwayTransport.software.daoJDBC;

import railwayTransport.software.daoJDBC.interfaces.CityDAO;
import railwayTransport.software.entity.schedule.City;

public class CityDAOImpl extends AbstractDAODB<City> implements CityDAO {

  @Override
  protected Class getClazz() {
    return City.class;
  }
}
