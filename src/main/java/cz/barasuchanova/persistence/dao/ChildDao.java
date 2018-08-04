package cz.barasuchanova.persistence.dao;

import cz.barasuchanova.persistence.IEntityManagerProvider;
import cz.barasuchanova.persistence.model.Child;

public class ChildDao extends GenericDao<Child> {
    public ChildDao(IEntityManagerProvider entityManagerProvider) {
        super(Child.class, entityManagerProvider);
    }
}

