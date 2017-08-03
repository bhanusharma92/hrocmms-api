package in.nic.hrocmms.service;


import in.nic.hrocmms.database.ConnectionManager;
import in.nic.hrocmms.model.Bmw;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;

public class BmwService {

    private Connection con;

    public List<Bmw> getAllData(String choice){

        List<Bmw> bmwList = new ArrayList<>();
        Date today = new Date();
        Calendar cal = new GregorianCalendar();
        cal.setTime(today);
        cal.add(Calendar.DAY_OF_MONTH, -120);
        Date today120 = cal.getTime();

        try{
            con = ConnectionManager.getConnection();
            Bmw bmw;
            switch (choice) {
                case "ra":

                    PreparedStatement bmwReceivedApplication = con.prepareStatement(
                            "SELECT basr.application_id, basr.application_name, dm.district_name, " +
                                    "irm.occ_name, basr.application_type, CAST(basr.application_receipt_date AS VARCHAR), " +
                                    "CASE " +
                                    "WHEN basr.application_Status = 'pending' THEN '' " +
                                    "ELSE CAST(basr.pending_since AS VARCHAR) "+
                                    "END, " +
                                    "basr.application_Status " +
                                    "FROM bmw_all_summary_report AS basr " +
                                    "LEFT JOIN district_master AS dm ON (basr.district_master_id = dm.id) " +
                                    "LEFT JOIN industry_reg_master AS irm ON (irm.id = basr.industry_reg_master_id) " +
                                    "WHERE basr.app_del = FALSE"

                    );

                    ResultSet bmwReceivedApplicationRs = bmwReceivedApplication.executeQuery();
                    while (bmwReceivedApplicationRs.next()) {
                        bmw = new Bmw(
                                String.valueOf(bmwReceivedApplicationRs.getLong(1)),
                                bmwReceivedApplicationRs.getString(2),
                                bmwReceivedApplicationRs.getString(3),
                                bmwReceivedApplicationRs.getString(4),
                                bmwReceivedApplicationRs.getString(5),
                                UtilityService.getFormattedDate(bmwReceivedApplicationRs.getString(6)),
                                UtilityService.getFormattedDateIfInputDateIsValid(bmwReceivedApplicationRs.getString(7),
                                        bmwReceivedApplicationRs.getString(8)),
                                bmwReceivedApplicationRs.getString(8)
                        );
                        bmwList.add(bmw);
                    }
                    break;
                case "gwt":
                    PreparedStatement bmwGwtApplication = con.prepareStatement(
                            "SELECT basr.application_id, basr.application_name, dm.district_name, " +
                                    "irm.occ_name, basr.application_type, CAST(basr.application_receipt_date AS VARCHAR), " +
                                    "CASE " +
                                    "WHEN basr.application_Status = 'pending' THEN '' " +
                                    "ELSE CAST(basr.pending_since AS VARCHAR) "+
                                    "END, " +
                                    "basr.application_Status " +
                                    "FROM bmw_all_summary_report AS basr " +
                                    "LEFT JOIN district_master AS dm ON (basr.district_master_id = dm.id) " +
                                    "LEFT JOIN industry_reg_master AS irm ON (irm.id = basr.industry_reg_master_id) " +
                                    "WHERE basr.app_del = FALSE AND " +
                                    "basr.application_status = 'approved' AND " +
                                    "basr.pending_since - basr.application_receipt_date <= '120 days'"
                    );

                    ResultSet bmwGwtRs = bmwGwtApplication.executeQuery();
                    while (bmwGwtRs.next()) {
                        bmw = new Bmw(
                                String.valueOf(bmwGwtRs.getLong(1)),
                                bmwGwtRs.getString(2),
                                bmwGwtRs.getString(3),
                                bmwGwtRs.getString(4),
                                bmwGwtRs.getString(5),
                                UtilityService.getFormattedDate(bmwGwtRs.getString(6)),
                                UtilityService.getFormattedDateIfInputDateIsValid(bmwGwtRs.getString(7),
                                        bmwGwtRs.getString(8)),
                                bmwGwtRs.getString(8)

                        );
                        bmwList.add(bmw);
                    }

                    break;
                case "gbt":
                    PreparedStatement bmwGbtApplication = con.prepareStatement(
                            "SELECT basr.application_id, basr.application_name, dm.district_name, " +
                                    "irm.occ_name, basr.application_type, CAST(basr.application_receipt_date AS VARCHAR), " +
                                    "CASE " +
                                    "WHEN basr.application_Status = 'pending' THEN '' " +
                                    "ELSE CAST(basr.pending_since AS VARCHAR) "+
                                    "END, " +
                                    "basr.application_Status " +
                                    "FROM bmw_all_summary_report AS basr " +
                                    "LEFT JOIN district_master AS dm ON (basr.district_master_id = dm.id) " +
                                    "LEFT JOIN industry_reg_master AS irm ON (irm.id = basr.industry_reg_master_id) " +
                                    "WHERE basr.app_del = FALSE AND " +
                                    "basr.application_status = 'approved' AND " +
                                    "basr.pending_since - basr.application_receipt_date > '120 days'"

                    );

                    ResultSet bmwGbtRs = bmwGbtApplication.executeQuery();
                    while (bmwGbtRs.next()) {
                        bmw = new Bmw(
                                String.valueOf(bmwGbtRs.getLong(1)),
                                bmwGbtRs.getString(2),
                                bmwGbtRs.getString(3),
                                bmwGbtRs.getString(4),
                                bmwGbtRs.getString(5),
                                UtilityService.getFormattedDate(bmwGbtRs.getString(6)),
                                UtilityService.getFormattedDateIfInputDateIsValid(bmwGbtRs.getString(7),
                                        bmwGbtRs.getString(8)),
                                bmwGbtRs.getString(8)

                        );
                        bmwList.add(bmw);
                    }

                    break;
                case "rwt":
                    PreparedStatement bmwRwtApplication = con.prepareStatement(
                            "SELECT basr.application_id, basr.application_name, dm.district_name, " +
                                    "irm.occ_name, basr.application_type, CAST(basr.application_receipt_date AS VARCHAR), " +
                                    "CASE " +
                                    "WHEN basr.application_Status = 'pending' THEN '' " +
                                    "ELSE CAST(basr.pending_since AS VARCHAR) "+
                                    "END, " +
                                    "basr.application_Status " +
                                    "FROM bmw_all_summary_report AS basr " +
                                    "LEFT JOIN district_master AS dm ON (basr.district_master_id = dm.id) " +
                                    "LEFT JOIN industry_reg_master AS irm ON (irm.id = basr.industry_reg_master_id) " +
                                    "WHERE basr.app_del = FALSE AND " +
                                    "basr.application_status = 'rejected' AND " +
                                    "basr.pending_since - basr.application_receipt_date <= '120 days'"

                    );

                    ResultSet bmwRwtRs = bmwRwtApplication.executeQuery();
                    while (bmwRwtRs.next()) {
                        bmw = new Bmw(
                                String.valueOf(bmwRwtRs.getLong(1)),
                                bmwRwtRs.getString(2),
                                bmwRwtRs.getString(3),
                                bmwRwtRs.getString(4),
                                bmwRwtRs.getString(5),
                                UtilityService.getFormattedDate(bmwRwtRs.getString(6)),
                                UtilityService.getFormattedDateIfInputDateIsValid(bmwRwtRs.getString(7),
                                        bmwRwtRs.getString(8)),
                                bmwRwtRs.getString(8)

                        );
                        bmwList.add(bmw);
                    }
                    break;
                case "rbt":
                    PreparedStatement bmwRbtApplication = con.prepareStatement(
                            "SELECT basr.application_id, basr.application_name, dm.district_name, " +
                                    "irm.occ_name, basr.application_type, CAST(basr.application_receipt_date AS VARCHAR), " +
                                    "CASE " +
                                    "WHEN basr.application_Status = 'pending' THEN '' " +
                                    "ELSE CAST(basr.pending_since AS VARCHAR) "+
                                    "END, " +
                                    "basr.application_Status " +
                                    "FROM bmw_all_summary_report AS basr " +
                                    "LEFT JOIN district_master AS dm ON (basr.district_master_id = dm.id) " +
                                    "LEFT JOIN industry_reg_master AS irm ON (irm.id = basr.industry_reg_master_id) " +
                                    "WHERE basr.app_del = FALSE AND " +
                                    "basr.application_status = 'rejected' AND " +
                                    "basr.pending_since - basr.application_receipt_date > '120 days'"

                    );

                    ResultSet bmwRbtRs = bmwRbtApplication.executeQuery();
                    while (bmwRbtRs.next()) {
                        bmw = new Bmw(
                                String.valueOf(bmwRbtRs.getLong(1)),
                                bmwRbtRs.getString(2),
                                bmwRbtRs.getString(3),
                                bmwRbtRs.getString(4),
                                bmwRbtRs.getString(5),
                                UtilityService.getFormattedDate(bmwRbtRs.getString(6)),
                                UtilityService.getFormattedDateIfInputDateIsValid(bmwRbtRs.getString(7),
                                        bmwRbtRs.getString(8)),
                                bmwRbtRs.getString(8)

                        );
                        bmwList.add(bmw);
                    }
                    break;
                case "pwt":
                    PreparedStatement bmwPwtApplication = con.prepareStatement(
                            "SELECT basr.application_id, basr.application_name, dm.district_name, " +
                                    "irm.occ_name, basr.application_type, CAST(basr.application_receipt_date AS VARCHAR), " +
                                    "CASE " +
                                    "WHEN basr.application_Status = 'pending' THEN '' " +
                                    "ELSE CAST(basr.pending_since AS VARCHAR) "+
                                    "END, " +
                                    "basr.application_Status " +
                                    "FROM bmw_all_summary_report AS basr " +
                                    "LEFT JOIN district_master AS dm ON (basr.district_master_id = dm.id) " +
                                    "LEFT JOIN industry_reg_master AS irm ON (irm.id = basr.industry_reg_master_id) " +
                                    "WHERE basr.app_del = FALSE AND " +
                                    "basr.application_status = 'pending' AND " +
                                    "basr.application_receipt_date >= ? AND basr.application_receipt_date <= ?"

                    );
                    bmwPwtApplication.setTimestamp(1, new java.sql.Timestamp(today120.getTime()));
                    bmwPwtApplication.setTimestamp(2, new java.sql.Timestamp(today.getTime()));

                    ResultSet bmwPwtRs = bmwPwtApplication.executeQuery();
                    while (bmwPwtRs.next()) {
                        bmw = new Bmw(
                                String.valueOf(bmwPwtRs.getLong(1)),
                                bmwPwtRs.getString(2),
                                bmwPwtRs.getString(3),
                                bmwPwtRs.getString(4),
                                bmwPwtRs.getString(5),
                                UtilityService.getFormattedDate(bmwPwtRs.getString(6)),
                                UtilityService.getFormattedDateIfInputDateIsValid(bmwPwtRs.getString(7),
                                        bmwPwtRs.getString(8)),
                                bmwPwtRs.getString(8)

                        );
                        bmwList.add(bmw);
                    }

                    break;
                case "pbt":
                    PreparedStatement bmwPbtApplication = con.prepareStatement(
                            "SELECT basr.application_id, basr.application_name, dm.district_name, " +
                                    "irm.occ_name, basr.application_type, CAST(basr.application_receipt_date AS VARCHAR), " +
                                    "CASE " +
                                    "WHEN basr.application_Status = 'pending' THEN '' " +
                                    "ELSE CAST(basr.pending_since AS VARCHAR) "+
                                    "END, " +
                                    "basr.application_Status " +
                                    "FROM bmw_all_summary_report AS basr " +
                                    "LEFT JOIN district_master AS dm ON (basr.district_master_id = dm.id) " +
                                    "LEFT JOIN industry_reg_master AS irm ON (irm.id = basr.industry_reg_master_id) " +
                                    "WHERE basr.app_del = FALSE AND " +
                                    "basr.application_status = 'pending' AND " +
                                    "basr.application_receipt_date < ?"

                    );
                    bmwPbtApplication.setTimestamp(1, new java.sql.Timestamp(today120.getTime()));

                    ResultSet bmwPbtRs = bmwPbtApplication.executeQuery();
                    while (bmwPbtRs.next()) {
                        bmw = new Bmw(
                                String.valueOf(bmwPbtRs.getLong(1)),
                                bmwPbtRs.getString(2),
                                bmwPbtRs.getString(3),
                                bmwPbtRs.getString(4),
                                bmwPbtRs.getString(5),
                                UtilityService.getFormattedDate(bmwPbtRs.getString(6)),
                                UtilityService.getFormattedDateIfInputDateIsValid(bmwPbtRs.getString(7),
                                        bmwPbtRs.getString(8)),
                                bmwPbtRs.getString(8)

                        );
                        bmwList.add(bmw);
                    }
                    break;
            }

        } catch(Exception e){
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

        return bmwList;

    }

    public List<Bmw> getFilteredData(String fromDateStr, String toDateStr, String choice){
        List<Bmw> bmwList = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date today = new Date();
        Calendar cal = new GregorianCalendar();
        cal.setTime(today);
        cal.add(Calendar.DAY_OF_MONTH, -120);
        Date today120 = cal.getTime();
        Date fromDate;
        Date toDate;
        try{
            fromDate = sdf.parse(fromDateStr);
            toDate = sdf.parse(toDateStr);
        } catch (Exception e){
            e.printStackTrace();
            return new ArrayList<>();
        }

        try{
            con = ConnectionManager.getConnection();
            Bmw bmw;
            switch (choice) {
                case "ra":

                    PreparedStatement bmwReceivedApplication = con.prepareStatement(
                            "SELECT basr.application_id, basr.application_name, dm.district_name, " +
                                    "irm.occ_name, basr.application_type, CAST(basr.application_receipt_date AS VARCHAR), " +
                                    "CASE " +
                                    "WHEN basr.application_Status = 'pending' THEN '' " +
                                    "ELSE CAST(basr.pending_since AS VARCHAR) "+
                                    "END, " +
                                    "basr.application_Status " +
                                    "FROM bmw_all_summary_report AS basr " +
                                    "LEFT JOIN district_master AS dm ON (basr.district_master_id = dm.id) " +
                                    "LEFT JOIN industry_reg_master AS irm ON (irm.id = basr.industry_reg_master_id) " +
                                    "WHERE basr.app_del = FALSE AND " +
                                    "basr.application_receipt_date >= ? AND basr.application_receipt_date <= ?"

                    );
                    bmwReceivedApplication.setTimestamp(1, new java.sql.Timestamp(fromDate.getTime()));
                    bmwReceivedApplication.setTimestamp(2, new java.sql.Timestamp(toDate.getTime()));

                    ResultSet bmwReceivedApplicationRs = bmwReceivedApplication.executeQuery();
                    while (bmwReceivedApplicationRs.next()) {
                        bmw = new Bmw(
                                String.valueOf(bmwReceivedApplicationRs.getLong(1)),
                                bmwReceivedApplicationRs.getString(2),
                                bmwReceivedApplicationRs.getString(3),
                                bmwReceivedApplicationRs.getString(4),
                                bmwReceivedApplicationRs.getString(5),
                                UtilityService.getFormattedDate(bmwReceivedApplicationRs.getString(6)),
                                UtilityService.getFormattedDateIfInputDateIsValid(bmwReceivedApplicationRs.getString(7),
                                        bmwReceivedApplicationRs.getString(8)),
                                bmwReceivedApplicationRs.getString(8)
                        );
                        bmwList.add(bmw);
                    }
                    break;
                case "gwt":
                    PreparedStatement bmwGwtApplication = con.prepareStatement(
                            "SELECT basr.application_id, basr.application_name, dm.district_name, " +
                                    "irm.occ_name, basr.application_type, CAST(basr.application_receipt_date AS VARCHAR), " +
                                    "CASE " +
                                    "WHEN basr.application_Status = 'pending' THEN '' " +
                                    "ELSE CAST(basr.pending_since AS VARCHAR) "+
                                    "END, " +
                                    "basr.application_Status " +
                                    "FROM bmw_all_summary_report AS basr " +
                                    "LEFT JOIN district_master AS dm ON (basr.district_master_id = dm.id) " +
                                    "LEFT JOIN industry_reg_master AS irm ON (irm.id = basr.industry_reg_master_id) " +
                                    "WHERE basr.app_del = FALSE AND " +
                                    "basr.application_status = 'approved' AND " +
                                    "basr.pending_since - basr.application_receipt_date <= '120 days' AND " +
                                    "basr.application_receipt_date >= ? AND basr.application_receipt_date <= ?"
                    );
                    bmwGwtApplication.setTimestamp(1, new java.sql.Timestamp(fromDate.getTime()));
                    bmwGwtApplication.setTimestamp(2, new java.sql.Timestamp(toDate.getTime()));

                    ResultSet bmwGwtRs = bmwGwtApplication.executeQuery();
                    while (bmwGwtRs.next()) {
                        bmw = new Bmw(
                                String.valueOf(bmwGwtRs.getLong(1)),
                                bmwGwtRs.getString(2),
                                bmwGwtRs.getString(3),
                                bmwGwtRs.getString(4),
                                bmwGwtRs.getString(5),
                                UtilityService.getFormattedDate(bmwGwtRs.getString(6)),
                                UtilityService.getFormattedDateIfInputDateIsValid(bmwGwtRs.getString(7),
                                        bmwGwtRs.getString(8)),
                                bmwGwtRs.getString(8)

                        );
                        bmwList.add(bmw);
                    }

                    break;
                case "gbt":
                    PreparedStatement bmwGbtApplication = con.prepareStatement(
                            "SELECT basr.application_id, basr.application_name, dm.district_name, " +
                                    "irm.occ_name, basr.application_type, CAST(basr.application_receipt_date AS VARCHAR), " +
                                    "CASE " +
                                    "WHEN basr.application_Status = 'pending' THEN '' " +
                                    "ELSE CAST(basr.pending_since AS VARCHAR) "+
                                    "END, " +
                                    "basr.application_Status " +
                                    "FROM bmw_all_summary_report AS basr " +
                                    "LEFT JOIN district_master AS dm ON (basr.district_master_id = dm.id) " +
                                    "LEFT JOIN industry_reg_master AS irm ON (irm.id = basr.industry_reg_master_id) " +
                                    "WHERE basr.app_del = FALSE AND " +
                                    "basr.application_status = 'approved' AND " +
                                    "basr.pending_since - basr.application_receipt_date > '120 days' AND " +
                                    "basr.application_receipt_date >= ? AND basr.application_receipt_date <= ?"

                    );
                    bmwGbtApplication.setTimestamp(1, new java.sql.Timestamp(fromDate.getTime()));
                    bmwGbtApplication.setTimestamp(2, new java.sql.Timestamp(toDate.getTime()));

                    ResultSet bmwGbtRs = bmwGbtApplication.executeQuery();
                    while (bmwGbtRs.next()) {
                        bmw = new Bmw(
                                String.valueOf(bmwGbtRs.getLong(1)),
                                bmwGbtRs.getString(2),
                                bmwGbtRs.getString(3),
                                bmwGbtRs.getString(4),
                                bmwGbtRs.getString(5),
                                UtilityService.getFormattedDate(bmwGbtRs.getString(6)),
                                UtilityService.getFormattedDateIfInputDateIsValid(bmwGbtRs.getString(7),
                                        bmwGbtRs.getString(8)),
                                bmwGbtRs.getString(8)

                        );
                        bmwList.add(bmw);
                    }

                    break;
                case "rwt":
                    PreparedStatement bmwRwtApplication = con.prepareStatement(
                            "SELECT basr.application_id, basr.application_name, dm.district_name, " +
                                    "irm.occ_name, basr.application_type, CAST(basr.application_receipt_date AS VARCHAR), " +
                                    "CASE " +
                                    "WHEN basr.application_Status = 'pending' THEN '' " +
                                    "ELSE CAST(basr.pending_since AS VARCHAR) "+
                                    "END, " +
                                    "basr.application_Status " +
                                    "FROM bmw_all_summary_report AS basr " +
                                    "LEFT JOIN district_master AS dm ON (basr.district_master_id = dm.id) " +
                                    "LEFT JOIN industry_reg_master AS irm ON (irm.id = basr.industry_reg_master_id) " +
                                    "WHERE basr.app_del = FALSE AND " +
                                    "basr.application_status = 'rejected' AND " +
                                    "basr.pending_since - basr.application_receipt_date <= '120 days' AND " +
                                    "basr.application_receipt_date >= ? AND basr.application_receipt_date <= ?"

                    );
                    bmwRwtApplication.setTimestamp(1, new java.sql.Timestamp(fromDate.getTime()));
                    bmwRwtApplication.setTimestamp(2, new java.sql.Timestamp(toDate.getTime()));

                    ResultSet bmwRwtRs = bmwRwtApplication.executeQuery();
                    while (bmwRwtRs.next()) {
                        bmw = new Bmw(
                                String.valueOf(bmwRwtRs.getLong(1)),
                                bmwRwtRs.getString(2),
                                bmwRwtRs.getString(3),
                                bmwRwtRs.getString(4),
                                bmwRwtRs.getString(5),
                                UtilityService.getFormattedDate(bmwRwtRs.getString(6)),
                                UtilityService.getFormattedDateIfInputDateIsValid(bmwRwtRs.getString(7),
                                        bmwRwtRs.getString(8)),
                                bmwRwtRs.getString(8)

                        );
                        bmwList.add(bmw);
                    }
                    break;
                case "rbt":
                    PreparedStatement bmwRbtApplication = con.prepareStatement(
                            "SELECT basr.application_id, basr.application_name, dm.district_name, " +
                                    "irm.occ_name, basr.application_type, CAST(basr.application_receipt_date AS VARCHAR), " +
                                    "CASE " +
                                    "WHEN basr.application_Status = 'pending' THEN '' " +
                                    "ELSE CAST(basr.pending_since AS VARCHAR) "+
                                    "END, " +
                                    "basr.application_Status " +
                                    "FROM bmw_all_summary_report AS basr " +
                                    "LEFT JOIN district_master AS dm ON (basr.district_master_id = dm.id) " +
                                    "LEFT JOIN industry_reg_master AS irm ON (irm.id = basr.industry_reg_master_id) " +
                                    "WHERE basr.app_del = FALSE AND " +
                                    "basr.application_status = 'rejected' AND " +
                                    "basr.pending_since - basr.application_receipt_date > '120 days' AND " +
                                    "basr.application_receipt_date >= ? AND basr.application_receipt_date <= ?"

                    );
                    bmwRbtApplication.setTimestamp(1, new java.sql.Timestamp(fromDate.getTime()));
                    bmwRbtApplication.setTimestamp(2, new java.sql.Timestamp(toDate.getTime()));

                    ResultSet bmwRbtRs = bmwRbtApplication.executeQuery();
                    while (bmwRbtRs.next()) {
                        bmw = new Bmw(
                                String.valueOf(bmwRbtRs.getLong(1)),
                                bmwRbtRs.getString(2),
                                bmwRbtRs.getString(3),
                                bmwRbtRs.getString(4),
                                bmwRbtRs.getString(5),
                                UtilityService.getFormattedDate(bmwRbtRs.getString(6)),
                                UtilityService.getFormattedDateIfInputDateIsValid(bmwRbtRs.getString(7),
                                        bmwRbtRs.getString(8)),
                                bmwRbtRs.getString(8)

                        );
                        bmwList.add(bmw);
                    }
                    break;
                case "pwt":
                    PreparedStatement bmwPwtApplication = con.prepareStatement(
                            "SELECT basr.application_id, basr.application_name, dm.district_name, " +
                                    "irm.occ_name, basr.application_type, CAST(basr.application_receipt_date AS VARCHAR), " +
                                    "CASE " +
                                    "WHEN basr.application_Status = 'pending' THEN '' " +
                                    "ELSE CAST(basr.pending_since AS VARCHAR) "+
                                    "END, " +
                                    "basr.application_Status " +
                                    "FROM bmw_all_summary_report AS basr " +
                                    "LEFT JOIN district_master AS dm ON (basr.district_master_id = dm.id) " +
                                    "LEFT JOIN industry_reg_master AS irm ON (irm.id = basr.industry_reg_master_id) " +
                                    "WHERE basr.app_del = FALSE AND " +
                                    "basr.application_status = 'pending' AND " +
                                    "basr.application_receipt_date >= ? AND basr.application_receipt_date <= ? AND " +
                                    "basr.application_receipt_date >= ? AND basr.application_receipt_date <= ?"

                    );
                    bmwPwtApplication.setTimestamp(1, new java.sql.Timestamp(today120.getTime()));
                    bmwPwtApplication.setTimestamp(2, new java.sql.Timestamp(today.getTime()));
                    bmwPwtApplication.setTimestamp(3, new java.sql.Timestamp(fromDate.getTime()));
                    bmwPwtApplication.setTimestamp(4, new java.sql.Timestamp(toDate.getTime()));

                    ResultSet bmwPwtRs = bmwPwtApplication.executeQuery();
                    while (bmwPwtRs.next()) {
                        bmw = new Bmw(
                                String.valueOf(bmwPwtRs.getLong(1)),
                                bmwPwtRs.getString(2),
                                bmwPwtRs.getString(3),
                                bmwPwtRs.getString(4),
                                bmwPwtRs.getString(5),
                                UtilityService.getFormattedDate(bmwPwtRs.getString(6)),
                                UtilityService.getFormattedDateIfInputDateIsValid(bmwPwtRs.getString(7),
                                        bmwPwtRs.getString(8)),
                                bmwPwtRs.getString(8)

                        );
                        bmwList.add(bmw);
                    }

                    break;
                case "pbt":
                    PreparedStatement bmwPbtApplication = con.prepareStatement(
                            "SELECT basr.application_id, basr.application_name, dm.district_name, " +
                                    "irm.occ_name, basr.application_type, CAST(basr.application_receipt_date AS VARCHAR), " +
                                    "CASE " +
                                    "WHEN basr.application_Status = 'pending' THEN '' " +
                                    "ELSE CAST(basr.pending_since AS VARCHAR) "+
                                    "END, " +
                                    "basr.application_Status " +
                                    "FROM bmw_all_summary_report AS basr " +
                                    "LEFT JOIN district_master AS dm ON (basr.district_master_id = dm.id) " +
                                    "LEFT JOIN industry_reg_master AS irm ON (irm.id = basr.industry_reg_master_id) " +
                                    "WHERE basr.app_del = FALSE AND " +
                                    "basr.application_status = 'pending' AND " +
                                    "basr.application_receipt_date < ? AND " +
                                    "basr.application_receipt_date >= ? AND basr.application_receipt_date <= ?"

                    );
                    bmwPbtApplication.setTimestamp(1, new java.sql.Timestamp(today120.getTime()));
                    bmwPbtApplication.setTimestamp(2, new java.sql.Timestamp(fromDate.getTime()));
                    bmwPbtApplication.setTimestamp(3, new java.sql.Timestamp(toDate.getTime()));
                    ResultSet bmwPbtRs = bmwPbtApplication.executeQuery();
                    while (bmwPbtRs.next()) {
                        bmw = new Bmw(
                                String.valueOf(bmwPbtRs.getLong(1)),
                                bmwPbtRs.getString(2),
                                bmwPbtRs.getString(3),
                                bmwPbtRs.getString(4),
                                bmwPbtRs.getString(5),
                                UtilityService.getFormattedDate(bmwPbtRs.getString(6)),
                                UtilityService.getFormattedDateIfInputDateIsValid(bmwPbtRs.getString(7),
                                        bmwPbtRs.getString(8)),
                                bmwPbtRs.getString(8)

                        );
                        bmwList.add(bmw);
                    }
                    break;
            }

        } catch(Exception e){
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

        return bmwList;
    }
}
