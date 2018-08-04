package cz.barasuchanova.api.endpoint;

import cz.barasuchanova.api.service.BraceAPIService;
import cz.barasuchanova.persistence.model.Brace;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("brace")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BraceEndpoint extends AbstractEndpoint {

    BraceAPIService apiService = BraceAPIService.INSTANCE;

    @POST
    public Response create(Brace brace) {
        return apiService.create(brace);
    }

    @GET
    @Path("{id}")
    public Response getBrace(@PathParam("id") Integer id) {
        return apiService.read(id);
    }

    @PUT
    @Path("{id}")
    public Response put(@PathParam("id") Integer id, Brace brace) {
        return apiService.update(id, brace);
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") Integer id) {
        return apiService.delete(id);
    }

}