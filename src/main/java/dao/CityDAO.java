package dao;

import entity.schedule.City;

public class CityDAO extends AbstractDAODB<City> {
    @Override
    protected Class getClazz() {
        return City.class;
    }
}
