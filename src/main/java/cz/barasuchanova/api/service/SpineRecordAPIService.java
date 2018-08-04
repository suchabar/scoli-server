package cz.barasuchanova.api.service;

import cz.barasuchanova.persistence.DaoWrapper;
import cz.barasuchanova.persistence.model.SpineRecord;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import javax.ws.rs.core.Response;

@FieldDefaults(level = AccessLevel.PRIVATE)
public enum SpineRecordAPIService {
    INSTANCE;
    DaoWrapper daoWrapper = DaoWrapper.INSTANCE;

    public Response create(SpineRecord spineRecord) {
        try {
            daoWrapper.getSpineRecordDao().create(spineRecord);
            return Response.ok(spineRecord).build();
        } catch (Exception e) {
            return Response.serverError().build();
        }
    }

    public Response read(Integer id) {
        try {
            final SpineRecord spineRecord = daoWrapper.getSpineRecordDao().read(id);
            return Response.ok(spineRecord).build();
        } catch (Exception e) {
            return Response.serverError().build();
        }
    }

    public Response update(Integer id, SpineRecord spineRecord) {
        try {
            final SpineRecord spineRecordFromDB = daoWrapper.getSpineRecordDao().read(id);
            spineRecordFromDB.setBraceOn(spineRecord.getBraceOn());
            spineRecordFromDB.setSpineType(spineRecord.getSpineType());
            spineRecordFromDB.setAngle(spineRecord.getAngle());
            spineRecordFromDB.setAngle2(spineRecord.getAngle2());
            spineRecordFromDB.setMedicalCheckup(spineRecord.getMedicalCheckup());
            spineRecordFromDB.setRadiographUrl(spineRecord.getRadiographUrl());
            daoWrapper.getSpineRecordDao().update(spineRecordFromDB);
            return Response.ok(spineRecordFromDB).build();
        } catch (Exception e) {
            return Response.serverError().build();
        }
    }

    public Response delete(Integer id) {
        try {
            final SpineRecord spineRecord = daoWrapper.getSpineRecordDao().read(id);
            daoWrapper.getSpineRecordDao().delete(spineRecord);
            return Response.ok().build();
        } catch (Exception e) {
            return Response.serverError().build();
        }
    }
}
