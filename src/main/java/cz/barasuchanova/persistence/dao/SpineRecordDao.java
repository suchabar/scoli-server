package cz.barasuchanova.persistence.dao;

import cz.barasuchanova.persistence.IEntityManagerProvider;
import cz.barasuchanova.persistence.model.SpineRecord;

public class SpineRecordDao extends GenericDao<SpineRecord> {
    public SpineRecordDao(IEntityManagerProvider entityManagerProvider) {
        super(SpineRecord.class, entityManagerProvider);
    }
}

