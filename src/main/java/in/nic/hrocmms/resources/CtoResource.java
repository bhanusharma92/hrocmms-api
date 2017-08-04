package in.nic.hrocmms.resources;

import in.nic.hrocmms.model.Cto;
import in.nic.hrocmms.service.CtoService;
import in.nic.hrocmms.service.UtilityService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("cto")
public class CtoResource {

    private CtoService ctoService = new CtoService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Cto> getData(
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
            return ctoService.getFilteredData(fromDate, toDate, choice);
        }else{
            return ctoService.getAllData(choice);
        }
    }
}
