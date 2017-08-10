package in.nic.hrocmms.resources;
import in.nic.hrocmms.model.Officer;
import in.nic.hrocmms.service.OfficerService;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("officer")
public class OfficerResource {
    private OfficerService officerService = new OfficerService();

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public List<Officer> getData(){
        return officerService.getAllData();
    }

}
