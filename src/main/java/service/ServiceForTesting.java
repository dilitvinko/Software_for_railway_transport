package service;

import dao.DAOForTesting;

public class ServiceForTesting {

  private final DAOForTesting daoForTesting;

  public ServiceForTesting(DAOForTesting daoForTesting) {
    this.daoForTesting = daoForTesting;
  }

  public String testServicePlusDAO() {
    return daoForTesting.testDAO();
  }
}
