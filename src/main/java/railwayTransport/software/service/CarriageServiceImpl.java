package railwayTransport.software.service;

import railwayTransport.software.daoJDBC.CarriageDAOImpl;
import railwayTransport.software.service.interfaces.CarriageService;

public class CarriageServiceImpl extends AbstractService implements CarriageService {

  public CarriageServiceImpl() {
    abstractDAODB = new CarriageDAOImpl();
  }
}
