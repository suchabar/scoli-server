package cz.barasuchanova.api.endpoint;

import cz.barasuchanova.api.service.MedicalCheckupAPIService;
import cz.barasuchanova.persistence.model.MedicalCheckup;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("medicalCheckup")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MedicalCheckupEndpoint extends AbstractEndpoint {

    MedicalCheckupAPIService apiService = MedicalCheckupAPIService.INSTANCE;

    @POST
    public Response create(MedicalCheckup medicalCheckup) {
        return apiService.create(medicalCheckup);
    }

    @GET
    @Path("{id}")
    public Response getMedicalCheckup(@PathParam("id") Integer id) {
        return apiService.read(id);
    }

    @PUT
    @Path("{id}")
    public Response put(@PathParam("id") Integer id, MedicalCheckup medicalCheckup) {
        return apiService.update(id, medicalCheckup);
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") Integer id) {
        return apiService.delete(id);
    }

}