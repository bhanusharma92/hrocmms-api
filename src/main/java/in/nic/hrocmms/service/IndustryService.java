package in.nic.hrocmms.service;

import in.nic.hrocmms.database.ConnectionManager;
import in.nic.hrocmms.model.Industry;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IndustryService {

    private Connection con;

    public List<Industry> getAllData(){
        List<Industry> industryList = new ArrayList<>();
        con = ConnectionManager.getConnection();
        Industry industry;
        try{
            PreparedStatement industryPs = con.prepareStatement(
                    ""
            );
            ResultSet industryRs = industryPs.executeQuery();
            while (industryRs.next()) {
                industry = new Industry(
                        industryRs.getString(1),
                        industryRs.getString(2),
                        industryRs.getString(3),
                        industryRs.getString(4),
                        industryRs.getString(5),
                        industryRs.getString(6),
                        industryRs.getString(7),
                        industryRs.getString(8),
                        industryRs.getString(9),
                        industryRs.getString(10),
                        industryRs.getString(11),
                        industryRs.getString(12),
                        industryRs.getString(13)
                );
                industryList.add(industry);
            }
        }catch (Exception e){
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

        return industryList;
    }
}
