package dao.testDAO;

import entity.person.Person;

public class t_test_Abstract_DAO extends AbstractDAODB<Person> {
    @Override
    protected Class getClazz() {
        return Person.class;
    }
}
