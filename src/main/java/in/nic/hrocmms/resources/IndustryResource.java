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

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Industry> getData(
            @QueryParam("loginId") String userId,
            @QueryParam("fromDate") String fromDate,
            @QueryParam("toDate") String toDate){
        boolean isValidDateSupplied = UtilityService.validDateSuppliedCheck(fromDate, toDate);
        if(isValidDateSupplied){
            return industryService.getDataByDate(fromDate, toDate);
        } else if(userId != null && !userId.isEmpty()){
            return industryService.getDataByUserId(userId);
        }else {
            return industryService.getAllData();
        }

    }


}
