package cz.barasuchanova.api.endpoint;

import cz.barasuchanova.api.service.ActivityRecordAPIService;
import cz.barasuchanova.persistence.model.ActivityRecord;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("activityRecord")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ActivityRecordEndpoint extends AbstractEndpoint {

    ActivityRecordAPIService apiService = ActivityRecordAPIService.INSTANCE;

    @POST
    public Response create(ActivityRecord activityRecord) {
        return apiService.create(activityRecord);
    }

    @GET
    @Path("{id}")
    public Response getActivityRecord(@PathParam("id") Integer id) {
        return apiService.read(id);
    }

    @PUT
    @Path("{id}")
    public Response put(@PathParam("id") Integer id, ActivityRecord activityRecord) {
        return apiService.update(id, activityRecord);
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") Integer id) {
        return apiService.delete(id);
    }

}