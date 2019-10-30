package dao.testDAO;

import dao.AbstractDAODB;
import entity.train.Train;

public class t_test_Abstract_DAO extends AbstractDAODB<Train> {
    @Override
    protected Class getClazz() {
        return Train.class;
    }
}
