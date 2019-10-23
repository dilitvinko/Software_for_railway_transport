import controller.ControllerForTesting;
import dao.DAOForTesting;
import dao.PersonDAO;
import entity.Person.Person;
import entity.Person.Role;
import service.ServiceForTesting;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MainClass {

    public static void main(String[] args) {
        //ControllerForTesting controllerForTesting = new ControllerForTesting(new ServiceForTesting(new DAOForTesting()));
        //System.out.println(controllerForTesting.testControllerServiceDAO());
        //DAOForTesting daoForTesting = new DAOForTesting();
        //daoForTesting.testDate();

//        List<T> findAll();
//        T findById(long id);
//        boolean deleteById(long id);
//        boolean delete(T entity);
//        T create(T entity);
//        T update(T entity);

        PersonDAO personDAO = new PersonDAO();
        System.out.println("Все пользователи: ");
        for (Person person: personDAO.findAll()
             ) {
            System.out.println(person);
        }



//        PersonDAO personDAO = new PersonDAO();
//        Person person = personDAO.findById(1);
//        System.out.println(person);
//        System.out.println("");
//        System.out.println(personDAO.deleteById(5));
//        personDAO.findAll();
//        Set<Role> roles = new HashSet<>();
//        roles.add(Role.USER);
//        roles.add(Role.ADMIN);
//        Person person_1 = new Person("Vikka", "zxc", "qwe", "1234", roles, 0);
//        System.out.println(personDAO.create(person_1));
//        person.setName("AAAAAAAAA");
//        person.setLogin("BBBBBBBBBB");
//        personDAO.update(person);
//        System.out.println();
    }
}
