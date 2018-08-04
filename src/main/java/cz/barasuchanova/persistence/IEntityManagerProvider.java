package cz.barasuchanova.persistence;

import javax.persistence.EntityManager;

public interface IEntityManagerProvider {

    EntityManager getEntityManager();

    void closeEntityManager();
}
