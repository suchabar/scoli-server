package cz.barasuchanova.api.service;

import cz.barasuchanova.persistence.DaoWrapper;
import cz.barasuchanova.persistence.model.WearingRecord;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import javax.ws.rs.core.Response;

@FieldDefaults(level = AccessLevel.PRIVATE)
public enum WearingRecordAPIService {
    INSTANCE;
    DaoWrapper daoWrapper = DaoWrapper.INSTANCE;

    public Response create(WearingRecord wearingRecord) {
        try {
            daoWrapper.getWearingRecordDao().create(wearingRecord);
            return Response.ok(wearingRecord).build();
        } catch (Exception e) {
            return Response.serverError().build();
        }
    }

    public Response read(Integer id) {
        try {
            final WearingRecord wearingRecord = daoWrapper.getWearingRecordDao().read(id);
            return Response.ok(wearingRecord).build();
        } catch (Exception e) {
            return Response.serverError().build();
        }
    }

    public Response update(Integer id, WearingRecord wearingRecord) {
        try {
            final WearingRecord wearingRecordFromDB = daoWrapper.getWearingRecordDao().read(id);
            wearingRecordFromDB.setStarted(wearingRecord.getStarted());
            wearingRecordFromDB.setEnded(wearingRecord.getEnded());
            wearingRecordFromDB.setBrace(wearingRecord.getBrace());
            daoWrapper.getWearingRecordDao().update(wearingRecordFromDB);
            return Response.ok(wearingRecordFromDB).build();
        } catch (Exception e) {
            return Response.serverError().build();
        }
    }

    public Response delete(Integer id) {
        try {
            final WearingRecord wearingRecord = daoWrapper.getWearingRecordDao().read(id);
            daoWrapper.getWearingRecordDao().delete(wearingRecord);
            return Response.ok().build();
        } catch (Exception e) {
            return Response.serverError().build();
        }
    }

}
