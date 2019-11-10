package railwayTransport.software.daoJDBC;

import railwayTransport.software.daoJDBC.interfaces.TypeCarriageDAO;
import railwayTransport.software.entity.train.TypeCarriage;

public class TypeCarriageDAOImpl extends AbstractDAODB<TypeCarriage> implements TypeCarriageDAO {

  @Override
  protected Class getClazz() {
    return TypeCarriage.class;
  }
}
