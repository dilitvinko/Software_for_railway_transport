package railwayTransport.software.service;

import railwayTransport.software.daoJDBC.TypeCarriageDAOImpl;
import railwayTransport.software.service.interfaces.TypeCarriageService;

public class TypeCarriageServiceImpl extends AbstractService implements TypeCarriageService {

  public TypeCarriageServiceImpl() {
    abstractDAODB = new TypeCarriageDAOImpl();
  }
}
