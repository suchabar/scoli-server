package cz.barasuchanova.api.endpoint;

import cz.barasuchanova.api.service.ChildAPIService;
import cz.barasuchanova.persistence.model.Child;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("child")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ChildEndpoint extends AbstractEndpoint {

    ChildAPIService apiService = ChildAPIService.INSTANCE;

    @POST
    public Response create(Child child) {
        return apiService.create(child);
    }

    @GET
    @Path("{id}")
    public Response getChild(@PathParam("id") Integer id) {
        return apiService.read(id);
    }

    @PUT
    @Path("{id}")
    public Response put(@PathParam("id") Integer id, Child child) {
        return apiService.update(id, child);
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") Integer id) {
        return apiService.delete(id);
    }

}