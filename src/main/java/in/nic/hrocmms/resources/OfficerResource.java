package in.nic.hrocmms.resources;
import in.nic.hrocmms.model.Officer;
import in.nic.hrocmms.service.OfficerService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("officer")
public class OfficerResource {
    private OfficerService officerService = new OfficerService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Officer> getData(@QueryParam("loginId") String userId){
        if(userId != null && !userId.isEmpty()){
            return officerService.getDataByUserId(userId);
        }else {
            return officerService.getAllData();
        }
    }

}
