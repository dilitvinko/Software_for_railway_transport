package dao;

import dao.interfaces.TypeCarriageDAO;
import entity.train.TypeCarriage;

public class TypeCarriageDAOImpl extends AbstractDAODB<TypeCarriage> implements TypeCarriageDAO {

  @Override
  protected Class getClazz() {
    return TypeCarriage.class;
  }
}
