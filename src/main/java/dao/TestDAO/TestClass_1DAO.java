package dao.TestDAO;

import dao.CrudDAO;
import entity.Person.Person;
import entity.Person.Role;
import entity.TestFeauture.TestClass_1;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TestClass_1DAO implements CrudDAO<TestClass_1> {
    private static final String url = "jdbc:mysql://localhost:3306/software_for_railway_transport";
    private static final String user = "root";
    private static final String password = "root";
    public static final String SQL_SELECT_ALL_PERSON = "SELECT * FROM person\n" +
            "JOIN person_role ON person.id = person_role.id_person;";
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
    public static final String SQL_SELECT_ALL_TESTCLASS_1 = "SELECT * FROM test_class_1;";


    @Override
    public List<TestClass_1> findAll() {
        List<TestClass_1> users = new ArrayList<>();
        Set<Role> roles = new HashSet<>();
        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL_TESTCLASS_1)
        ) {
            while (resultSet.next()) {


                TestClass_1 testClass_1 = new TestClass_1();
                testClass_1.setId(resultSet.getLong(1));
                testClass_1.setName(resultSet.getString(2));
                testClass_1.setAge(resultSet.getInt(3));

//                if (users.contains(testClass_1)) {
//                    roles.add(Role.valueOf(resultSet.getString(8).toUpperCase()));
//                    testClass_1.setRoles(roles);
//                } else {
//                    users.add(testClass_1);
//                    roles = new HashSet<>();
//                    roles.add(Role.valueOf(resultSet.getString(8).toUpperCase()));
//                    testClass_1.setRoles(roles);
//                }
                users.add(testClass_1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

    @Override
    public TestClass_1 findById(long id) {
        return null;
    }

    @Override
    public boolean deleteById(long id) {
        return false;
    }

    @Override
    public boolean delete(TestClass_1 entity) {
        return false;
    }

    @Override
    public TestClass_1 create(TestClass_1 entity) {
        return null;
    }

    @Override
    public TestClass_1 update(TestClass_1 entity) {
        return null;
    }

//    @Override
//    public TestClass_1 findById(long id) {
//        Set<Role> roles = new HashSet<>();
//        Person person = null;
//        try (Connection connection = DriverManager.getConnection(url, user, password);
//             PreparedStatement statement = connection.prepareStatement(SQL_SELECT_USER_BY_ID)
//        ) {
//            statement.setLong(1, id);
//            try (ResultSet resultSet = statement.executeQuery()) {
//                while (resultSet.next()) {
////АДЕКВАТНО РЕАЛИЗОВАНО? (ДОБАВДЯТЬ ЛИ ТИКЕТЫ?)
//                    person = new Person(resultSet.getLong(1),
//                            resultSet.getString(2),
//                            resultSet.getString(3),
//                            resultSet.getString(4),
//                            resultSet.getString(5),
//                            resultSet.getInt(6));
//
//                    roles.add(Role.valueOf(resultSet.getString(8).toUpperCase()));
//                    person.setRoles(roles);
//
//                }
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    @Override
//    public boolean deleteById(long id) {
//        boolean flag = false;
//
//        try(Connection connection = DriverManager.getConnection(url, user, password);
//            PreparedStatement statement = connection.prepareStatement(SQL_DELETE_BY_ID)
//        ) {
//            statement.setLong(1, id);
//            statement.executeUpdate();
//            flag = true;
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return flag;
//    }
//
//    @Override
//    public boolean delete(TestClass_1 entity) {
//        long id = entity.getId();
//        return deleteById(id);
//    }
//
//    @Override
//    public TestClass_1 create(TestClass_1 entity) {
//        boolean flag = false;
//// НЕ ГОВНОКОД ЛИ ЧАСОМ С ROLE??
//        try (Connection connection = DriverManager.getConnection(url, user, password);
//
//        ) {
//            try (PreparedStatement statement = connection.prepareStatement(SQL_CREATE_PERSON, Statement.RETURN_GENERATED_KEYS)
//            ){
//                statement.setString(1, entity.getName());
////                statement.setString(2, entity.getSurname());
////                statement.setString(3, entity.getLogin());
////                statement.setString(4, entity.getPassword());
////                statement.setInt(5, entity.getExperience());
//                int affectedRows = statement.executeUpdate();
//
//                if (affectedRows == 0) {
//                    throw new SQLException("Creating user failed, no rows affected.");
//                }
//
//                try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
//                    if (generatedKeys.next()) {
//                        entity.setId(generatedKeys.getLong(1));
//                    } else {
//                        throw new SQLException("Creating user failed, no ID obtained.");
//                    }
//                }
//            }
//            try (PreparedStatement statement = connection.prepareStatement(SQL_CREATE_PERSON_ROLE)
//            ) {
////                for (Role role : entity.getRoles() ) {
////                    statement.setLong(1, entity.getId());
////                    statement.setString(2, role.toString());
////                    statement.executeUpdate();
////                }
//            }
//
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return entity;
//    }
//
//    @Override
//    public TestClass_1 update(TestClass_1 entity) {
//        try(Connection connection = DriverManager.getConnection(url, user, password);
//            PreparedStatement statement = connection.prepareStatement(SQL_UPDATE_PERSON)
//        ) {
//            statement.setString(1, entity.getName());
////            statement.setString(2, entity.getSurname());
////            statement.setString(3, entity.getLogin());
////            statement.setString(4, entity.getPassword());
////            statement.setInt(5, entity.getExperience());
//            statement.setLong(6,entity.getId());
//            statement.executeUpdate();
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return entity;
//    }
}
