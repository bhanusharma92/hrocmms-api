package in.nic.hrocmms.resources;

import in.nic.hrocmms.model.Inspection;
import in.nic.hrocmms.service.InspectionService;
import in.nic.hrocmms.service.UtilityService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("inspection")
public class InspectionResource {
    private InspectionService inspectionService = new InspectionService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Inspection> getData(
            @QueryParam("fromDate") String fromDate,
            @QueryParam("toDate") String toDate
    ){

        boolean isValidDateSupplied = UtilityService.validDateSuppliedCheck(fromDate, toDate);
        if(isValidDateSupplied){
            return inspectionService.getFilteredData(fromDate, toDate);
        }else{
            return inspectionService.getAllData();
        }
    }


}
