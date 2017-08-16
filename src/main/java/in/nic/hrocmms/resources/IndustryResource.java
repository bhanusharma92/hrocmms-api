package in.nic.hrocmms.resources;

import in.nic.hrocmms.model.Industry;
import in.nic.hrocmms.model.Officer;
import in.nic.hrocmms.service.IndustryService;
import in.nic.hrocmms.service.UtilityService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("industry")
public class IndustryResource {

    private IndustryService industryService = new IndustryService();

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public List<Industry> getData(@FormParam("loginId") String userId){
        if(userId != null && !userId.isEmpty()){
            return industryService.getDataByUserId(userId);
        }else {
            return industryService.getAllData();
        }

    }

}
