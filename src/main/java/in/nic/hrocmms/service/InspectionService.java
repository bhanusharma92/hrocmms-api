package in.nic.hrocmms.service;

import in.nic.hrocmms.database.ConnectionManager;
import in.nic.hrocmms.model.Inspection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InspectionService {

    private Connection con;

    public List<Inspection> getAllData(){
        List<Inspection> inspectionList = new ArrayList<>();
        con = ConnectionManager.getConnection();
        Inspection inspection;
        try{
            PreparedStatement inspectionPs = con.prepareStatement(
                    "SELECT iad.ind_user_universal_id, " +
                        "CASE WHEN CAST(rir.month AS INTEGER) < 10 THEN " +
                        "concat_ws('-','0'||cast(rir.month AS VARCHAR),rir.year)" +
                        "ELSE concat_ws('-', rir.month, rir.year) END, " +
                        "up.id, concat_ws(' ', TRIM(up.employee_first_name), TRIM(up.employee_last_name)), " +
                        "up.mobile, up.email, up.designation, iu.id " +
                        "FROM regular_inspection_raised AS rir " +
                        "LEFT JOIN ind_application_details AS iad ON iad.id = rir.application_id " +
                        "LEFT JOIN ind_user AS iu ON iad.ind_user_universal_id = iu.industry_reg_master_id " +
                        "LEFT JOIN user_profile AS up ON TRIM(up.id) = TRIM(rir.officer_id)"
            );
            ResultSet inspectionRs = inspectionPs.executeQuery();
            while (inspectionRs.next()) {
                inspection = new Inspection(
                        inspectionRs.getString(1),
                        inspectionRs.getString(2),
                        inspectionRs.getString(3),
                        inspectionRs.getString(4),
                        inspectionRs.getString(5),
                        inspectionRs.getString(6),
                        inspectionRs.getString(7),
                        inspectionRs.getString(8)
                );
                inspectionList.add(inspection);
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

        return inspectionList;
    }

    public List<Inspection> getFilteredData(String fromDateStr, String toDateStr){
        List<Inspection> inspectionList = new ArrayList<>();
        con = ConnectionManager.getConnection();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Inspection inspection;
        Date fromDate;
        Date toDate;
        int day1 = 1;
        int day28 = 28;
        int month;
        int year;
        try{
            fromDate = sdf.parse(fromDateStr);
            toDate = sdf.parse(toDateStr);
        } catch (Exception e){
            e.printStackTrace();
            return new ArrayList<>();
        }
        try{
            PreparedStatement inspectionPs = con.prepareStatement(
                    "SELECT iad.ind_user_universal_id, " +
                        "CASE WHEN CAST(rir.month AS INTEGER) < 10 THEN " +
                        "concat_ws('-','0'||cast(rir.month AS VARCHAR), " +
                        "CASE WHEN CAST(rir.year AS INTEGER) < 100 THEN " +
                        "CAST('20' || rir.year AS VARCHAR) ELSE " +
                        "CAST (rir.year AS VARCHAR) END) " +
                        "ELSE concat_ws('-', rir.month, rir.year) END, " +
                        "up.id, concat_ws(' ', TRIM(up.employee_first_name), TRIM(up.employee_last_name)), " +
                        "up.mobile, up.email, up.designation, iu.id " +
                        "FROM regular_inspection_raised AS rir " +
                        "LEFT JOIN ind_application_details AS iad ON iad.id = rir.application_id " +
                        "LEFT JOIN ind_user AS iu ON iad.ind_user_universal_id = iu.industry_reg_master_id " +
                        "LEFT JOIN user_profile AS up ON TRIM(up.id) = TRIM(rir.officer_id) " +
                        "WHERE format('%s-%s-%s', " +
                        "CASE WHEN CAST(rir.year AS INTEGER) < 100 THEN  " +
                        "CAST(CAST('20' || rir.year AS VARCHAR) AS INTEGER) ELSE " +
                        "CAST (rir.year AS INTEGER) END, " +
                        "CASE WHEN CAST(rir.month AS INTEGER) < 10 THEN " +
                        "CAST('0'||cast(rir.month AS VARCHAR) AS INTEGER)" +
                        "ELSE CAST(rir.month AS INTEGER) END, " +
                        " 15)::date >= ? AND format('%s-%s-%s', " +
                        "CASE WHEN CAST(rir.year AS INTEGER) < 100 THEN  " +
                        "CAST(CAST('20' || rir.year AS VARCHAR) AS INTEGER) ELSE " +
                        "CAST (rir.year AS INTEGER) END, " +
                        "CASE WHEN CAST(rir.month AS INTEGER) < 10 THEN " +
                        "CAST('0'||cast(rir.month AS VARCHAR) AS INTEGER)" +
                        "ELSE CAST(rir.month AS INTEGER) END, " +
                        "15)::date <= ?"
            );
            inspectionPs.setTimestamp(1, new java.sql.Timestamp(fromDate.getTime()));
            inspectionPs.setTimestamp(2, new java.sql.Timestamp(toDate.getTime()));
            ResultSet inspectionRs = inspectionPs.executeQuery();
            while (inspectionRs.next()) {
                inspection = new Inspection(
                        inspectionRs.getString(1),
                        inspectionRs.getString(2),
                        inspectionRs.getString(3),
                        inspectionRs.getString(4),
                        inspectionRs.getString(5),
                        inspectionRs.getString(6),
                        inspectionRs.getString(7),
                        inspectionRs.getString(8)
                );
                inspectionList.add(inspection);
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

        return inspectionList;
    }

}
