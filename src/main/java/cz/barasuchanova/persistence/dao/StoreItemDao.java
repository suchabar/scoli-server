package cz.barasuchanova.persistence.dao;

import cz.barasuchanova.persistence.IEntityManagerProvider;
import cz.barasuchanova.persistence.model.StoreItem;

public class StoreItemDao extends GenericDao<StoreItem> {
    public StoreItemDao(IEntityManagerProvider entityManagerProvider) {
        super(StoreItem.class, entityManagerProvider);
    }
}

