package dao;

import entity.train.Train;

public class TrainDAO extends AbstractDAODB<Train> {
    @Override
    protected Class getClazz() {
        return Train.class;
    }
}
