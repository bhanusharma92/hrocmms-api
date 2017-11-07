package in.nic.hrocmms.resources;
import in.nic.hrocmms.model.ApplicationDetailNew;
import in.nic.hrocmms.service.CheckStatusService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("checkCTOStatus")
public class checkCTOStatusResource {

    private CheckStatusService checkStatusService = new CheckStatusService();

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<ApplicationDetailNew> checkStatusCTO(@QueryParam("appNo") String appNo) {
        System.out.println("inside checkStatus");
        return checkStatusService.getData(appNo, "CTO");

    }

}
