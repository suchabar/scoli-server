package cz.barasuchanova.persistence;

import cz.barasuchanova.persistence.dao.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public enum DaoWrapper {
    INSTANCE;

    ChildDao childDao;
    MedicalCheckupDao medicalCheckupDao;
    BraceDao braceDao;
    ActivityRecordDao activityRecordDao;
    RewardDao rewardDao;
    SpineRecordDao spineRecordDao;
    WearingRecordDao wearingRecordDao;
    StoreItemDao storeItemDao;

    {
        EntityManagerProvider entityManagerProvider = new EntityManagerProvider();
        childDao = new ChildDao(entityManagerProvider);
        medicalCheckupDao = new MedicalCheckupDao(entityManagerProvider);
        braceDao = new BraceDao(entityManagerProvider);
        activityRecordDao = new ActivityRecordDao(entityManagerProvider);
        rewardDao = new RewardDao(entityManagerProvider);
        spineRecordDao = new SpineRecordDao(entityManagerProvider);
        wearingRecordDao = new WearingRecordDao(entityManagerProvider);
        storeItemDao = new StoreItemDao(entityManagerProvider);
    }
}
