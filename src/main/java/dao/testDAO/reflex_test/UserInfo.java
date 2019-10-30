package dao.testDAO.reflex_test;

import dao.testDAO.t_test_Abstract_DAO;
import entity.BaseEntity;
import entity.person.Person;
import entity.ticket.Ticket;
import entity.train.Train;

import java.lang.reflect.Field;
import java.sql.Timestamp;
import java.util.*;


public class UserInfo implements HashID {
    @Primarykey
    private int Id;
    private String name;
    private byte sex;
    private short age;
    private float money;
    private Timestamp bornTime;

    @Override
    public Object getId() {
        return Id;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public byte getSex() {
        return sex;
    }


    public void setSex(byte sex) {
        this.sex = sex;
    }


    public short getAge() {
        return age;
    }


    public void setAge(short age) {
        this.age = age;
    }


    public float getMoney() {
        return money;
    }


    public void setMoney(float money) {
        this.money = money;
    }


    public Timestamp getBornTime() {
        return bornTime;
    }


    public void setBornTime(Timestamp bornTime) {
        this.bornTime = bornTime;
    }


    public void setId(int id) {
        Id = id;
    }

    @Override
    public String toString() {
        return String.format("Id=%s, name=%s, age=%s, borntime＝%s", Id, name, age, bornTime);
    }

    public static void main(String[] args) throws Exception {
//Insert test
// UserInfo info = new UserInfo();
// info.setId(1025);
// info.setName("Liu Zhen");
// info.setAge((short)80);
// info.setSex((byte)1);
// info.setMoney(50.5f);
// info.setBornTime(new Timestamp(System.currentTimeMillis()));
// ORMUtils.doInsert(info);

//Retrieval testing
//        UserInfo info_2 = ORMUtils.doSelect(UserInfo.class, 1025);
//        System.out.println(info_2);



        Person person = new Person();
        System.out.println();
        System.out.println(person instanceof BaseEntity);
        System.out.println();


        Ticket ticket = new Ticket();

        Train train = new Train();

        for (Field f : train.getClass().getDeclaredFields()) {

            Class<?> type = f.getType();
            System.out.println(type);
            System.out.println(f.getClass());
            //System.out.println(type.getClass().isInstance());
            if(Collection.class.isAssignableFrom(f.getType())){
                System.out.println("test");
            }

        }

        t_test_Abstract_DAO t_test_abstract_dao = new t_test_Abstract_DAO();
        train.setName("A-123");
        t_test_abstract_dao.create(train);
//        t_test_abstract_dao.deleteById(2);
//        Route byId = t_test_abstract_dao.findById(2);
//        System.out.println(byId);


//        for (Route rout :
//                t_test_abstract_dao.findAll()) {
//            System.out.println(rout);
//        }

//        Route tr = new Route();
//        tr.setId(8);
//        tr.setName("Test_11111");
//        System.out.println(t_test_abstract_dao.update(tr));




// Modifying the test
// info.setName("Liu Yuxuan");
// info.setAge((short)1);
// info.setBornTime(new Timestamp(System.currentTimeMillis()));
// ORMUtils.doUpdate(info);
// System.out.println(info);

//Remove test
        //ORMUtils.doDelete(info);
    }


}
