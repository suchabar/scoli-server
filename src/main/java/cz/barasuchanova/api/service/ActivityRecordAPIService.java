package cz.barasuchanova.api.service;

import cz.barasuchanova.persistence.DaoWrapper;
import cz.barasuchanova.persistence.model.ActivityRecord;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import javax.ws.rs.core.Response;

@FieldDefaults(level = AccessLevel.PRIVATE)
public enum ActivityRecordAPIService {
    INSTANCE;
    DaoWrapper daoWrapper = DaoWrapper.INSTANCE;

    public Response create(ActivityRecord activityRecord) {
        try {
            daoWrapper.getActivityRecordDao().create(activityRecord);
            return Response.ok(activityRecord).build();
        } catch (Exception e) {
            return Response.serverError().build();
        }
    }

    public Response read(Integer id) {
        try {
            final ActivityRecord activityRecord = daoWrapper.getActivityRecordDao().read(id);
            return Response.ok(activityRecord).build();
        } catch (Exception e) {
            return Response.serverError().build();
        }
    }

    public Response update(Integer id, ActivityRecord activityRecord) {
        try {
            final ActivityRecord activityRecordFromDB = daoWrapper.getActivityRecordDao().read(id);
            activityRecordFromDB.setStarted(activityRecord.getStarted());
            activityRecordFromDB.setEnded(activityRecord.getEnded());
            activityRecordFromDB.setSource(activityRecord.getSource());
            activityRecordFromDB.setNote(activityRecord.getNote());
            activityRecordFromDB.setChild(activityRecord.getChild());
            daoWrapper.getActivityRecordDao().update(activityRecordFromDB);
            return Response.ok(activityRecordFromDB).build();
        } catch (Exception e) {
            return Response.serverError().build();
        }
    }

    public Response delete(Integer id) {
        try {
            final ActivityRecord activityRecord = daoWrapper.getActivityRecordDao().read(id);
            daoWrapper.getActivityRecordDao().delete(activityRecord);
            return Response.ok().build();
        } catch (Exception e) {
            return Response.serverError().build();
        }
    }
}
