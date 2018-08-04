package cz.barasuchanova.api.endpoint;

import cz.barasuchanova.api.service.StoreItemAPIService;
import cz.barasuchanova.persistence.model.StoreItem;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("storeItem")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StoreItemEndpoint extends AbstractEndpoint {

    StoreItemAPIService apiService = StoreItemAPIService.INSTANCE;

    @POST
    public Response create(StoreItem storeItem) {
        return apiService.create(storeItem);
    }

    @GET
    @Path("{id}")
    public Response getStoreItem(@PathParam("id") Integer id) {
        return apiService.read(id);
    }

    @PUT
    @Path("{id}")
    public Response put(@PathParam("id") Integer id, StoreItem storeItem) {
        return apiService.update(id, storeItem);
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") Integer id) {
        return apiService.delete(id);
    }

}