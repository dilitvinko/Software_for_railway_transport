package dao;

import dao.interfaces.TrainDAO;
import entity.train.Train;

public class TrainDAOImpl extends AbstractDAODB<Train> implements TrainDAO {
    @Override
    protected Class getClazz() {
        return Train.class;
    }
}
