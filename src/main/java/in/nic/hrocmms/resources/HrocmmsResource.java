package in.nic.hrocmms.resources;


import in.nic.hrocmms.database.ConnectionManager;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import java.net.URLEncoder;

@Path("hrocmms")
public class HrocmmsResource {


    @GET
    @Path("login")
    public Response login(
            @QueryParam("uname") String name,
            @QueryParam("indDistrict") String indDistrict,
            @QueryParam("address") String address,
            @QueryParam("firstName") String firstName,
            @QueryParam("lastName") String lastName,
            @QueryParam("useremail") String email_address,
            @QueryParam("mobile") String mobile_no,
            @QueryParam("industry_pin_code") String industry_pin_code,
            @QueryParam("industry_telephone_no") String industry_telephone_no,
            @QueryParam("projectid") String caf_unique_no,
            @QueryParam("ip") String ip,
            @QueryParam("cat_type") String cat_type,
            @QueryParam("serviceid") String serviceid,
            @QueryParam("projectserviceid") String projectserviceid

    ){
        if(name == null){
            name = "";
        }
        if(indDistrict == null){
            indDistrict = "";
        }
        if(address == null){
            address = "";
        }
        if(firstName == null){
            firstName = "";
        }
        if(lastName == null){
            lastName = "";
        }
        if(email_address == null){
            email_address = "";
        }
        if(mobile_no == null){
            mobile_no = "";
        }
        if(industry_pin_code == null){
            industry_pin_code = "";
        }
        if(industry_telephone_no == null){
            industry_telephone_no = "";
        }
        if(caf_unique_no == null){
            caf_unique_no = "";
        }
        if(ip == null){
            ip = "";
        }
        if(cat_type == null){
            cat_type = "";
        }
        if(serviceid == null){
            serviceid = "";
        }
        if(projectserviceid == null){
            projectserviceid = "";
        }
        try{

            System.out.println("cat_type: " + cat_type);
            System.out.println("name: " + name);
            System.out.println("email_address: " + email_address);
            System.out.println("mobile_no: " + mobile_no);
            System.out.println("caf_unique_no: " + caf_unique_no);

            java.net.URI location = new java.net.URI( ConnectionManager.rootUrl + "industryRegMaster/doLoginApi?" +
                    "name=" + name + "&" +
                    "indDistrict=" + indDistrict  + "&" +
                    "address=" + address + "&" +
                    "firstName=" + firstName + "&" +
                    "lastName=" + lastName + "&" +
                    "email_address=" + email_address + "&" +
                    "mobile_no=" + mobile_no + "&" +
                    "industry_pin_code=" + industry_pin_code + "&" +
                    "industry_telephone_no=" + industry_telephone_no + "&" +
                    "caf_unique_no=" + caf_unique_no + "&" +
                    "ip=" + ip + "&" +
                    "cat_type=" + cat_type + "&" +
                    "serviceid=" + serviceid + "&" +
                    "projectserviceid=" + projectserviceid

            );
            return Response.temporaryRedirect(location).build();
        }catch (Exception ex){
            System.out.println("Exception");
            System.out.println(ex);
            System.out.println("Exception ends");
        }
        return Response.noContent().build();
    }

    @GET
    @Path("downloadCertificate")
    public Response downloadCertificate(
            @QueryParam("projectid") String projectid,
            @QueryParam("serviceid") String serviceid
    ){
        try{
            java.net.URI location = new java.net.URI(ConnectionManager.rootUrl + "industryRegMaster/downloadCertificateApi?" +
                    "projectid=" + projectid + "&" +
                    "serviceid=" + serviceid

            );
            return Response.temporaryRedirect(location).build();
        }catch(Exception e){
            System.out.println("\nException in HrocmmsResource.java -> downloadCertificate");
            System.out.println("e: ");
            System.out.println(e+"\n");
        }
        return Response.noContent().build();
    }

}
