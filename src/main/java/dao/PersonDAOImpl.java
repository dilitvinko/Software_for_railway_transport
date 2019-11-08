package dao;

import dao.interfaces.CrudDAO;
import dao.interfaces.PersonDAO;
import entity.person.Person;
import entity.person.Role;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PersonDAOImpl extends AbstractDAODB<Person> implements PersonDAO {

  private static final String url = "jdbc:mysql://localhost:3306/software_for_railway_transport?serverTimezone=UTC";
  private static final String user = "root";
  private static final String password = "root";
  public static final String SQL_SELECT_ALL_PERSON = "SELECT * FROM person\n" +
      "LEFT JOIN person_role ON person.id = person_role.id_person;";
  public static final String SQL_SELECT_USER_BY_ID = "SELECT * FROM person\n" +
      "JOIN person_role ON person.id = person_role.id_person\n" +
      "WHERE id = ?;";
  public static final String SQL_DELETE_BY_ID = "DELETE FROM person\n" +
      "WHERE id = ?;";
  public static final String SQL_CREATE_PERSON = "Insert into person (name, surname, login, password, experience) values (?, ?, ?, ?, ?);";
  public static final String SQL_CREATE_PERSON_ROLE = "Insert into person_role (id_person, role) values (?, ?);";
  public static final String SQL_UPDATE_PERSON = "UPDATE person \n" +
      "SET name = ?, surname = ?, login = ?, password = ?, experience = ?\n" +
      "WHERE id = ?;";


  @Override
  protected Class getClazz() {
    return Person.class;
  }

  @Override
  public List<Person> findAll() {
    List<Person> users = new ArrayList<>();
    Set<Role> roles = new HashSet<>();
    try (Connection connection = DriverManager.getConnection(url, user, password);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL_PERSON)
    ) {
      while (resultSet.next()) {

        Person person = new Person();
        person.setId(resultSet.getLong(1));
        person.setName(resultSet.getString(2));
        person.setSurname(resultSet.getString(3));
        person.setLogin(resultSet.getString(4));
        person.setPassword(resultSet.getString(5));
        person.setExperience(resultSet.getInt(6));
        if (!users.contains(person)) {
          users.add(person);
          roles = new HashSet<>();
        }
        if (resultSet.getString(8) != null) {
          roles.add(Role.valueOf(resultSet.getString(8).toUpperCase()));
          person.setRoles(roles);
        }


      }


    } catch (SQLException e) {
      e.printStackTrace();
    }

    return users;
  }

  @Override
  public Person findById(long id) {
    Set<Role> roles = new HashSet<>();
    Person person = null;
    try (Connection connection = DriverManager.getConnection(url, user, password);
        PreparedStatement statement = connection.prepareStatement(SQL_SELECT_USER_BY_ID)
    ) {
      statement.setLong(1, id);
      try (ResultSet resultSet = statement.executeQuery()) {
        while (resultSet.next()) {
          person = new Person();
          person.setId(resultSet.getLong(1));
          person.setName(resultSet.getString(2));
          person.setSurname(resultSet.getString(3));
          person.setLogin(resultSet.getString(4));
          person.setPassword(resultSet.getString(5));
          person.setExperience(resultSet.getInt(6));

          roles.add(Role.valueOf(resultSet.getString(8).toUpperCase()));
          person.setRoles(roles);

        }
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return person;
  }

  @Override
  public boolean deleteById(long id) {
    boolean flag = false;

    try (Connection connection = DriverManager.getConnection(url, user, password);
        PreparedStatement statement = connection.prepareStatement(SQL_DELETE_BY_ID)
    ) {
      statement.setLong(1, id);
      statement.executeUpdate();
      flag = true;
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return flag;
  }

  //@Override
  public boolean delete(Person entity) {
    long id = entity.getId();
    return deleteById(id);
  }

  //@Override
  public Person create(Person entity) {
    boolean flag = false;
// НЕ ГОВНОКОД ЛИ ЧАСОМ С ROLE??
    try (Connection connection = DriverManager.getConnection(url, user, password);

    ) {
      try (PreparedStatement statement = connection
          .prepareStatement(SQL_CREATE_PERSON, Statement.RETURN_GENERATED_KEYS)
      ) {
        statement.setString(1, entity.getName());
        statement.setString(2, entity.getSurname());
        statement.setString(3, entity.getLogin());
        statement.setString(4, entity.getPassword());
        statement.setInt(5, entity.getExperience());
        int affectedRows = statement.executeUpdate();

        if (affectedRows == 0) {
          throw new SQLException("Creating user failed, no rows affected.");
        }

        try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
          if (generatedKeys.next()) {
            entity.setId(generatedKeys.getLong(1));
          } else {
            throw new SQLException("Creating user failed, no ID obtained.");
          }
        }
      }
      try (PreparedStatement statement = connection.prepareStatement(SQL_CREATE_PERSON_ROLE)
      ) {
        for (Role role : entity.getRoles()) {
          statement.setLong(1, entity.getId());
          statement.setString(2, role.toString());
          statement.executeUpdate();
        }
      }


    } catch (SQLException e) {
      e.printStackTrace();
    }
    return entity;
  }

  //@Override
  public Person update(Person entity) {
    try (Connection connection = DriverManager.getConnection(url, user, password);
        PreparedStatement statement = connection.prepareStatement(SQL_UPDATE_PERSON)
    ) {
      statement.setString(1, entity.getName());
      statement.setString(2, entity.getSurname());
      statement.setString(3, entity.getLogin());
      statement.setString(4, entity.getPassword());
      statement.setInt(5, entity.getExperience());
      statement.setLong(6, entity.getId());
      statement.executeUpdate();

    } catch (SQLException e) {
      e.printStackTrace();
    }
    return entity;
  }
}
