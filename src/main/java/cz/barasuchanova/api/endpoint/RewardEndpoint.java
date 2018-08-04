package cz.barasuchanova.api.endpoint;

import cz.barasuchanova.api.service.RewardAPIService;
import cz.barasuchanova.persistence.model.Reward;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("reward")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RewardEndpoint extends AbstractEndpoint {

    RewardAPIService apiService = RewardAPIService.INSTANCE;

    @POST
    public Response create(Reward reward) {
        return apiService.create(reward);
    }

    @GET
    @Path("{id}")
    public Response getReward(@PathParam("id") Integer id) {
        return apiService.read(id);
    }

    @PUT
    @Path("{id}")
    public Response put(@PathParam("id") Integer id, Reward reward) {
        return apiService.update(id, reward);
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") Integer id) {
        return apiService.delete(id);
    }

}