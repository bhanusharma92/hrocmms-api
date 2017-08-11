package in.nic.hrocmms.service;

import in.nic.hrocmms.database.ConnectionManager;
import in.nic.hrocmms.model.Officer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OfficerService {

    private Connection con;

    public List<Officer> getAllData(){
        List<Officer> officerList = new ArrayList<>();
        con = ConnectionManager.getConnection();
        Officer officer;
        try{
            PreparedStatement officerPs = con.prepareStatement(
                    "SELECT up.id, concat_ws('',up.employee_first_name,up.employee_last_name), " +
                        "up.email, up.mobile, up.designation " +
                        "FROM user_profile AS up " +
                        "WHERE up.status = 'active';"
            );
            ResultSet officerRs = officerPs.executeQuery();
            while (officerRs.next()) {
                officer = new Officer(
                        officerRs.getString(1),
                        officerRs.getString(2),
                        officerRs.getString(3),
                        officerRs.getString(4),
                        officerRs.getString(5)
                );
                officerList.add(officer);
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

        return officerList;
    }

    public List<Officer> getDataByUserId(String userId){
        List<Officer> officerList = new ArrayList<>();
        con = ConnectionManager.getConnection();
        Officer officer;
        try{
            PreparedStatement officerPs = con.prepareStatement(
                    "SELECT up.id, concat_ws('',up.employee_first_name,up.employee_last_name), " +
                            "up.email, up.mobile, up.designation " +
                            "FROM user_profile AS up " +
                            "WHERE up.status = 'active' AND " +
                            "up.id = ?"
            );
            officerPs.setString(1, userId);
            ResultSet officerRs = officerPs.executeQuery();
            while (officerRs.next()) {
                officer = new Officer(
                        officerRs.getString(1),
                        officerRs.getString(2),
                        officerRs.getString(3),
                        officerRs.getString(4),
                        officerRs.getString(5)
                );
                officerList.add(officer);
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

        return officerList;
    }
}
