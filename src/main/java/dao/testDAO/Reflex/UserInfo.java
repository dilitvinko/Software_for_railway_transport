package dao.testDAO.Reflex;

import dao.testDAO.t_test_Abstract_DAO;

import java.sql.Timestamp;


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
// info.setId(1024);
// info.setName("Liu Zhen");
// info.setAge((short)80);
// info.setSex((byte)1);
// info.setMoney(50.5f);
// info.setBornTime(new Timestamp(System.currentTimeMillis()));
// ORMUtils.doInsert(info);

//Retrieval testing
//        UserInfo info_2 = ORMUtils.doSelect(UserInfo.class, 1024);
//        System.out.println(info_2);

        t_test_Abstract_DAO t_test_abstract_dao = new t_test_Abstract_DAO();
        t_test_abstract_dao.deleteById(14);

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
