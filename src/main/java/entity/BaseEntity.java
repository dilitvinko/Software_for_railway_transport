package entity;

import dao.testDAO.reflex_test.Primarykey;

public abstract class BaseEntity {
    @Primarykey
    private long id;

    public BaseEntity() {
    }

    public BaseEntity(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
