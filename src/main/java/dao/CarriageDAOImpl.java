package dao;

import dao.interfece.CarriageDAO;
import entity.train.Carriage;

import java.util.List;

public class CarriageDAOImpl extends AbstractDAODB<Carriage> implements CarriageDAO {
    @Override
    protected Class getClazz() {
        return Carriage.class;
    }

    @Override
    public Carriage findById(long id) {
        Carriage carriage = new Carriage();
        carriage = super.findById(id);
        TypeCarriageDAOImpl typeCarriageDAO = new TypeCarriageDAOImpl();
        TrainDAOImpl trainDAO = new TrainDAOImpl();
        carriage.setTypeCarriage(typeCarriageDAO.findById(carriage.getId_typeCarriage()));
        carriage.setTrain(trainDAO.findById(carriage.getId_train()));
        return carriage;
    }

    @Override
    public List<Carriage> findAll() {
        TrainDAOImpl trainDAO = new TrainDAOImpl();
        TypeCarriageDAOImpl typeCarriageDAO = new TypeCarriageDAOImpl();
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
