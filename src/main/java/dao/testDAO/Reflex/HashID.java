package dao.testDAO.Reflex;

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
