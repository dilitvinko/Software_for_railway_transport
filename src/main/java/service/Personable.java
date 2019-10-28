package service;

import entity.person.Person;

public interface Personable {
//    person login (person person);
//    boolean logout (person person);
    boolean registration (Person person);
    Person changeRole (Person person);
    Person changePassword (String pass);
}
