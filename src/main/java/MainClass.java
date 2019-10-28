import entity.BaseEntity;
import entity.person.Person;

public class MainClass {

    public static void main(String[] args) {


        Person person = new Person();
        Class<? extends BaseEntity> personClass = person.getClass();
        System.out.println(personClass.getSimpleName());

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

//        PersonDAO personDAO = new PersonDAO();
//        System.out.println("Все пользователи: ");
//        for (person person: personDAO.findAll()
//             ) {
//            System.out.println(person);
//        }
//        TestClass_1DAO testClass_1DAO = new TestClass_1DAO();
//        System.out.println("test class_1");
//        for (TestClass_1 testClass_1:
//             testClass_1DAO.findAll()) {
//            System.out.println(testClass_1);
//        }



//        PersonDAO personDAO = new PersonDAO();
//        person person = personDAO.findById(1);
//        System.out.println(person);
//        System.out.println("");
//        System.out.println(personDAO.deleteById(5));
//        personDAO.findAll();
//        Set<Role> roles = new HashSet<>();
//        roles.add(Role.USER);
//        roles.add(Role.ADMIN);
//        person person_1 = new person("Vikka", "zxc", "qwe", "1234", roles, 0);
//        System.out.println(personDAO.create(person_1));
//        person.setName("AAAAAAAAA");
//        person.setLogin("BBBBBBBBBB");
//        personDAO.update(person);
//        System.out.println();
    }
}
