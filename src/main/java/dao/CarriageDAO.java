package dao;

import entity.BaseEntity;
import entity.train.Carriage;

import java.util.List;

public class CarriageDAO extends AbstractDAODB<Carriage> {
    @Override
    protected Class getClazz() {
        return Carriage.class;
    }

    @Override
    public Carriage findById(long id) {
        Carriage carriage = new Carriage();
        carriage = super.findById(id);
        TypeCarriageDAO typeCarriageDAO = new TypeCarriageDAO();
        TrainDAO trainDAO = new TrainDAO();
        carriage.setTypeCarriage(typeCarriageDAO.findById(carriage.getId_typeCarriage()));
        carriage.setTrain(trainDAO.findById(carriage.getId_train()));
        return carriage;
    }

    @Override
    public List<Carriage> findAll() {
        TrainDAO trainDAO = new TrainDAO();
        TypeCarriageDAO typeCarriageDAO = new TypeCarriageDAO();
        List<Carriage> carriages = super.findAll();
        for (Carriage carriage :
                carriages) {
            carriage.setTrain(trainDAO.findById(carriage.getId_train()));
            carriage.setTypeCarriage(typeCarriageDAO.findById(carriage.getId_typeCarriage()));
        }
        return carriages;
    }


//TODO same methods findById() findAll from CarriageDao

}
