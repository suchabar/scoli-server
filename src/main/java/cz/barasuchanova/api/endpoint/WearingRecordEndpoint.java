package cz.barasuchanova.api.endpoint;

import cz.barasuchanova.api.service.WearingRecordAPIService;
import cz.barasuchanova.persistence.model.WearingRecord;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("wearingRecord")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class WearingRecordEndpoint extends AbstractEndpoint {

    WearingRecordAPIService apiService = WearingRecordAPIService.INSTANCE;

    @POST
    public Response create(WearingRecord wearingRecord) {
        return apiService.create(wearingRecord);
    }

    @GET
    @Path("{id}")
    public Response getWearingRecord(@PathParam("id") Integer id) {
        return apiService.read(id);
    }

    @PUT
    @Path("{id}")
    public Response put(@PathParam("id") Integer id, WearingRecord wearingRecord) {
        return apiService.update(id, wearingRecord);
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") Integer id) {
        return apiService.delete(id);
    }

}