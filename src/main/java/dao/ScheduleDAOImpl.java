package dao;


import com.ibm.icu.impl.Pair;
import dao.interfaces.ScheduleDAO;
import entity.schedule.City;
import entity.schedule.Schedule;



import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ScheduleDAOImpl extends AbstractDAODB<Schedule> implements ScheduleDAO {
    @Override
    protected Class getClazz() {
        return Schedule.class;
    }

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

    //TODO Костыльный метод будет переписан нормально через JPA
    public List<Pair<Schedule, Schedule>> findAllTrainAtDateByCities(Date date, String outCity, String inCity){
        List<Pair<Schedule, Schedule>> pairList = new ArrayList<>();
        CityDAOImpl cityDAO = new CityDAOImpl();
        List<City> cities = new ArrayList<>();
        cities = cityDAO.findAll();
        long id_outCity = 0;
        long id_inCity = 0;
        for (City city :
                cities) {
            if (city.getName().equals(outCity)){
                id_outCity = city.getId();
            }
            if (city.getName().equals(inCity)){
                id_inCity = city.getId();
            }
        }

        List<Schedule> schedules = new ArrayList<>();
        schedules = findAll();
        for (int i = 0; i < schedules.size(); i++) {
            for (int j = 0; j < schedules.size(); j++) {
                if (id_outCity == schedules.get(i).getCity().getId() &&
                        id_inCity == schedules.get(j).getCity().getId()&&
                        schedules.get(i).getTrain().getId() == schedules.get(j).getTrain().getId() &&
                        schedules.get(i).getOrder() < schedules.get(j).getOrder()
                ){
                    pairList.add(Pair.of(schedules.get(i), schedules.get(j)));
                }
            }
        }
        return pairList;

    }
}
