package dao.testDAO;

import dao.CrudDAO;
import dao.testDAO.Reflex.Primarykey;
import entity.BaseEntity;
import entity.person.Person;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public abstract class AbstractDAODB<T extends BaseEntity> implements CrudDAO {

    public static Connection getConn() throws Exception {
        String driver = "com.mysql.jdbc.Driver";//MySQL driver, do not explain
        String url = "jdbc:mysql://localhost:3306/software_for_railway_transport";//The MySQL connection URL, do not explain
        String user = "root";//MySQL users
        String password = "root";//MySQL password
        Class.forName(driver); //Load the driver
        return DriverManager.getConnection(url, user, password);//Get connected
    }

    private static void getAllField(List<Field> fieldList, Class<?> clazz) {
        if (clazz == Object.class) {
            return;
        } else {
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                fieldList.add(field);
            }

            getAllField(fieldList, clazz.getSuperclass());
        }
    }

    protected abstract Class getClazz();

    @Override
    public List<T> findAll() {
        return null;
    }

    @Override
    public T findById(long id) {
        return null;
    }

    @Override
    public boolean deleteById(long id) {

        Class clazz = getClazz();
        List<Field> fieldList = new LinkedList<>();
        getAllField(fieldList, clazz);

//РАЗОБРАТЬ !!!!
        Field key = null;
        for (Field field : fieldList) {
            if (field.isAnnotationPresent(Primarykey.class)) {
                key = field;
                break;
            }
        }



        String sql = "DELETE FROM `" + clazz.getSimpleName() + "` WHERE `" + key.getName() + "` = " + id + ";";
        System.out.println(sql);
        try (Connection conn = getConn();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean delete(BaseEntity entity) {
        return false;
    }

    @Override
    public BaseEntity create(BaseEntity entity) {
        return null;
    }

    @Override
    public BaseEntity update(BaseEntity entity) {
        return null;
    }
}
