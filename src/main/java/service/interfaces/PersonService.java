package service.interfaces;

import entity.person.Person;

public interface PersonService {
//    person login (person person);
//    boolean logout (person person);
    boolean registration (Person person);
    Person changeRole (Person person);
    Person changePassword (String pass);
}
