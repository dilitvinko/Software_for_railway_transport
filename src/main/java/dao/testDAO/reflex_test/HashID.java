package dao.testDAO.reflex_test;

public interface HashID {

    public Object getId();

    /**
     * Modify marker
     * @Param name to modify the attribute name
     */
    default void modify(String name) {
        ORMUtils.modifys.add(name);
    }

}
