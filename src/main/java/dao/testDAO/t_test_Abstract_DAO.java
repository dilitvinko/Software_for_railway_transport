package dao.testDAO;

import entity.person.Person;
import entity.ticket.CityTime;
import entity.ticket.Route;
import entity.train.Train;

public class t_test_Abstract_DAO extends AbstractDAODB<Route> {
    @Override
    protected Class getClazz() {
        return Route.class;
    }
}
