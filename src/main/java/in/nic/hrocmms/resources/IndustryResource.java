package in.nic.hrocmms.resources;

import in.nic.hrocmms.model.Industry;
import in.nic.hrocmms.model.Officer;
import in.nic.hrocmms.service.IndustryService;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("industry")
public class IndustryResource {

    private IndustryService industryService = new IndustryService();

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public List<Industry> getData(){
        return industryService.getAllData();
    }
}
