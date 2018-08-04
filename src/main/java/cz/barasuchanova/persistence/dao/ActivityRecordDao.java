package cz.barasuchanova.persistence.dao;

import cz.barasuchanova.persistence.IEntityManagerProvider;
import cz.barasuchanova.persistence.model.ActivityRecord;

public class ActivityRecordDao extends GenericDao<ActivityRecord> {
    public ActivityRecordDao(IEntityManagerProvider entityManagerProvider) {
        super(ActivityRecord.class, entityManagerProvider);
    }
}

