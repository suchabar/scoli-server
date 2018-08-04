package cz.barasuchanova.api.service;

import cz.barasuchanova.persistence.DaoWrapper;
import cz.barasuchanova.persistence.model.Child;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import javax.ws.rs.core.Response;

@FieldDefaults(level = AccessLevel.PRIVATE)
public enum ChildAPIService {
    INSTANCE;
    DaoWrapper daoWrapper = DaoWrapper.INSTANCE;

     
    public Response create(Child child) {
        try {
            daoWrapper.getChildDao().create(child);
            return Response.ok(child).build();
        } catch (Exception e) {
            return Response.serverError().build();
        }
    }

    public Response read(Integer id) {
        try {
            final Child child = daoWrapper.getChildDao().read(id);
            return Response.ok(child).build();
        } catch (Exception e) {
            return Response.serverError().build();
        }
    }

    public Response update(Integer id, Child child) {
        try {
            final Child childFromDB = daoWrapper.getChildDao().read(id);
            childFromDB.setNickname(child.getNickname());
            childFromDB.setEmail(child.getEmail());
            childFromDB.setPoints(child.getPoints());
            childFromDB.setPassword(child.getPassword());
            childFromDB.setAvatarUrl(child.getAvatarUrl());
            daoWrapper.getChildDao().update(childFromDB);
            return Response.ok(childFromDB).build();
        } catch (Exception e) {
            return Response.serverError().build();
        }
    }

    public Response delete(Integer id) {
        try {
            final Child child = daoWrapper.getChildDao().read(id);
            daoWrapper.getChildDao().delete(child);
            return Response.ok().build();
        } catch (Exception e) {
            return Response.serverError().build();
        }
    }
}
