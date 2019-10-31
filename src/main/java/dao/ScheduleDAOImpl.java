package dao;

import dao.interfaces.ScheduleDAO;
import entity.schedule.Schedule;

import java.util.List;

public class ScheduleDAOImpl extends AbstractDAODB<Schedule> implements ScheduleDAO {
    @Override
    protected Class getClazz() {
        return Schedule.class;
    }
    //TODO same methods findById() findAll from CarriageDao

    @Override
    public List<Schedule> findAll() {
        TrainDAOImpl trainDAO = new TrainDAOImpl();
        CityDAOImpl cityDAO = new CityDAOImpl();
        List<Schedule> schedules = super.findAll();
        for (Schedule schedule :
                schedules) {
            schedule.setTrain(trainDAO.findById(schedule.getId_train()));
            schedule.setCity(cityDAO.findById(schedule.getId_city()));
        }
        return schedules;
    }

    @Override
    public Schedule findById(long id) {
        Schedule schedule = new Schedule();
        schedule = super.findById(id);
        CityDAOImpl cityDAO = new CityDAOImpl();
        TrainDAOImpl trainDAO = new TrainDAOImpl();
        schedule.setCity(cityDAO.findById(schedule.getId_city()));
        schedule.setTrain(trainDAO.findById(schedule.getId_train()));
        return schedule;
    }
}
