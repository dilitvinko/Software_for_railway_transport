package dao;

import entity.train.TypeCarriage;

public class TypeCarriageDAO extends AbstractDAODB<TypeCarriage> {
    @Override
    protected Class getClazz() {
        return TypeCarriage.class;
    }
}
