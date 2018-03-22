package in.nic.hrocmms.resources;

import in.nic.hrocmms.model.WasteTrack;
import in.nic.hrocmms.service.WasteTrackService;

import javax.ws.rs.*;
import java.util.List;

@Path("waste/{vehicleNo}")
public class WasteTrackResource {

    private WasteTrackService wasteTrackService = new WasteTrackService();

    @GET
    @Produces
    public List<WasteTrack> getData(
            @PathParam("vehicleNo") String vehicleNo
    ){
        return wasteTrackService.getData(vehicleNo);
    }

}
