package dao;

import entity.schedule.Schedule;

public class ScheduleDAO extends AbstractDAODB<Schedule> {
    @Override
    protected Class getClazz() {
        return Schedule.class;
    }
    //TODO same methods findById() findAll from CarriageDao
}
