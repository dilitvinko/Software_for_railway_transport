package dao;

import dao.interfece.CityDAO;
import entity.schedule.City;

public class CityDAOImpl extends AbstractDAODB<City> implements CityDAO {
    @Override
    protected Class getClazz() {
        return City.class;
    }
}
