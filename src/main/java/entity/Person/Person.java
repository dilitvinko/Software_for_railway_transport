package entity.Person;

import entity.Ticket;

import java.util.Objects;
import java.util.Set;

public class Person {
    private long id;
    private String name;
    private String surname;
    private String login;
    private String password;
    private Set<Role> roles;
    private Set<Ticket> tickets;
    private int experience;

    public Person() {
    }

    public Person(long id, String name, String surname, String login, String password, Set<Role> roles, Set<Ticket> tickets, int experience) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.password = password;
        this.roles = roles;
        this.tickets = tickets;
        this.experience = experience;
    }

    public Person(String name, String surname, String login, String password, Set<Role> roles, int experience) {
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.password = password;
        this.roles = roles;
        this.experience = experience;
    }

    public Person(long id, String name, String surname, String login, String password, int experience) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.password = password;
        this.roles = roles;
        this.experience = experience;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Set<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(Set<Ticket> tickets) {
        this.tickets = tickets;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (id != person.id) return false;
        if (experience != person.experience) return false;
        if (!Objects.equals(name, person.name)) return false;
        if (!Objects.equals(surname, person.surname)) return false;
        if (!Objects.equals(login, person.login)) return false;
        return Objects.equals(password, person.password);
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + experience;
        return result;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", roles=" + roles +
                ", tickets=" + tickets +
                ", experience=" + experience +
                '}';
    }
}
