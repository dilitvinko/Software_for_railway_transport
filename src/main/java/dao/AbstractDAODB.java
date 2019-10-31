package dao;

import dao.interfaces.CrudDAO;
import entity.BaseEntity;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public abstract class AbstractDAODB<T extends BaseEntity> implements CrudDAO {

  public static Connection getConn() throws Exception {
    String driver = "com.mysql.jdbc.Driver";
    //?serverTimezone=UTC
    String url = "jdbc:mysql://localhost:3306/software_for_railway_transport";
    String user = "root";
    String password = "root";
    Class.forName(driver);
    return DriverManager.getConnection(url, user, password);
  }

  private static void getAllField(List<Field> fieldList, Class<?> clazz) {
    if (clazz == Object.class) {
      return;
    } else {
      Field[] fields = clazz.getDeclaredFields();
      for (Field field : fields) {
        if (!(Collection.class.isAssignableFrom(field.getType()) || BaseEntity.class
            .isAssignableFrom(field.getType()))) {
          fieldList.add(field);
        }
      }

      getAllField(fieldList, clazz.getSuperclass());
    }
  }

  private static void getAllFieldNoId(List<Field> fieldList, Class<?> clazz) {
    if (clazz == Object.class) {
      return;
    } else {
      Field[] fields = clazz.getDeclaredFields();
      for (Field field : fields) {
        if (!(Collection.class.isAssignableFrom(field.getType()) ||
            BaseEntity.class.isAssignableFrom(field.getType()) ||
            field.getName().equals("id"))) {
          fieldList.add(field);
        }
      }

      getAllFieldNoId(fieldList, clazz.getSuperclass());
    }
  }

  private void setValue(ResultSet result, T data, Field field) throws Exception {
    boolean isAccess = field.isAccessible();
    try {
//Close the safety check, or read not to private property
      field.setAccessible(true);
      if (field.getType() == byte.class || field.getType() == Byte.class) {
        field.setByte(data, result.getByte(field.getName()));
      } else if (field.getType() == boolean.class || field.getType() == Boolean.class) {
        field.setBoolean(data, result.getBoolean(field.getName()));
      } else if (field.getType() == short.class || field.getType() == Short.class) {
        field.setShort(data, result.getShort(field.getName()));
      } else if (field.getType() == char.class || field.getType() == Character.class) {
        field.set(data, result.getString(field.getName()).charAt(0));
      } else if (field.getType() == int.class || field.getType() == Integer.class) {
        field.setInt(data, result.getInt(field.getName()));
      } else if (field.getType() == float.class || field.getType() == Float.class) {
        field.setFloat(data, result.getFloat(field.getName()));
      } else if (field.getType() == long.class || field.getType() == Long.class) {
        field.setLong(data, result.getLong(field.getName()));
      } else if (field.getType() == double.class || field.getType() == Double.class) {
        field.setDouble(data, result.getDouble(field.getName()));
      } else if (field.getType() == String.class) {
        field.set(data, result.getString(field.getName()));
      } else if (field.getType() == Timestamp.class) {
        field.set(data, result.getTimestamp(field.getName()));
      } else if (field.getType() == Time.class) {
        field.set(data, result.getTime((field.getName())));
      } else if (field.getType() == Date.class) {
        field.set(data, result.getDate((field.getName())));
      } else {
//This column only supports the above types, if the need for new types increase disposal; generic processing can also support, because the time is limited, the generic type is more complex, here don't do processing, later will have the opportunity to send a generic processing
        throw new RuntimeException("uns provided type:" + field.getType());
      }
    } finally {
      field.setAccessible(isAccess);
    }
  }

  private void setStatement(PreparedStatement statement, int index, BaseEntity data, Field field)
      throws Exception {
    boolean isAccess = field.isAccessible();
    try {
//Close the safety check, or read not to private property
      field.setAccessible(true);
      if (field.getType() == byte.class || field.getType() == Byte.class) {
        statement.setByte(index, field.getByte(data));
      } else if (field.getType() == boolean.class || field.getType() == Boolean.class) {
        statement.setBoolean(index, field.getBoolean(data));
      } else if (field.getType() == short.class || field.getType() == Short.class) {
        statement.setShort(index, field.getShort(data));
      } else if (field.getType() == char.class || field.getType() == Character.class) {
        statement.setString(index, String.valueOf(field.getChar(data)));
      } else if (field.getType() == int.class || field.getType() == Integer.class) {
        statement.setInt(index, field.getInt(data));
      } else if (field.getType() == float.class || field.getType() == Float.class) {
        statement.setFloat(index, field.getFloat(data));
      } else if (field.getType() == long.class || field.getType() == Long.class) {
        statement.setLong(index, field.getLong(data));
      } else if (field.getType() == double.class || field.getType() == Double.class) {
        statement.setDouble(index, field.getDouble(data));
      } else if (field.getType() == String.class) {
        statement.setString(index, field.get(data).toString());
      } else if (field.getType() == Timestamp.class) {
        statement.setObject(index, field.get(data));
      } else if (field.getType() == Time.class) {
        statement.setObject(index, field.get(data));
      } else if (field.getType() == Date.class) {
        statement.setObject(index, field.get(data));
      } else {
//This column only supports the above types, if the need for new types increase disposal; generic processing can also support, because the time is limited, the generic type is more complex, here don't do processing, later will have the opportunity to send a generic processing
        throw new RuntimeException("uns provided type:" + field.getType());
      }
    } finally {
      field.setAccessible(isAccess);
    }
  }


  protected abstract Class getClazz();

  @Override
  public List<T> findAll() {
    Class clazz = getClazz();
    List<T> allData = new ArrayList<>();
    List<Field> fieldList = new LinkedList<>();
    getAllField(fieldList, clazz);
    String sql = "SELECT * FROM `" + clazz.getSimpleName() + "`;";

    T data = null;

    try (Connection conn = getConn();
        PreparedStatement statement = conn.prepareStatement(sql);
        ResultSet result = statement.executeQuery()) {
      while (result.next()) {

        try {
          data = (T) clazz.newInstance();
        } catch (InstantiationException e) {
          e.printStackTrace();
        } catch (IllegalAccessException e) {
          e.printStackTrace();
        }

        for (Field field : fieldList) {
          setValue(result, data, field);
        }
        if (!allData.contains(data)) {
          allData.add(data);
        }

      }
    } catch (SQLException e) {
      e.printStackTrace();
    } catch (Exception e) {
      e.printStackTrace();
    }

    return allData;
  }

  @Override
  public T findById(long id) {
    Class clazz = getClazz();
    List<Field> fieldList = new LinkedList<>();
    getAllField(fieldList, clazz);

//// Here to find out key
//        Field key = null;
//        for (Field field : fieldList) {
//            if (field.isAnnotationPresent(Primarykey.class)) {
//                key = field;
//                break;
//            }
//        }
//
//// Primary key does not exist, don't write their own SQL query processing
//        if (key == null) {
//            throw new RuntimeException("unkown select key:" + id);
//        }

// Query SQL, according to the primary key retrieval, using the definition attribute name here. Can use the configuration, or the other way
    String sql = "SELECT * FROM `" + clazz.getSimpleName() + "` WHERE `id` = " + id + ";";

    T data = null;

    try {
      data = (T) clazz.newInstance();
    } catch (InstantiationException e) {
      e.printStackTrace();
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    }

    try (Connection conn = getConn();
        PreparedStatement statement = conn.prepareStatement(sql);
        ResultSet result = statement.executeQuery()) {
      if (result.next()) {
// Note: non parametric method to construct such must have public, of course, can handle parameter structure method

        for (Field field : fieldList) {
//Attribute assignment
          setValue(result, data, field);
        }

      }
    } catch (SQLException e) {
      e.printStackTrace();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return data;
  }

  @Override
  public boolean deleteById(long id) {

    Class clazz = getClazz();
    // List<Field> fieldList = new LinkedList<>();
    // getAllField(fieldList, clazz);

////РАЗОБРАТЬ  НАДО ЛИ!!!!
//        Field key = null;
//        for (Field field : fieldList) {
//            if (field.isAnnotationPresent(Primarykey.class)) {
//                key = field;
//                break;
//            }
//        }

    String sql = "DELETE FROM `" + clazz.getSimpleName() + "` WHERE `id` = " + id + ";";
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
    return deleteById(entity.getId());
  }

  @Override
  public T create(BaseEntity entity) {

    List<Field> fieldList = new LinkedList<>();
    getAllFieldNoId(fieldList, entity.getClass());

    StringBuffer keys = new StringBuffer();
    StringBuffer values = new StringBuffer();
    for (Field field : fieldList) {
      if (!(Collection.class.isAssignableFrom(field.getType()) || BaseEntity.class
          .isAssignableFrom(field.getType()))) {
        if (keys.length() > 0) {
          keys.append(",");
          values.append(",");
        }
//The definition of attribute names with a field name, you can use the hibernate class is a XML configuration, notes and other processing
        keys.append("`").append(field.getName()).append("`");
        values.append("?");
      }
    }

//Formation of the insert SQL, don't do the correlation processing (left, right, inline etc.)
    StringBuffer sql = new StringBuffer();
    sql.append("INSERT INTO `");
//Here is the table name, I called the name of the table; you can use the hibernate similar to the XML configuration, annotations etc.
    sql.append(entity.getClass().getSimpleName());
    sql.append("` ( ").append(keys).append(") VALUES (").append(values.toString()).append(");");

    try (Connection conn = getConn();
        PreparedStatement statement = conn
            .prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS)
    ) {
      int index = 1;
      for (Field field : fieldList) {
        setStatement(statement, index, entity, field);
        index++;
      }

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


    } catch (SQLException e) {
      e.printStackTrace();
    } catch (Exception e) {
      e.printStackTrace();
    }

    return (T) entity;
  }

  @Override
  public T update(BaseEntity entity) {
    List<Field> fieldList = new LinkedList<>();
    getAllField(fieldList, entity.getClass());

    StringBuffer keys = new StringBuffer();
    for (Field field : fieldList) {

      if (keys.length() > 0) {
        keys.append(",");
      }
//The definition of attribute names with a field name, you can use the hibernate class is a XML configuration, notes and other processing
      keys.append("`").append(field.getName()).append("` = ?");
    }

    StringBuffer sql = new StringBuffer();
    sql.append("UPDATE `").append(entity.getClass().getSimpleName());
    sql.append("` SET ").append(keys.toString());
    sql.append(" WHERE `id` = ").append(entity.getId()).append(";");

    try (Connection conn = getConn();
        PreparedStatement statement = conn.prepareStatement(sql.toString())) {
      int index = 1;
      for (Field field : fieldList) {
        setStatement(statement, index, entity, field);
        index++;
      }
      statement.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return (T) entity;
  }
}
