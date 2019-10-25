package entity.TestFeauture;

import entity.BaseEntity;

public class TestClass_2 extends BaseEntity {
    private int count;
    private int numberOrder;

    public TestClass_2() {
    }

    public TestClass_2(long id, int count, int numberOrder) {
        super(id);
        this.count = count;
        this.numberOrder = numberOrder;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getNumberOrder() {
        return numberOrder;
    }

    public void setNumberOrder(int numberOrder) {
        this.numberOrder = numberOrder;
    }
}
