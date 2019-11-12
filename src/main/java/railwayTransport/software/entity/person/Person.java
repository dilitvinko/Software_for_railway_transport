package railwayTransport.software.entity.person;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import railwayTransport.software.entity.BaseEntity;
import railwayTransport.software.entity.ticket.Ticket;
import java.util.Objects;
import java.util.Set;

@Entity
public class Person extends BaseEntity {

  private String name;
  private String surname;
  private String login;
  private String password;
  @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
  @CollectionTable(name = "person_role", joinColumns = @JoinColumn(name = "person_id"))
  @Enumerated(EnumType.STRING)
  private Set<Role> roles;
  @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  private Set<Ticket> tickets;
  private int experience;

  public Person() {
  }

  public Person(String name, String surname, String login, String password,
      Set<Role> roles, int experience) {
    this.name = name;
    this.surname = surname;
    this.login = login;
    this.password = password;
    this.roles = roles;
    this.experience = experience;
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
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Person person = (Person) o;

    if (this.getId() != person.getId()) {
      return false;
    }
    if (experience != person.experience) {
      return false;
    }
    if (!Objects.equals(name, person.name)) {
      return false;
    }
    if (!Objects.equals(surname, person.surname)) {
      return false;
    }
    if (!Objects.equals(login, person.login)) {
      return false;
    }
    return Objects.equals(password, person.password);
  }

  @Override
  public int hashCode() {
    int result = (int) (this.getId() ^ (this.getId() >>> 32));
    result = 31 * result + (name != null ? name.hashCode() : 0);
    result = 31 * result + (surname != null ? surname.hashCode() : 0);
    result = 31 * result + (login != null ? login.hashCode() : 0);
    result = 31 * result + (password != null ? password.hashCode() : 0);
    result = 31 * result + experience;
    return result;
  }

  @Override
  public String toString() {
    return "person{" +
        "id=" + getId() +
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
