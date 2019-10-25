package entity.TestFeauture;

import entity.BaseEntity;

import java.util.Set;

public class TestClass_1 extends BaseEntity {
    private String name;
    private int age;
    private Set<TestClass_2> set;

    public TestClass_1() {
    }

    public TestClass_1(long id, String name, int age, Set<TestClass_2> set) {
        super(id);
        this.name = name;
        this.age = age;
        this.set = set;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Set<TestClass_2> getSet() {
        return set;
    }

    public void setSet(Set<TestClass_2> set) {
        this.set = set;
    }

    @Override
    public String toString() {
        return "TestClass_1{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", set=" + set +
                ", id=" + getId() +
                '}';
    }
}
