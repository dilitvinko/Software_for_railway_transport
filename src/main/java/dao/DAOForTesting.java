package dao;

import java.sql.*;

public class DAOForTesting {
    private static final String url = "jdbc:mysql://localhost:3306/software_for_railway_transport";
    private static final String user = "root";
    private static final String password = "root";

    public String testDAO() {
        StringBuilder result = new StringBuilder();
        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM test_entity")
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

}
