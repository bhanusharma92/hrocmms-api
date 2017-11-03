package in.nic.hrocmms.resources;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;



@Path("test")
public class TestResource {

    // private TestService testService = new TestService();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getData(String json){
        System.out.println(json);
        return Response.ok().build();
    }
}
