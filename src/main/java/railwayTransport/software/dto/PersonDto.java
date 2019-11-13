package railwayTransport.software.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.Set;
import railwayTransport.software.entity.person.Role;

public class PersonDto extends  AbstractDto{

  private String name;
  private String surname;
  private String login;
  private String password;
  private Set<Role> roles;
  @JsonManagedReference(value = "person-ticket")
  private Set<TicketDto> tickets;
  private int experience;

  public PersonDto() {
  }

  public PersonDto(String name, String surname, String login, String password,
      Set<Role> roles, Set<TicketDto> tickets, int experience) {
    this.name = name;
    this.surname = surname;
    this.login = login;
    this.password = password;
    this.roles = roles;
    this.tickets = tickets;
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

  public Set<TicketDto> getTickets() {
    return tickets;
  }

  public void setTickets(Set<TicketDto> tickets) {
    this.tickets = tickets;
  }

  public int getExperience() {
    return experience;
  }

  public void setExperience(int experience) {
    this.experience = experience;
  }
}
