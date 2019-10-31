package service;

import dao.AbstractDAODB;
import dao.CarriageDAOImpl;
import service.interfaces.CarriageService;

public class CarriageServiceImpl extends AbstractService implements CarriageService {

    public CarriageServiceImpl() {
        abstractDAODB = new CarriageDAOImpl();
    }
}
