package service;

import dao.TypeCarriageDAOImpl;
import service.interfaces.TypeCarriageService;

public class TypeCarriageServiceImpl extends AbstractService implements TypeCarriageService {

    public TypeCarriageServiceImpl() {
        abstractDAODB = new TypeCarriageDAOImpl();
    }
}
