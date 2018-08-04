package cz.barasuchanova.api.endpoint;

import cz.barasuchanova.api.service.SpineRecordAPIService;
import cz.barasuchanova.persistence.model.SpineRecord;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("spineRecord")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SpineRecordEndpoint extends AbstractEndpoint {

    SpineRecordAPIService apiService = SpineRecordAPIService.INSTANCE;

    @POST
    public Response create(SpineRecord spineRecord) {
        return apiService.create(spineRecord);
    }

    @GET
    @Path("{id}")
    public Response getSpineRecord(@PathParam("id") Integer id) {
        return apiService.read(id);
    }

    @PUT
    @Path("{id}")
    public Response put(@PathParam("id") Integer id, SpineRecord spineRecord) {
        return apiService.update(id, spineRecord);
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") Integer id) {
        return apiService.delete(id);
    }

}