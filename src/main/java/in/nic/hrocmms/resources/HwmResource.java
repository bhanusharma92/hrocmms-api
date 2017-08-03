package in.nic.hrocmms.resources;

import in.nic.hrocmms.model.Cto;
import in.nic.hrocmms.model.Hwm;
import in.nic.hrocmms.service.HwmService;
import in.nic.hrocmms.service.UtilityService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("hwm")
public class HwmResource {

    private HwmService hwmService = new HwmService();

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<Hwm> getData(
            @QueryParam("fromDate") String fromDate,
            @QueryParam("toDate") String toDate,
            @QueryParam("ra") String ra,
            @QueryParam("gwt") String gwt,
            @QueryParam("gbt") String gbt,
            @QueryParam("rwt") String rwt,
            @QueryParam("rbt") String rbt,
            @QueryParam("pwt") String pwt,
            @QueryParam("pbt") String pbt
    ){
        boolean isValidDateSupplied = UtilityService.validDateSuppliedCheck(fromDate, toDate);
        String choice = UtilityService.getChoice(ra, gwt, gbt, rwt, rbt, pwt, pbt);
        if(isValidDateSupplied){
            return hwmService.getFilteredData(fromDate, toDate, choice);
        }else{
            return hwmService.getAllData(choice);
        }
    }
}
