package cz.barasuchanova.persistence;


import javax.persistence.EntityManager;

public class EntityManagerProvider implements IEntityManagerProvider {

    @Override
    public EntityManager getEntityManager() {
        return DBUtils.getInstance().getEntityManager();
    }

    @Override
    public void closeEntityManager() {
        DBUtils.getInstance().closeEntityManager();
    }
}
