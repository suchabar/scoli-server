package cz.barasuchanova.persistence;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.FlushModeType;
import javax.persistence.Persistence;

@Log
@FieldDefaults(level = AccessLevel.PRIVATE)
public enum DBUtils {
    INSTANCE;

    EntityManagerFactory emf;
    ThreadLocal<EntityManager> localEntityManager;

    public static DBUtils getInstance() {
        return INSTANCE;
    }

    private EntityManagerFactory createEntityManagerFactory() {
        emf = Persistence.createEntityManagerFactory("API_PU");
        localEntityManager = new ThreadLocal<>();
        return emf;
    }

    public EntityManager getEntityManager() {
        if (emf == null || !emf.isOpen())
            createEntityManagerFactory();

        EntityManager em = localEntityManager.get();
        if (em == null || !em.isOpen()) {
            em = emf.createEntityManager();
            em.setFlushMode(FlushModeType.COMMIT);
            localEntityManager.set(em);
        }
        return em;
    }

    public void closeEntityManagerFactory() {
        if (emf.isOpen()) emf.close();
    }

    public void closeEntityManager() {
        EntityManager em = localEntityManager.get();
        if (em != null) {
            em.close();
            localEntityManager.set(null);
        }
    }

    public void startEntityManagerFactory() {
        createEntityManagerFactory();
    }
}