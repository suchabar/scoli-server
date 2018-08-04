package cz.barasuchanova.api.service;

import cz.barasuchanova.persistence.DaoWrapper;
import cz.barasuchanova.persistence.model.StoreItem;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import javax.ws.rs.core.Response;

@FieldDefaults(level = AccessLevel.PRIVATE)
public enum StoreItemAPIService {
    INSTANCE;
    DaoWrapper daoWrapper = DaoWrapper.INSTANCE;

    public Response create(StoreItem storeItem) {
        try {
            daoWrapper.getStoreItemDao().create(storeItem);
            return Response.ok(storeItem).build();
        } catch (Exception e) {
            return Response.serverError().build();
        }
    }

    public Response read(Integer id) {
        try {
            final StoreItem storeItem = daoWrapper.getStoreItemDao().read(id);
            return Response.ok(storeItem).build();
        } catch (Exception e) {
            return Response.serverError().build();
        }
    }

    public Response update(Integer id, StoreItem storeItem) {
        try {
            final StoreItem storeItemFromDB = daoWrapper.getStoreItemDao().read(id);
            storeItemFromDB.setTitle(storeItem.getTitle());
            storeItemFromDB.setPrice(storeItem.getPrice());
            storeItemFromDB.setNote(storeItem.getNote());
            storeItemFromDB.setPictureUrl(storeItem.getPictureUrl());
            daoWrapper.getStoreItemDao().update(storeItemFromDB);
            return Response.ok(storeItemFromDB).build();
        } catch (Exception e) {
            return Response.serverError().build();
        }
    }

    public Response delete(Integer id) {
        try {
            final StoreItem storeItem = daoWrapper.getStoreItemDao().read(id);
            daoWrapper.getStoreItemDao().delete(storeItem);
            return Response.ok().build();
        } catch (Exception e) {
            return Response.serverError().build();
        }
    }
}
