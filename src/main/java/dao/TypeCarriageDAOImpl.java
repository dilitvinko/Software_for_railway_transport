package dao;

import dao.interfece.TypeCarriageDAO;
import entity.train.TypeCarriage;

public class TypeCarriageDAOImpl extends AbstractDAODB<TypeCarriage> implements TypeCarriageDAO {
    @Override
    protected Class getClazz() {
        return TypeCarriage.class;
    }
}
