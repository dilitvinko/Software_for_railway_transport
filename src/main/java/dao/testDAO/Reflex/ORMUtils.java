package dao.testDAO.Reflex;



import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.*;


public class ORMUtils {


    static Set<String> modifys = new HashSet<>();



    public static Connection getConn() throws Exception {
        String driver = "com.mysql.jdbc.Driver";//MySQL driver, do not explain
        String url = "jdbc:mysql://localhost:3306/software_for_railway_transport";//The MySQL connection URL, do not explain
        String user = "root";//MySQL users
        String password = "root";//MySQL password
        Class.forName(driver); //Load the driver
        return DriverManager.getConnection(url, user, password);//Get connected
    }

    public static void doInsert(HashID data) throws Exception {
        List<Field> fieldList = new LinkedList<>();
        getAllField(fieldList, data.getClass());

        StringBuffer keys = new StringBuffer();
        StringBuffer values = new StringBuffer();
        for (Field field : fieldList) {
            if (keys.length() > 0) {
                keys.append(",");
                values.append(",");
            }
//The definition of attribute names with a field name, you can use the hibernate class is a XML configuration, notes and other processing
            keys.append("`").append(field.getName()).append("`");
            values.append("?");
        }

//Formation of the insert SQL, don't do the correlation processing (left, right, inline etc.)
        StringBuffer sql = new StringBuffer();
        sql.append("INSERT INTO `");
//Here is the table name, I called the name of the table; you can use the hibernate similar to the XML configuration, annotations etc.
        sql.append(data.getClass().getSimpleName());
        sql.append("` ( ").append(keys).append(") VALUES (").append(values.toString()).append(");");

        try (Connection conn = getConn();
             PreparedStatement statement = conn.prepareStatement(sql.toString())) {
            int index = 1;
            for (Field field : fieldList) {
                setStatement(statement, index, data, field);
                index ++;
            }

            statement.executeUpdate();
        }

    }

    // It does not deal with according to the primary key to retrieve the doSelect, see(Class<T> clazz, Object Id)
// public <T extends HashID> T doSelect(Class<T> clazz, String sql) {
// List<Field> fieldList = new LinkedList<>();
//
// return null;
// }
//
// Retrieval, return a single object; return multiple time increase
    public static <T extends HashID> T doSelect(Class<T> clazz, Object Id) throws Exception {
        List<Field> fieldList = new LinkedList<>();
        getAllField(fieldList, clazz);

// Here to find out key
        Field key = null;
        for (Field field : fieldList) {
            if (field.isAnnotationPresent(Primarykey.class)) {
                key = field;
                break;
            }
        }

// Primary key does not exist, don't write their own SQL query processing
        if (key == null) {
            throw new RuntimeException("unkown select key:" + Id);
        }

// Query SQL, according to the primary key retrieval, using the definition attribute name here. Can use the configuration, or the other way
        String sql = "SELECT * FROM `" + clazz.getSimpleName() + "` where `" + key.getName() + "` = " + Id +";";


        try (Connection conn = getConn();
             PreparedStatement statement = conn.prepareStatement(sql);
             ResultSet result = statement.executeQuery()) {
            if (result.next()) {
// Note: non parametric method to construct such must have public, of course, can handle parameter structure method
                T data = clazz.newInstance();

                for (Field field : fieldList) {
//Attribute assignment
                    setValue(result, data, field);
                }
                return data;
            } else {
                return null;
            }
        }
    }

    public static void doUpdate(HashID data) throws Exception {
        List<Field> fieldList = new LinkedList<>();
        getAllField(fieldList, data.getClass());

        Field key = null;
        StringBuffer keys = new StringBuffer();
        for (Field field : fieldList) {
            if (field.isAnnotationPresent(Primarykey.class)) {
                key = field;
            }

            if (keys.length() > 0) {
                keys.append(",");
            }
//The definition of attribute names with a field name, you can use the hibernate class is a XML configuration, notes and other processing
            keys.append("`").append(field.getName()).append("` = ?");
        }

        StringBuffer sql = new StringBuffer();
        sql.append("UPDATE `").append(data.getClass().getSimpleName());
        sql.append("` SET ").append(keys.toString());
        sql.append(" WHERE `").append(key.getName()).append("` = ").append(data.getId()).append(";");

        try (Connection conn = getConn();
             PreparedStatement statement = conn.prepareStatement(sql.toString())) {
            int index = 1;
            for (Field field : fieldList) {
                setStatement(statement, index, data, field);
                index ++;
            }
            statement.executeUpdate();
        }
    }

