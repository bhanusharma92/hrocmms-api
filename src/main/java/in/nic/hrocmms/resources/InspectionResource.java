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

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    // @Consumes(MediaType.MULTIPART_FORM_DATA)
    public List<Inspection> getData(
            @FormParam("fromDate") String fromDate,
            @FormParam("toDate") String toDate
    ){
        boolean isValidDateSupplied = UtilityService.validDateSuppliedCheck(fromDate, toDate);
        if(isValidDateSupplied){
            return inspectionService.getFilteredData(fromDate, toDate);
        }else{
            return inspectionService.getAllData();
        }
    }
}