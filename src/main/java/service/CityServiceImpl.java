package service;

import dao.CityDAOImpl;
import service.interfaces.CityService;

public class CityServiceImpl extends AbstractService implements CityService {

  public CityServiceImpl() {
    abstractDAODB = new CityDAOImpl();
  }
}
