package cz.barasuchanova.api.service;

import cz.barasuchanova.persistence.DaoWrapper;
import cz.barasuchanova.persistence.model.MedicalCheckup;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import javax.ws.rs.core.Response;

@FieldDefaults(level = AccessLevel.PRIVATE)
public enum MedicalCheckupAPIService  {
    INSTANCE;
    DaoWrapper daoWrapper = DaoWrapper.INSTANCE;

    public Response create(MedicalCheckup medicalCheckup) {
        try {
            daoWrapper.getMedicalCheckupDao().create(medicalCheckup);
            return Response.ok(medicalCheckup).build();
        } catch (Exception e) {
            return Response.serverError().build();
        }
    }

    public Response read(Integer id) {
        try {
            final MedicalCheckup medicalCheckup = daoWrapper.getMedicalCheckupDao().read(id);
            return Response.ok(medicalCheckup).build();
        } catch (Exception e) {
            return Response.serverError().build();
        }
    }

    public Response update(Integer id, MedicalCheckup medicalCheckup) {
        try {
            final MedicalCheckup medicalCheckupFromDB = daoWrapper.getMedicalCheckupDao().read(id);
            medicalCheckupFromDB.setDate(medicalCheckup.getDate());
            medicalCheckupFromDB.setHeight(medicalCheckup.getHeight());
            medicalCheckupFromDB.setWeight(medicalCheckup.getWeight());
            medicalCheckupFromDB.setChild(medicalCheckup.getChild());
            daoWrapper.getMedicalCheckupDao().update(medicalCheckupFromDB);
            return Response.ok(medicalCheckupFromDB).build();
        } catch (Exception e) {
            return Response.serverError().build();
        }
    }

    public Response delete(Integer id) {
        try {
            final MedicalCheckup medicalCheckup = daoWrapper.getMedicalCheckupDao().read(id);
            daoWrapper.getMedicalCheckupDao().delete(medicalCheckup);
            return Response.ok().build();
        } catch (Exception e) {
            return Response.serverError().build();
        }
    }
}
