package in.nic.hrocmms.service;


import in.nic.hrocmms.database.ConnectionManager;
import in.nic.hrocmms.model.Cto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;

public class CtoService {
    private Connection con;

    public List<Cto> getAllData(String choice){

        List<Cto> ctoList = new ArrayList<>();
        Date today = new Date();
        Calendar cal = new GregorianCalendar();
        cal.setTime(today);
        cal.add(Calendar.DAY_OF_MONTH, -120);
        Date today120 = cal.getTime();

        try{
            con = ConnectionManager.getConnection();
            Cto cto;
            switch (choice) {
                case "ra":

                    PreparedStatement ctoReceivedApplication = con.prepareStatement(
                            "SELECT asr.application_id, asr.application_name, dm.district_name, irm.occ_name, asr.application_type, " +
                                    "CAST(asr.application_reciept_date AS VARCHAR), " +
                                    "CASE WHEN asr.application_status = 'pending' THEN '' " +
                                    "ELSE CAST(asr.pending_since AS VARCHAR) " +
                                    "END, asr.application_status " +
                                    "FROM all_summary_report as asr " +
                                    "LEFT JOIN industry_reg_master AS irm ON (CAST(irm.id AS VARCHAR) = asr.ind_reg_master_id) " +
                                    "LEFT JOIN district_master AS dm ON irm.district_id = dm.id " +
                                    "WHERE asr.application_type = 'CTO' AND asr.app_del = FALSE"

                    );

                    ResultSet ctoReceivedApplicationRs = ctoReceivedApplication.executeQuery();
                    while (ctoReceivedApplicationRs.next()) {
                        cto = new Cto(
                                String.valueOf(ctoReceivedApplicationRs.getLong(1)),
                                ctoReceivedApplicationRs.getString(2),
                                ctoReceivedApplicationRs.getString(3),
                                ctoReceivedApplicationRs.getString(4),
                                ctoReceivedApplicationRs.getString(5),
                                UtilityService.getFormattedDate(ctoReceivedApplicationRs.getString(6)),
                                UtilityService.getFormattedDateIfInputDateIsValid(ctoReceivedApplicationRs.getString(7),
                                        ctoReceivedApplicationRs.getString(8)),
                                ctoReceivedApplicationRs.getString(8)

                        );
                        ctoList.add(cto);
                    }
                    break;
                case "gwt":
                    PreparedStatement ctoGwtApplication = con.prepareStatement(
                            "SELECT asr.application_id, asr.application_name, dm.district_name, irm.occ_name, asr.application_type, " +
                                    "CAST(asr.application_reciept_date AS VARCHAR), " +
                                    "CASE WHEN asr.application_status = 'pending' THEN '' " +
                                    "ELSE CAST(asr.pending_since AS VARCHAR) " +
                                    "END, asr.application_status " +
                                    "FROM all_summary_report as asr " +
                                    "LEFT JOIN industry_reg_master AS irm ON (CAST(irm.id AS VARCHAR) = asr.ind_reg_master_id) " +
                                    "LEFT JOIN district_master AS dm ON irm.district_id = dm.id " +
                                    "WHERE asr.application_type = 'CTO' AND asr.app_del = FALSE AND " +
                                    "asr.application_status = 'approved' AND " +
                                    "asr.pending_since - asr.application_reciept_date <= '120 days' "

                    );

                    ResultSet ctoGwtRs = ctoGwtApplication.executeQuery();
                    while (ctoGwtRs.next()) {
                        cto = new Cto(
                                String.valueOf(ctoGwtRs.getLong(1)),
                                ctoGwtRs.getString(2),
                                ctoGwtRs.getString(3),
                                ctoGwtRs.getString(4),
                                ctoGwtRs.getString(5),
                                UtilityService.getFormattedDate(ctoGwtRs.getString(6)),
                                UtilityService.getFormattedDateIfInputDateIsValid(ctoGwtRs.getString(7),
                                        ctoGwtRs.getString(8)),
                                ctoGwtRs.getString(8)

                        );
                        ctoList.add(cto);
                    }

                    break;
                case "gbt":
                    PreparedStatement ctoGbtApplication = con.prepareStatement(
                            "SELECT asr.application_id, asr.application_name, dm.district_name, irm.occ_name, asr.application_type, " +
                                    "CAST(asr.application_reciept_date AS VARCHAR), " +
                                    "CASE WHEN asr.application_status = 'pending' THEN '' " +
                                    "ELSE CAST(asr.pending_since AS VARCHAR) " +
                                    "END, asr.application_status " +
                                    "FROM all_summary_report as asr " +
                                    "LEFT JOIN industry_reg_master AS irm ON (CAST(irm.id AS VARCHAR) = asr.ind_reg_master_id) " +
                                    "LEFT JOIN district_master AS dm ON irm.district_id = dm.id " +
                                    "WHERE asr.application_type = 'CTO' AND asr.app_del = FALSE AND " +
                                    "asr.application_status = 'approved' AND " +
                                    "asr.pending_since - asr.application_reciept_date > '120 days' "

                    );

                    ResultSet ctoGbtRs = ctoGbtApplication.executeQuery();
                    while (ctoGbtRs.next()) {
                        cto = new Cto(
                                String.valueOf(ctoGbtRs.getLong(1)),
                                ctoGbtRs.getString(2),
                                ctoGbtRs.getString(3),
                                ctoGbtRs.getString(4),
                                ctoGbtRs.getString(5),
                                UtilityService.getFormattedDate(ctoGbtRs.getString(6)),
                                UtilityService.getFormattedDateIfInputDateIsValid(ctoGbtRs.getString(7),
                                        ctoGbtRs.getString(8)),
                                ctoGbtRs.getString(8)

                        );
                        ctoList.add(cto);
                    }

                    break;
                case "rwt":
                    PreparedStatement ctoRwtApplication = con.prepareStatement(
                            "SELECT asr.application_id, asr.application_name, dm.district_name, irm.occ_name, asr.application_type, " +
                                    "CAST(asr.application_reciept_date AS VARCHAR), " +
                                    "CASE WHEN asr.application_status = 'pending' THEN '' " +
                                    "ELSE CAST(asr.pending_since AS VARCHAR) " +
                                    "END, asr.application_status " +
                                    "FROM all_summary_report as asr " +
                                    "LEFT JOIN industry_reg_master AS irm ON (CAST(irm.id AS VARCHAR) = asr.ind_reg_master_id) " +
                                    "LEFT JOIN district_master AS dm ON irm.district_id = dm.id " +
                                    "WHERE asr.application_type = 'CTO' AND asr.app_del = FALSE AND " +
                                    "asr.application_status = 'rejected' AND " +
                                    "asr.pending_since - asr.application_reciept_date <= '120 days' "

                    );

                    ResultSet ctoRwtRs = ctoRwtApplication.executeQuery();
                    while (ctoRwtRs.next()) {
                        cto = new Cto(
                                String.valueOf(ctoRwtRs.getLong(1)),
                                ctoRwtRs.getString(2),
                                ctoRwtRs.getString(3),
                                ctoRwtRs.getString(4),
                                ctoRwtRs.getString(5),
                                UtilityService.getFormattedDate(ctoRwtRs.getString(6)),
                                UtilityService.getFormattedDateIfInputDateIsValid(ctoRwtRs.getString(7),
                                        ctoRwtRs.getString(8)),
                                ctoRwtRs.getString(8)

                        );
                        ctoList.add(cto);
                    }
                    break;
                case "rbt":
                    PreparedStatement ctoRbtApplication = con.prepareStatement(
                            "SELECT asr.application_id, asr.application_name, dm.district_name, irm.occ_name, asr.application_type, " +
                                    "CAST(asr.application_reciept_date AS VARCHAR), " +
                                    "CASE WHEN asr.application_status = 'pending' THEN '' " +
                                    "ELSE CAST(asr.pending_since AS VARCHAR) " +
                                    "END, asr.application_status " +
                                    "FROM all_summary_report as asr " +
                                    "LEFT JOIN industry_reg_master AS irm ON (CAST(irm.id AS VARCHAR) = asr.ind_reg_master_id) " +
                                    "LEFT JOIN district_master AS dm ON irm.district_id = dm.id " +
                                    "WHERE asr.application_type = 'CTO' AND asr.app_del = FALSE AND " +
                                    "asr.application_status = 'rejected' AND " +
                                    "asr.pending_since - asr.application_reciept_date > '120 days' "

                    );

                    ResultSet ctoRbtRs = ctoRbtApplication.executeQuery();
                    while (ctoRbtRs.next()) {
                        cto = new Cto(
                                String.valueOf(ctoRbtRs.getLong(1)),
                                ctoRbtRs.getString(2),
                                ctoRbtRs.getString(3),
                                ctoRbtRs.getString(4),
                                ctoRbtRs.getString(5),
                                UtilityService.getFormattedDate(ctoRbtRs.getString(6)),
                                UtilityService.getFormattedDateIfInputDateIsValid(ctoRbtRs.getString(7),
                                        ctoRbtRs.getString(8)),
                                ctoRbtRs.getString(8)

                        );
                        ctoList.add(cto);
                    }
                    break;
                case "pwt":
                    PreparedStatement ctoPwtApplication = con.prepareStatement(
                            "SELECT asr.application_id, asr.application_name, dm.district_name, irm.occ_name, asr.application_type, " +
                                    "CAST(asr.application_reciept_date AS VARCHAR), " +
                                    "CASE WHEN asr.application_status = 'pending' THEN '' " +
                                    "ELSE CAST(asr.pending_since AS VARCHAR) " +
                                    "END, asr.application_status " +
                                    "FROM all_summary_report as asr " +
                                    "LEFT JOIN industry_reg_master AS irm ON (CAST(irm.id AS VARCHAR) = asr.ind_reg_master_id) " +
                                    "LEFT JOIN district_master AS dm ON irm.district_id = dm.id " +
                                    "WHERE asr.application_type = 'CTO' AND asr.app_del = FALSE AND " +
                                    "asr.application_status = 'pending' AND " +
                                    "asr.application_reciept_date = ? AND asr.application_reciept_date = ? "

                    );
                    ctoPwtApplication.setTimestamp(1, new java.sql.Timestamp(today120.getTime()));
                    ctoPwtApplication.setTimestamp(2, new java.sql.Timestamp(today.getTime()));

                    ResultSet ctoPwtRs = ctoPwtApplication.executeQuery();
                    while (ctoPwtRs.next()) {
                        cto = new Cto(
                                String.valueOf(ctoPwtRs.getLong(1)),
                                ctoPwtRs.getString(2),
                                ctoPwtRs.getString(3),
                                ctoPwtRs.getString(4),
                                ctoPwtRs.getString(5),
                                UtilityService.getFormattedDate(ctoPwtRs.getString(6)),
                                UtilityService.getFormattedDateIfInputDateIsValid(ctoPwtRs.getString(7),
                                        ctoPwtRs.getString(8)),
                                ctoPwtRs.getString(8)

                        );
                        ctoList.add(cto);
                    }

                    break;
                case "pbt":
                    PreparedStatement ctoPbtApplication = con.prepareStatement(
                            "SELECT asr.application_id, asr.application_name, dm.district_name, irm.occ_name, asr.application_type, " +
                                    "CAST(asr.application_reciept_date AS VARCHAR), " +
                                    "CASE WHEN asr.application_status = 'pending' THEN '' " +
                                    "ELSE CAST(asr.pending_since AS VARCHAR) " +
                                    "END, asr.application_status " +
                                    "FROM all_summary_report as asr " +
                                    "LEFT JOIN industry_reg_master AS irm ON (CAST(irm.id AS VARCHAR) = asr.ind_reg_master_id) " +
                                    "LEFT JOIN district_master AS dm ON irm.district_id = dm.id " +
                                    "WHERE asr.application_type = 'CTO' AND asr.app_del = FALSE AND " +
                                    "asr.application_status = 'pending' AND " +
                                    "asr.application_reciept_date < ? "

                    );
                    ctoPbtApplication.setTimestamp(1, new java.sql.Timestamp(today120.getTime()));

                    ResultSet ctoPbtRs = ctoPbtApplication.executeQuery();
                    while (ctoPbtRs.next()) {
                        cto = new Cto(
                                String.valueOf(ctoPbtRs.getLong(1)),
                                ctoPbtRs.getString(2),
                                ctoPbtRs.getString(3),
                                ctoPbtRs.getString(4),
                                ctoPbtRs.getString(5),
                                UtilityService.getFormattedDate(ctoPbtRs.getString(6)),
                                UtilityService.getFormattedDateIfInputDateIsValid(ctoPbtRs.getString(7),
                                        ctoPbtRs.getString(8)),
                                ctoPbtRs.getString(8)

                        );
                        ctoList.add(cto);
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

        return ctoList;

    }

    public List<Cto> getFilteredData(String fromDateStr, String toDateStr, String choice){
        List<Cto> ctoList = new ArrayList<>();
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
            Cto cto;
            switch (choice) {
                case "ra":

                    PreparedStatement ctoReceivedApplication = con.prepareStatement(
                            "SELECT asr.application_id, asr.application_name, dm.district_name, irm.occ_name, asr.application_type, " +
                                    "CAST(asr.application_reciept_date AS VARCHAR), " +
                                    "CASE WHEN asr.application_status = 'pending' THEN '' " +
                                    "ELSE CAST(asr.pending_since AS VARCHAR) " +
                                    "END, asr.application_status " +
                                    "FROM all_summary_report as asr " +
                                    "LEFT JOIN industry_reg_master AS irm ON (CAST(irm.id AS VARCHAR) = asr.ind_reg_master_id) " +
                                    "LEFT JOIN district_master AS dm ON irm.district_id = dm.id " +
                                    "WHERE asr.application_type = 'CTO' AND asr.app_del = FALSE AND " +
                                    "asr.application_reciept_date >= ? AND asr.application_reciept_date <= ? "
                    );
                    ctoReceivedApplication.setTimestamp(1, new java.sql.Timestamp(fromDate.getTime()));
                    ctoReceivedApplication.setTimestamp(2, new java.sql.Timestamp(toDate.getTime()));


                    ResultSet ctoReceivedApplicationRs = ctoReceivedApplication.executeQuery();
                    while (ctoReceivedApplicationRs.next()) {
                        cto = new Cto(
                                String.valueOf(ctoReceivedApplicationRs.getLong(1)),
                                ctoReceivedApplicationRs.getString(2),
                                ctoReceivedApplicationRs.getString(3),
                                ctoReceivedApplicationRs.getString(4),
                                ctoReceivedApplicationRs.getString(5),
                                UtilityService.getFormattedDate(ctoReceivedApplicationRs.getString(6)),
                                UtilityService.getFormattedDateIfInputDateIsValid(ctoReceivedApplicationRs.getString(7),
                                        ctoReceivedApplicationRs.getString(8)),
                                ctoReceivedApplicationRs.getString(8)

                        );
                        ctoList.add(cto);
                    }
                    break;
                case "gwt":
                    PreparedStatement ctoGwtApplication = con.prepareStatement(
                            "SELECT asr.application_id, asr.application_name, dm.district_name, irm.occ_name, asr.application_type, " +
                                    "CAST(asr.application_reciept_date AS VARCHAR), " +
                                    "CASE WHEN asr.application_status = 'pending' THEN '' " +
                                    "ELSE CAST(asr.pending_since AS VARCHAR) " +
                                    "END, asr.application_status " +
                                    "FROM all_summary_report as asr " +
                                    "LEFT JOIN industry_reg_master AS irm ON (CAST(irm.id AS VARCHAR) = asr.ind_reg_master_id) " +
                                    "LEFT JOIN district_master AS dm ON irm.district_id = dm.id " +
                                    "WHERE asr.application_type = 'CTO' AND asr.app_del = FALSE AND " +
                                    "asr.application_status = 'approved' AND " +
                                    "asr.pending_since - asr.application_reciept_date <= '120 days' AND " +
                                    "asr.application_reciept_date >= ? AND asr.application_reciept_date <= ? "

                    );
                    ctoGwtApplication.setTimestamp(1, new java.sql.Timestamp(fromDate.getTime()));
                    ctoGwtApplication.setTimestamp(2, new java.sql.Timestamp(toDate.getTime()));

                    ResultSet ctoGwtRs = ctoGwtApplication.executeQuery();
                    while (ctoGwtRs.next()) {
                        cto = new Cto(
                                String.valueOf(ctoGwtRs.getLong(1)),
                                ctoGwtRs.getString(2),
                                ctoGwtRs.getString(3),
                                ctoGwtRs.getString(4),
                                ctoGwtRs.getString(5),
                                UtilityService.getFormattedDate(ctoGwtRs.getString(6)),
                                UtilityService.getFormattedDateIfInputDateIsValid(ctoGwtRs.getString(7),
                                        ctoGwtRs.getString(8)),
                                ctoGwtRs.getString(8)

                        );
                        ctoList.add(cto);
                    }

                    break;
                case "gbt":
                    PreparedStatement ctoGbtApplication = con.prepareStatement(
                            "SELECT asr.application_id, asr.application_name, dm.district_name, irm.occ_name, asr.application_type, " +
                                    "CAST(asr.application_reciept_date AS VARCHAR), " +
                                    "CASE WHEN asr.application_status = 'pending' THEN '' " +
                                    "ELSE CAST(asr.pending_since AS VARCHAR) " +
                                    "END, asr.application_status " +
                                    "FROM all_summary_report as asr " +
                                    "LEFT JOIN industry_reg_master AS irm ON (CAST(irm.id AS VARCHAR) = asr.ind_reg_master_id) " +
                                    "LEFT JOIN district_master AS dm ON irm.district_id = dm.id " +
                                    "WHERE asr.application_type = 'CTO' AND asr.app_del = FALSE AND " +
                                    "asr.application_status = 'approved' AND " +
                                    "asr.pending_since - asr.application_reciept_date > '120 days' AND " +
                                    "asr.application_reciept_date >= ? AND asr.application_reciept_date <= ? "

                    );
                    ctoGbtApplication.setTimestamp(1, new java.sql.Timestamp(fromDate.getTime()));
                    ctoGbtApplication.setTimestamp(2, new java.sql.Timestamp(toDate.getTime()));

                    ResultSet ctoGbtRs = ctoGbtApplication.executeQuery();
                    while (ctoGbtRs.next()) {
                        cto = new Cto(
                                String.valueOf(ctoGbtRs.getLong(1)),
                                ctoGbtRs.getString(2),
                                ctoGbtRs.getString(3),
                                ctoGbtRs.getString(4),
                                ctoGbtRs.getString(5),
                                UtilityService.getFormattedDate(ctoGbtRs.getString(6)),
                                UtilityService.getFormattedDateIfInputDateIsValid(ctoGbtRs.getString(7),
                                        ctoGbtRs.getString(8)),
                                ctoGbtRs.getString(8)

                        );
                        ctoList.add(cto);
                    }

                    break;
                case "rwt":
                    PreparedStatement ctoRwtApplication = con.prepareStatement(
                            "SELECT asr.application_id, asr.application_name, dm.district_name, irm.occ_name, asr.application_type, " +
                                    "CAST(asr.application_reciept_date AS VARCHAR), " +
                                    "CASE WHEN asr.application_status = 'pending' THEN '' " +
                                    "ELSE CAST(asr.pending_since AS VARCHAR) " +
                                    "END, asr.application_status " +
                                    "FROM all_summary_report as asr " +
                                    "LEFT JOIN industry_reg_master AS irm ON (CAST(irm.id AS VARCHAR) = asr.ind_reg_master_id) " +
                                    "LEFT JOIN district_master AS dm ON irm.district_id = dm.id " +
                                    "WHERE asr.application_type = 'CTO' AND asr.app_del = FALSE AND " +
                                    "asr.application_status = 'rejected' AND " +
                                    "asr.pending_since - asr.application_reciept_date <= '120 days' AND " +
                                    "asr.application_reciept_date >= ? AND asr.application_reciept_date <= ? "

                    );
                    ctoRwtApplication.setTimestamp(1, new java.sql.Timestamp(fromDate.getTime()));
                    ctoRwtApplication.setTimestamp(2, new java.sql.Timestamp(toDate.getTime()));

                    ResultSet ctoRwtRs = ctoRwtApplication.executeQuery();
                    while (ctoRwtRs.next()) {
                        cto = new Cto(
                                String.valueOf(ctoRwtRs.getLong(1)),
                                ctoRwtRs.getString(2),
                                ctoRwtRs.getString(3),
                                ctoRwtRs.getString(4),
                                ctoRwtRs.getString(5),
                                UtilityService.getFormattedDate(ctoRwtRs.getString(6)),
                                UtilityService.getFormattedDateIfInputDateIsValid(ctoRwtRs.getString(7),
                                        ctoRwtRs.getString(8)),
                                ctoRwtRs.getString(8)

                        );
                        ctoList.add(cto);
                    }
                    break;
                case "rbt":
                    PreparedStatement ctoRbtApplication = con.prepareStatement(
                            "SELECT asr.application_id, asr.application_name, dm.district_name, irm.occ_name, asr.application_type, " +
                                    "CAST(asr.application_reciept_date AS VARCHAR), " +
                                    "CASE WHEN asr.application_status = 'pending' THEN '' " +
                                    "ELSE CAST(asr.pending_since AS VARCHAR) " +
                                    "END, asr.application_status " +
                                    "FROM all_summary_report as asr " +
                                    "LEFT JOIN industry_reg_master AS irm ON (CAST(irm.id AS VARCHAR) = asr.ind_reg_master_id) " +
                                    "LEFT JOIN district_master AS dm ON irm.district_id = dm.id " +
                                    "WHERE asr.application_type = 'CTO' AND asr.app_del = FALSE AND " +
                                    "asr.application_status = 'rejected' AND " +
                                    "asr.pending_since - asr.application_reciept_date > '120 days' AND " +
                                    "asr.application_reciept_date >= ? AND asr.application_reciept_date <= ? "

                    );
                    ctoRbtApplication.setTimestamp(1, new java.sql.Timestamp(fromDate.getTime()));
                    ctoRbtApplication.setTimestamp(2, new java.sql.Timestamp(toDate.getTime()));

                    ResultSet ctoRbtRs = ctoRbtApplication.executeQuery();
                    while (ctoRbtRs.next()) {
                        cto = new Cto(
                                String.valueOf(ctoRbtRs.getLong(1)),
                                ctoRbtRs.getString(2),
                                ctoRbtRs.getString(3),
                                ctoRbtRs.getString(4),
                                ctoRbtRs.getString(5),
                                UtilityService.getFormattedDate(ctoRbtRs.getString(6)),
                                UtilityService.getFormattedDateIfInputDateIsValid(ctoRbtRs.getString(7),
                                        ctoRbtRs.getString(8)),
                                ctoRbtRs.getString(8)

                        );
                        ctoList.add(cto);
                    }
                    break;
                case "pwt":
                    PreparedStatement ctoPwtApplication = con.prepareStatement(
                            "SELECT asr.application_id, asr.application_name, dm.district_name, irm.occ_name, asr.application_type, " +
                                    "CAST(asr.application_reciept_date AS VARCHAR), " +
                                    "CASE WHEN asr.application_status = 'pending' THEN '' " +
                                    "ELSE CAST(asr.pending_since AS VARCHAR) " +
                                    "END, asr.application_status " +
                                    "FROM all_summary_report as asr " +
                                    "LEFT JOIN industry_reg_master AS irm ON (CAST(irm.id AS VARCHAR) = asr.ind_reg_master_id) " +
                                    "LEFT JOIN district_master AS dm ON irm.district_id = dm.id " +
                                    "WHERE asr.application_type = 'CTO' AND asr.app_del = FALSE AND " +
                                    "asr.application_status = 'pending' AND " +
                                    "asr.application_reciept_date = ? AND asr.application_reciept_date = ? AND " +
                                    "asr.application_reciept_date >= ? AND asr.application_reciept_date <= ?"

                    );
                    ctoPwtApplication.setTimestamp(1, new java.sql.Timestamp(today120.getTime()));
                    ctoPwtApplication.setTimestamp(2, new java.sql.Timestamp(today.getTime()));
                    ctoPwtApplication.setTimestamp(3, new java.sql.Timestamp(fromDate.getTime()));
                    ctoPwtApplication.setTimestamp(4, new java.sql.Timestamp(toDate.getTime()));

                    ResultSet ctoPwtRs = ctoPwtApplication.executeQuery();
                    while (ctoPwtRs.next()) {
                        cto = new Cto(
                                String.valueOf(ctoPwtRs.getLong(1)),
                                ctoPwtRs.getString(2),
                                ctoPwtRs.getString(3),
                                ctoPwtRs.getString(4),
                                ctoPwtRs.getString(5),
                                UtilityService.getFormattedDate(ctoPwtRs.getString(6)),
                                UtilityService.getFormattedDateIfInputDateIsValid(ctoPwtRs.getString(7),
                                        ctoPwtRs.getString(8)),
                                ctoPwtRs.getString(8)

                        );
                        ctoList.add(cto);
                    }

                    break;
                case "pbt":
                    PreparedStatement ctoPbtApplication = con.prepareStatement(
                            "SELECT asr.application_id, asr.application_name, dm.district_name, irm.occ_name, asr.application_type, " +
                                    "CAST(asr.application_reciept_date AS VARCHAR), " +
                                    "CASE WHEN asr.application_status = 'pending' THEN '' " +
                                    "ELSE CAST(asr.pending_since AS VARCHAR) " +
                                    "END, asr.application_status " +
                                    "FROM all_summary_report as asr " +
                                    "LEFT JOIN industry_reg_master AS irm ON (CAST(irm.id AS VARCHAR) = asr.ind_reg_master_id) " +
                                    "LEFT JOIN district_master AS dm ON irm.district_id = dm.id " +
                                    "WHERE asr.application_type = 'CTO' AND asr.app_del = FALSE AND " +
                                    "asr.application_status = 'pending' AND " +
                                    "asr.application_reciept_date < ? AND " +
                                    "asr.application_reciept_date >= ? AND asr.application_reciept_date <= ? "

                    );
                    ctoPbtApplication.setTimestamp(1, new java.sql.Timestamp(today120.getTime()));
                    ctoPbtApplication.setTimestamp(2, new java.sql.Timestamp(fromDate.getTime()));
                    ctoPbtApplication.setTimestamp(3, new java.sql.Timestamp(toDate.getTime()));

                    ResultSet ctoPbtRs = ctoPbtApplication.executeQuery();
                    while (ctoPbtRs.next()) {
                        cto = new Cto(
                                String.valueOf(ctoPbtRs.getLong(1)),
                                ctoPbtRs.getString(2),
                                ctoPbtRs.getString(3),
                                ctoPbtRs.getString(4),
                                ctoPbtRs.getString(5),
                                UtilityService.getFormattedDate(ctoPbtRs.getString(6)),
                                UtilityService.getFormattedDateIfInputDateIsValid(ctoPbtRs.getString(7),
                                        ctoPbtRs.getString(8)),
                                ctoPbtRs.getString(8)

                        );
                        ctoList.add(cto);
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

        return ctoList;
    }
}
