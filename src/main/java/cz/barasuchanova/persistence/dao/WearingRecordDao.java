package cz.barasuchanova.persistence.dao;

import cz.barasuchanova.persistence.IEntityManagerProvider;
import cz.barasuchanova.persistence.model.WearingRecord;

public class WearingRecordDao extends GenericDao<WearingRecord> {
    public WearingRecordDao(IEntityManagerProvider entityManagerProvider) {
        super(WearingRecord.class, entityManagerProvider);
    }
}

