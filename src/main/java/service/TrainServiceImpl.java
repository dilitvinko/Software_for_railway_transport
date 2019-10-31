package service;

import dao.TrainDAOImpl;
import service.interfaces.TrainService;

public class TrainServiceImpl extends AbstractService implements TrainService {

    public TrainServiceImpl() {
        abstractDAODB = new TrainDAOImpl();
    }
}