    public static void doDelete(HashID data) throws Exception {
        doDelete(data.getClass(), data.getId());
    }

    public static void doDelete(Class<?> clazz, Object Id) throws Exception {
        List<Field> fieldList = new LinkedList<>();
        getAllField(fieldList, clazz);

        Field key = null;
        for (Field field : fieldList) {
            if (field.isAnnotationPresent(Primarykey.class)) {
                key = field;
                break;
            }
        }

        String sql = "DELETE FROM `" + clazz.getSimpleName() + "` WHERE `" + key.getName() + "` = " + Id + ";";
        System.out.println(sql);
        try (Connection conn = getConn();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.executeUpdate();
        }
    }

    private static void setStatement(PreparedStatement statement, int index, HashID data, Field field) throws Exception {
        boolean isAccess = field.isAccessible();
        try {
//Close the safety check, or read not to private property
            field.setAccessible(true);
            if (field.getType() == byte.class || field.getType() == Byte.class ) {
                statement.setByte(index, field.getByte(data));
            } else if (field.getType() == boolean.class || field.getType() == Boolean.class ) {
                statement.setBoolean(index, field.getBoolean(data));
            } else if (field.getType() == short.class || field.getType() == Short.class ) {
                statement.setShort(index, field.getShort(data));
            } else if (field.getType() == char.class || field.getType() == Character.class ) {
                statement.setString(index, String.valueOf(field.getChar(data)));
            } else if (field.getType() == int.class || field.getType() == Integer.class ) {
                statement.setInt(index, field.getInt(data));
            } else if (field.getType() == float.class || field.getType() == Float.class ) {
                statement.setFloat(index, field.getFloat(data));
            } else if (field.getType() == long.class || field.getType() == Long.class ) {
                statement.setLong(index, field.getLong(data));
            } else if (field.getType() == double.class || field.getType() == Double.class ) {
                statement.setDouble(index, field.getDouble(data));
            } else if (field.getType() == String.class) {
                statement.setString(index, field.get(data).toString());
            } else if (field.getType() == Timestamp.class){
                statement.setObject(index, field.get(data));
            } else {
//This column only supports the above types, if the need for new types increase disposal; generic processing can also support, because the time is limited, the generic type is more complex, here don't do processing, later will have the opportunity to send a generic processing
                throw new RuntimeException("uns provided type:" + field.getType());
            }
        } finally {
            field.setAccessible(isAccess);
        }
    }

    private static void setValue(ResultSet result, HashID data, Field field) throws Exception {
        boolean isAccess = field.isAccessible();
        try {
//Close the safety check, or read not to private property
            field.setAccessible(true);
            if (field.getType() == byte.class || field.getType() == Byte.class ) {
                field.setByte(data, result.getByte(field.getName()));
            } else if (field.getType() == boolean.class || field.getType() == Boolean.class ) {
                field.setBoolean(data, result.getBoolean(field.getName()));
            } else if (field.getType() == short.class || field.getType() == Short.class ) {
                field.setShort(data, result.getShort(field.getName()));
            } else if (field.getType() == char.class || field.getType() == Character.class ) {
                field.set(data, result.getString(field.getName()).charAt(0));
            } else if (field.getType() == int.class || field.getType() == Integer.class ) {
                field.setInt(data, result.getInt(field.getName()));
            } else if (field.getType() == float.class || field.getType() == Float.class ) {
                field.setFloat(data, result.getFloat(field.getName()));
            } else if (field.getType() == long.class || field.getType() == Long.class ) {
                field.setLong(data, result.getLong(field.getName()));
            } else if (field.getType() == double.class || field.getType() == Double.class ) {
                field.setDouble(data, result.getDouble(field.getName()));
            } else if (field.getType() == String.class) {
                field.set(data, result.getString(field.getName()));
            } else if (field.getType() == Timestamp.class){
                field.set(data, result.getTimestamp(field.getName()));
            } else {
//This column only supports the above types, if the need for new types increase disposal; generic processing can also support, because the time is limited, the generic type is more complex, here don't do processing, later will have the opportunity to send a generic processing
                throw new RuntimeException("uns provided type:" + field.getType());
            }
        } finally {
            field.setAccessible(isAccess);
        }
    }

    // Get all the defining properties, special treatment here don't do; if you need to deal with, such as the static final definition
// Still can decide whether the property used in note form processing
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
}
