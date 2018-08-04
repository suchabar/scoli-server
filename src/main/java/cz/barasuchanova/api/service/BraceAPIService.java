package cz.barasuchanova.api.service;

import cz.barasuchanova.persistence.DaoWrapper;
import cz.barasuchanova.persistence.model.Brace;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import javax.ws.rs.core.Response;

@FieldDefaults(level = AccessLevel.PRIVATE)
public enum BraceAPIService {
    INSTANCE;
    DaoWrapper daoWrapper = DaoWrapper.INSTANCE;

    public Response create(Brace brace) {
        try {
            daoWrapper.getBraceDao().create(brace);
            return Response.ok(brace).build();
        } catch (Exception e) {
            return Response.serverError().build();
        }
    }

    public Response read(Integer id) {
        try {
            final Brace brace = daoWrapper.getBraceDao().read(id);
            return Response.ok(brace).build();
        } catch (Exception e) {
            return Response.serverError().build();
        }
    }

    public Response update(Integer id, Brace brace) {
        try {
            final Brace braceFromDB = daoWrapper.getBraceDao().read(id);
            braceFromDB.setName(brace.getName());
            braceFromDB.setWearingFrom(brace.getWearingFrom());
            braceFromDB.setWearingTo(brace.getWearingTo());
            braceFromDB.setRecommendedWearingTime(brace.getRecommendedWearingTime());
            braceFromDB.setChild(brace.getChild());
            braceFromDB.setPhotoUrl(brace.getPhotoUrl());
            daoWrapper.getBraceDao().update(braceFromDB);
            return Response.ok(braceFromDB).build();
        } catch (Exception e) {
            return Response.serverError().build();
        }
    }

    public Response delete(Integer id) {
        try {
            final Brace brace = daoWrapper.getBraceDao().read(id);
            daoWrapper.getBraceDao().delete(brace);
            return Response.ok().build();
        } catch (Exception e) {
            return Response.serverError().build();
        }
    }

}
