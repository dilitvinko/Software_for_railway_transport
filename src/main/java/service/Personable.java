package service;

import entity.Person.Person;

public interface Personable {
    Person login (Person person);
    boolean logout (Person person);
    boolean registration (Person person);
    Person changeRole (Person person);
    Person changePassword (String pass);
}
