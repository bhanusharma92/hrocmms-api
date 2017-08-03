package in.nic.hrocmms.resources;

import in.nic.hrocmms.model.Count;
import in.nic.hrocmms.service.CountService;
import in.nic.hrocmms.service.UtilityService;

import javax.print.DocFlavor;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Path("count")
public class CountResource {

    private CountService countService = new CountService();



    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<Count> getCount(
            @QueryParam("fromDate") String fromDate,
            @QueryParam("toDate") String toDate

    ){
        /*ArrayList<Count> testList = new ArrayList<>();
        testList.add(new Count());
        testList.add(new Count());
        return testList;*/
        boolean isValidDateSupplied = UtilityService.validDateSuppliedCheck(fromDate, toDate);

        if(isValidDateSupplied){
            return countService.getAllCountDate(fromDate, toDate);
        }else{
            return countService.getAllCount();
        }



    }



}
