package dao;

import java.sql.*;

public class DAOForTesting {
    private static final String url = "jdbc:mysql://localhost:3306/software_for_railway_transport?serverTimezone=UTC";
    private static final String user = "alyona";
    private static final String password = "alyona";
    public static final String SELECT_FROM_TEST_ENTITY = "SELECT * FROM person";
    public static final String SELECT_FROM_CITY_TIME = "SELECT * FROM city_time";
    private final static String SQL_INSERT ="INSERT INTO city_time(city, timeDate,id_route) VALUES(?,?,1)";

    public String testDAO() {
        StringBuilder result = new StringBuilder();
        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SELECT_FROM_TEST_ENTITY)
        ) {

            while (resultSet.next()) {
                result.append(resultSet.getString(2));
                System.out.println(resultSet.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result.toString();
    }

    public void testDate() {
        java.sql.Timestamp dt;

        java.text.SimpleDateFormat sdf =
                new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SELECT_FROM_CITY_TIME)
        ) {
            while (resultSet.next()){
                dt = resultSet.getTimestamp(3);
                System.out.println(sdf.format(dt));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        dt = Timestamp.valueOf("2019-07-07 15:15:00");
        PreparedStatement ps = null;
        try (Connection connection = DriverManager.getConnection(url, user, password)){
            ps = connection.prepareStatement(SQL_INSERT);

                ps.setString(1, "Minsk");
                ps.setTimestamp(2, dt);
                ps.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

}
