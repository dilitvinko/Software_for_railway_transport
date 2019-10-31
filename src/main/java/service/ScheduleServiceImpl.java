package service;

import dao.ScheduleDAOImpl;
import service.interfaces.ScheduleService;

public class ScheduleServiceImpl extends AbstractService implements ScheduleService {

    public ScheduleServiceImpl() {
        abstractDAODB = new ScheduleDAOImpl();
    }
}
