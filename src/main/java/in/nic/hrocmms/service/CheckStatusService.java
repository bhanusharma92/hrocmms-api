package in.nic.hrocmms.service;

import in.nic.hrocmms.database.ConnectionManager;
import in.nic.hrocmms.model.ApplicationDetailNew;

import javax.print.DocFlavor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class CheckStatusService {

    private Connection con;
    public List<ApplicationDetailNew> getData(String appNo, String applicationFor){
        List<ApplicationDetailNew> appList = new ArrayList<>();
        try{
            con = ConnectionManager.getConnection();
            ApplicationDetailNew applicationDetailNew;
            boolean isValid = false;
            String applicationNo = "";
            String dateOfIssue = "NA";
            String validUpTo = "NA";
            String fileNo = "NA";
            String link = "NA";
            String DateForm = "dd/MM/yyyy";
            SimpleDateFormat sdfh = new SimpleDateFormat(DateForm);

            if(appNo.equalsIgnoreCase(null) || appNo.equalsIgnoreCase("") || appNo.equalsIgnoreCase(" ")){
                System.out.println("appId null");
                applicationDetailNew = new ApplicationDetailNew("Please provide CTE Application No");
                appList.add(applicationDetailNew);
                return appList;
            }

            PreparedStatement preparedStatement = con.prepareStatement(
                    "SELECT application_id,date_of_issue, date_ofexpiry " +
                        " FROM all_summary_report  " +
                        " where application_id ='" + appNo + "' and application_status = 'approved' " +
                        " and application_type = '"+ applicationFor +"' order by id"
            );

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                isValid = true;
                applicationNo = resultSet.getString(1);
                if(!sdfh.format(resultSet.getTimestamp(2)).equals("01/01/1950")){
                    dateOfIssue = sdfh.format(resultSet.getTimestamp(2));
                }
                if(!sdfh.format(resultSet.getTimestamp(3)).equals("01/01/1950")){
                    validUpTo = sdfh.format(resultSet.getTimestamp(3));
                }
            }

            preparedStatement = con.prepareStatement(
                    "select * from application_file_record " +
                        "where ind_application_id = " + appNo + " " +
                        "and type_of_file IN ('CtoCertificate', 'DigiCommonCtoCertificate', " +
                        "'RefusalCertificateForBoth', 'DigiCommonCtoBothRefCertificate', 'CertificateForAir', 'CertificateForAirDegi', " +
                        "'CertificateForWater', 'CertificateForWaterDegi', 'CertificateForHwm', 'CertificateForHwmDegi', 'Certificate', " +
                        "'Certificate1') order by date_created desc LIMIT 1"
            );
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                link = ConnectionManager.rootUrl + "industryRegMaster/downloadCertificateApiEc/" + appNo;
            }

            if(isValid){
                applicationDetailNew = new ApplicationDetailNew(
                        applicationNo,
                        dateOfIssue,
                        validUpTo,
                        fileNo,
                        link
                );
            }else{
                applicationDetailNew = new ApplicationDetailNew("Please provide Valid "+ applicationFor +" Application No");
            }

            appList.add(applicationDetailNew);

        }catch(Exception e){
            e.printStackTrace();
        }finally {
            if(con != null) {
                try {
                    con.close();
                } catch(SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return appList;

    }

}

