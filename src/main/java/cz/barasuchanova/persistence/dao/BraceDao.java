package cz.barasuchanova.persistence.dao;

import cz.barasuchanova.persistence.IEntityManagerProvider;
import cz.barasuchanova.persistence.model.Brace;

public class BraceDao extends GenericDao<Brace> {
    public BraceDao(IEntityManagerProvider entityManagerProvider) {
        super(Brace.class, entityManagerProvider);
    }
}

