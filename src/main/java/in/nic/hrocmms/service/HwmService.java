package in.nic.hrocmms.service;

import in.nic.hrocmms.database.ConnectionManager;
import in.nic.hrocmms.model.Hwm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;

public class HwmService {

    private Connection con;

    public List<Hwm> getAllData(String choice){

        List<Hwm> hwmList = new ArrayList<>();
        Date today = new Date();
        Calendar cal = new GregorianCalendar();
        cal.setTime(today);
        cal.add(Calendar.DAY_OF_MONTH, -120);
        Date today120 = cal.getTime();

        try{
            con = ConnectionManager.getConnection();
            Hwm hwm;
            switch (choice) {
                case "ra":

                    PreparedStatement hwmReceivedApplication = con.prepareStatement(
                            "SELECT hasr.application_id, hasr.application_name, dm.district_name, " +
                                "irm.occ_name, hasr.application_type, CAST(hasr.application_receipt_date AS VARCHAR), " +
                                "CASE " +
                                "WHEN hasr.application_Status = 'pending' THEN '' " +
                                "ELSE CAST(hasr.pending_since AS VARCHAR) "+
                                "END, " +
                                "hasr.application_Status " +
                                "FROM hwm_all_summary_report AS hasr " +
                                "LEFT JOIN district_master AS dm ON (hasr.district_master_id = dm.id) " +
                                "LEFT JOIN industry_reg_master AS irm ON (irm.id = hasr.industry_reg_master_id) " +
                                "WHERE hasr.app_del = FALSE"

                    );

                    ResultSet hwmReceivedApplicationRs = hwmReceivedApplication.executeQuery();
                    while (hwmReceivedApplicationRs.next()) {
                        hwm = new Hwm(
                                String.valueOf(hwmReceivedApplicationRs.getLong(1)),
                                hwmReceivedApplicationRs.getString(2),
                                hwmReceivedApplicationRs.getString(3),
                                hwmReceivedApplicationRs.getString(4),
                                hwmReceivedApplicationRs.getString(5),
                                UtilityService.getFormattedDate(hwmReceivedApplicationRs.getString(6)),
                                UtilityService.getFormattedDateIfInputDateIsValid(hwmReceivedApplicationRs.getString(7),
                                        hwmReceivedApplicationRs.getString(8)),
                                hwmReceivedApplicationRs.getString(8)
                        );
                        hwmList.add(hwm);
                    }
                    break;
                case "gwt":
                    PreparedStatement hwmGwtApplication = con.prepareStatement(
                            "SELECT hasr.application_id, hasr.application_name, dm.district_name, " +
                                "irm.occ_name, hasr.application_type, CAST(hasr.application_receipt_date AS VARCHAR), " +
                                "CASE " +
                                "WHEN hasr.application_Status = 'pending' THEN '' " +
                                "ELSE CAST(hasr.pending_since AS VARCHAR) "+
                                "END, " +
                                "hasr.application_Status " +
                                "FROM hwm_all_summary_report AS hasr " +
                                "LEFT JOIN district_master AS dm ON (hasr.district_master_id = dm.id) " +
                                "LEFT JOIN industry_reg_master AS irm ON (irm.id = hasr.industry_reg_master_id) " +
                                "WHERE hasr.app_del = FALSE AND " +
                                "hasr.application_status = 'approved' AND " +
                                "hasr.pending_since - hasr.application_receipt_date <= '120 days'"
                    );

                    ResultSet hwmGwtRs = hwmGwtApplication.executeQuery();
                    while (hwmGwtRs.next()) {
                        hwm = new Hwm(
                                String.valueOf(hwmGwtRs.getLong(1)),
                                hwmGwtRs.getString(2),
                                hwmGwtRs.getString(3),
                                hwmGwtRs.getString(4),
                                hwmGwtRs.getString(5),
                                UtilityService.getFormattedDate(hwmGwtRs.getString(6)),
                                UtilityService.getFormattedDateIfInputDateIsValid(hwmGwtRs.getString(7),
                                        hwmGwtRs.getString(8)),
                                hwmGwtRs.getString(8)

                        );
                        hwmList.add(hwm);
                    }

                    break;
                case "gbt":
                    PreparedStatement hwmGbtApplication = con.prepareStatement(
                            "SELECT hasr.application_id, hasr.application_name, dm.district_name, " +
                                "irm.occ_name, hasr.application_type, CAST(hasr.application_receipt_date AS VARCHAR), " +
                                "CASE " +
                                "WHEN hasr.application_Status = 'pending' THEN '' " +
                                "ELSE CAST(hasr.pending_since AS VARCHAR) "+
                                "END, " +
                                "hasr.application_Status " +
                                "FROM hwm_all_summary_report AS hasr " +
                                "LEFT JOIN district_master AS dm ON (hasr.district_master_id = dm.id) " +
                                "LEFT JOIN industry_reg_master AS irm ON (irm.id = hasr.industry_reg_master_id) " +
                                "WHERE hasr.app_del = FALSE AND " +
                                "hasr.application_status = 'approved' AND " +
                                "hasr.pending_since - hasr.application_receipt_date > '120 days'"

                    );

                    ResultSet hwmGbtRs = hwmGbtApplication.executeQuery();
                    while (hwmGbtRs.next()) {
                        hwm = new Hwm(
                                String.valueOf(hwmGbtRs.getLong(1)),
                                hwmGbtRs.getString(2),
                                hwmGbtRs.getString(3),
                                hwmGbtRs.getString(4),
                                hwmGbtRs.getString(5),
                                UtilityService.getFormattedDate(hwmGbtRs.getString(6)),
                                UtilityService.getFormattedDateIfInputDateIsValid(hwmGbtRs.getString(7),
                                        hwmGbtRs.getString(8)),
                                hwmGbtRs.getString(8)

                        );
                        hwmList.add(hwm);
                    }

                    break;
                case "rwt":
                    PreparedStatement hwmRwtApplication = con.prepareStatement(
                            "SELECT hasr.application_id, hasr.application_name, dm.district_name, " +
                                "irm.occ_name, hasr.application_type, CAST(hasr.application_receipt_date AS VARCHAR), " +
                                "CASE " +
                                "WHEN hasr.application_Status = 'pending' THEN '' " +
                                "ELSE CAST(hasr.pending_since AS VARCHAR) "+
                                "END, " +
                                "hasr.application_Status " +
                                "FROM hwm_all_summary_report AS hasr " +
                                "LEFT JOIN district_master AS dm ON (hasr.district_master_id = dm.id) " +
                                "LEFT JOIN industry_reg_master AS irm ON (irm.id = hasr.industry_reg_master_id) " +
                                "WHERE hasr.app_del = FALSE AND " +
                                "hasr.application_status = 'rejected' AND " +
                                "hasr.pending_since - hasr.application_receipt_date <= '120 days'"

                    );

                    ResultSet hwmRwtRs = hwmRwtApplication.executeQuery();
                    while (hwmRwtRs.next()) {
                        hwm = new Hwm(
                                String.valueOf(hwmRwtRs.getLong(1)),
                                hwmRwtRs.getString(2),
                                hwmRwtRs.getString(3),
                                hwmRwtRs.getString(4),
                                hwmRwtRs.getString(5),
                                UtilityService.getFormattedDate(hwmRwtRs.getString(6)),
                                UtilityService.getFormattedDateIfInputDateIsValid(hwmRwtRs.getString(7),
                                        hwmRwtRs.getString(8)),
                                hwmRwtRs.getString(8)

                        );
                        hwmList.add(hwm);
                    }
                    break;
                case "rbt":
                    PreparedStatement hwmRbtApplication = con.prepareStatement(
                            "SELECT hasr.application_id, hasr.application_name, dm.district_name, " +
                                "irm.occ_name, hasr.application_type, CAST(hasr.application_receipt_date AS VARCHAR), " +
                                "CASE " +
                                "WHEN hasr.application_Status = 'pending' THEN '' " +
                                "ELSE CAST(hasr.pending_since AS VARCHAR) "+
                                "END, " +
                                "hasr.application_Status " +
                                "FROM hwm_all_summary_report AS hasr " +
                                "LEFT JOIN district_master AS dm ON (hasr.district_master_id = dm.id) " +
                                "LEFT JOIN industry_reg_master AS irm ON (irm.id = hasr.industry_reg_master_id) " +
                                "WHERE hasr.app_del = FALSE AND " +
                                "hasr.application_status = 'rejected' AND " +
                                "hasr.pending_since - hasr.application_receipt_date > '120 days'"

                    );

                    ResultSet hwmRbtRs = hwmRbtApplication.executeQuery();
                    while (hwmRbtRs.next()) {
                        hwm = new Hwm(
                                String.valueOf(hwmRbtRs.getLong(1)),
                                hwmRbtRs.getString(2),
                                hwmRbtRs.getString(3),
                                hwmRbtRs.getString(4),
                                hwmRbtRs.getString(5),
                                UtilityService.getFormattedDate(hwmRbtRs.getString(6)),
                                UtilityService.getFormattedDateIfInputDateIsValid(hwmRbtRs.getString(7),
                                        hwmRbtRs.getString(8)),
                                hwmRbtRs.getString(8)

                        );
                        hwmList.add(hwm);
                    }
                    break;
                case "pwt":
                    PreparedStatement hwmPwtApplication = con.prepareStatement(
                            "SELECT hasr.application_id, hasr.application_name, dm.district_name, " +
                                "irm.occ_name, hasr.application_type, CAST(hasr.application_receipt_date AS VARCHAR), " +
                                "CASE " +
                                "WHEN hasr.application_Status = 'pending' THEN '' " +
                                "ELSE CAST(hasr.pending_since AS VARCHAR) "+
                                "END, " +
                                "hasr.application_Status " +
                                "FROM hwm_all_summary_report AS hasr " +
                                "LEFT JOIN district_master AS dm ON (hasr.district_master_id = dm.id) " +
                                "LEFT JOIN industry_reg_master AS irm ON (irm.id = hasr.industry_reg_master_id) " +
                                "WHERE hasr.app_del = FALSE AND " +
                                "hasr.application_status = 'pending' AND " +
                                "hasr.application_receipt_date >= ? AND hasr.application_receipt_date <= ?"

                    );
                    hwmPwtApplication.setTimestamp(1, new java.sql.Timestamp(today120.getTime()));
                    hwmPwtApplication.setTimestamp(2, new java.sql.Timestamp(today.getTime()));

                    ResultSet hwmPwtRs = hwmPwtApplication.executeQuery();
                    while (hwmPwtRs.next()) {
                        hwm = new Hwm(
                                String.valueOf(hwmPwtRs.getLong(1)),
                                hwmPwtRs.getString(2),
                                hwmPwtRs.getString(3),
                                hwmPwtRs.getString(4),
                                hwmPwtRs.getString(5),
                                UtilityService.getFormattedDate(hwmPwtRs.getString(6)),
                                UtilityService.getFormattedDateIfInputDateIsValid(hwmPwtRs.getString(7),
                                        hwmPwtRs.getString(8)),
                                hwmPwtRs.getString(8)

                        );
                        hwmList.add(hwm);
                    }

                    break;
                case "pbt":
                    PreparedStatement hwmPbtApplication = con.prepareStatement(
                            "SELECT hasr.application_id, hasr.application_name, dm.district_name, " +
                                "irm.occ_name, hasr.application_type, CAST(hasr.application_receipt_date AS VARCHAR), " +
                                "CASE " +
                                "WHEN hasr.application_Status = 'pending' THEN '' " +
                                "ELSE CAST(hasr.pending_since AS VARCHAR) "+
                                "END, " +
                                "hasr.application_Status " +
                                "FROM hwm_all_summary_report AS hasr " +
                                "LEFT JOIN district_master AS dm ON (hasr.district_master_id = dm.id) " +
                                "LEFT JOIN industry_reg_master AS irm ON (irm.id = hasr.industry_reg_master_id) " +
                                "WHERE hasr.app_del = FALSE AND " +
                                "hasr.application_status = 'pending' AND " +
                                "hasr.application_receipt_date < ?"

                    );
                    hwmPbtApplication.setTimestamp(1, new java.sql.Timestamp(today120.getTime()));

                    ResultSet hwmPbtRs = hwmPbtApplication.executeQuery();
                    while (hwmPbtRs.next()) {
                        hwm = new Hwm(
                                String.valueOf(hwmPbtRs.getLong(1)),
                                hwmPbtRs.getString(2),
                                hwmPbtRs.getString(3),
                                hwmPbtRs.getString(4),
                                hwmPbtRs.getString(5),
                                UtilityService.getFormattedDate(hwmPbtRs.getString(6)),
                                UtilityService.getFormattedDateIfInputDateIsValid(hwmPbtRs.getString(7),
                                        hwmPbtRs.getString(8)),
                                hwmPbtRs.getString(8)

                        );
                        hwmList.add(hwm);
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

        return hwmList;

    }

    public List<Hwm> getFilteredData(String fromDateStr, String toDateStr, String choice){
        List<Hwm> hwmList = new ArrayList<>();
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
            Hwm hwm;
            switch (choice) {
                case "ra":

                    PreparedStatement hwmReceivedApplication = con.prepareStatement(
                            "SELECT hasr.application_id, hasr.application_name, dm.district_name, " +
                                "irm.occ_name, hasr.application_type, CAST(hasr.application_receipt_date AS VARCHAR), " +
                                "CASE " +
                                "WHEN hasr.application_Status = 'pending' THEN '' " +
                                "ELSE CAST(hasr.pending_since AS VARCHAR) "+
                                "END, " +
                                "hasr.application_Status " +
                                "FROM hwm_all_summary_report AS hasr " +
                                "LEFT JOIN district_master AS dm ON (hasr.district_master_id = dm.id) " +
                                "LEFT JOIN industry_reg_master AS irm ON (irm.id = hasr.industry_reg_master_id) " +
                                "WHERE hasr.app_del = FALSE AND " +
                                "hasr.application_receipt_date >= ? AND hasr.application_receipt_date <= ?"

                    );
                    hwmReceivedApplication.setTimestamp(1, new java.sql.Timestamp(fromDate.getTime()));
                    hwmReceivedApplication.setTimestamp(2, new java.sql.Timestamp(toDate.getTime()));

                    ResultSet hwmReceivedApplicationRs = hwmReceivedApplication.executeQuery();
                    while (hwmReceivedApplicationRs.next()) {
                        hwm = new Hwm(
                                String.valueOf(hwmReceivedApplicationRs.getLong(1)),
                                hwmReceivedApplicationRs.getString(2),
                                hwmReceivedApplicationRs.getString(3),
                                hwmReceivedApplicationRs.getString(4),
                                hwmReceivedApplicationRs.getString(5),
                                UtilityService.getFormattedDate(hwmReceivedApplicationRs.getString(6)),
                                UtilityService.getFormattedDateIfInputDateIsValid(hwmReceivedApplicationRs.getString(7),
                                        hwmReceivedApplicationRs.getString(8)),
                                hwmReceivedApplicationRs.getString(8)
                        );
                        hwmList.add(hwm);
                    }
                    break;
                case "gwt":
                    PreparedStatement hwmGwtApplication = con.prepareStatement(
                            "SELECT hasr.application_id, hasr.application_name, dm.district_name, " +
                                "irm.occ_name, hasr.application_type, CAST(hasr.application_receipt_date AS VARCHAR), " +
                                "CASE " +
                                "WHEN hasr.application_Status = 'pending' THEN '' " +
                                "ELSE CAST(hasr.pending_since AS VARCHAR) "+
                                "END, " +
                                "hasr.application_Status " +
                                "FROM hwm_all_summary_report AS hasr " +
                                "LEFT JOIN district_master AS dm ON (hasr.district_master_id = dm.id) " +
                                "LEFT JOIN industry_reg_master AS irm ON (irm.id = hasr.industry_reg_master_id) " +
                                "WHERE hasr.app_del = FALSE AND " +
                                "hasr.application_status = 'approved' AND " +
                                "hasr.pending_since - hasr.application_receipt_date <= '120 days' AND " +
                                "hasr.application_receipt_date >= ? AND hasr.application_receipt_date <= ?"
                    );
                    hwmGwtApplication.setTimestamp(1, new java.sql.Timestamp(fromDate.getTime()));
                    hwmGwtApplication.setTimestamp(2, new java.sql.Timestamp(toDate.getTime()));

                    ResultSet hwmGwtRs = hwmGwtApplication.executeQuery();
                    while (hwmGwtRs.next()) {
                        hwm = new Hwm(
                                String.valueOf(hwmGwtRs.getLong(1)),
                                hwmGwtRs.getString(2),
                                hwmGwtRs.getString(3),
                                hwmGwtRs.getString(4),
                                hwmGwtRs.getString(5),
                                UtilityService.getFormattedDate(hwmGwtRs.getString(6)),
                                UtilityService.getFormattedDateIfInputDateIsValid(hwmGwtRs.getString(7),
                                        hwmGwtRs.getString(8)),
                                hwmGwtRs.getString(8)

                        );
                        hwmList.add(hwm);
                    }

                    break;
                case "gbt":
                    PreparedStatement hwmGbtApplication = con.prepareStatement(
                            "SELECT hasr.application_id, hasr.application_name, dm.district_name, " +
                                "irm.occ_name, hasr.application_type, CAST(hasr.application_receipt_date AS VARCHAR), " +
                                "CASE " +
                                "WHEN hasr.application_Status = 'pending' THEN '' " +
                                "ELSE CAST(hasr.pending_since AS VARCHAR) "+
                                "END, " +
                                "hasr.application_Status " +
                                "FROM hwm_all_summary_report AS hasr " +
                                "LEFT JOIN district_master AS dm ON (hasr.district_master_id = dm.id) " +
                                "LEFT JOIN industry_reg_master AS irm ON (irm.id = hasr.industry_reg_master_id) " +
                                "WHERE hasr.app_del = FALSE AND " +
                                "hasr.application_status = 'approved' AND " +
                                "hasr.pending_since - hasr.application_receipt_date > '120 days' AND " +
                                "hasr.application_receipt_date >= ? AND hasr.application_receipt_date <= ?"

                    );
                    hwmGbtApplication.setTimestamp(1, new java.sql.Timestamp(fromDate.getTime()));
                    hwmGbtApplication.setTimestamp(2, new java.sql.Timestamp(toDate.getTime()));

                    ResultSet hwmGbtRs = hwmGbtApplication.executeQuery();
                    while (hwmGbtRs.next()) {
                        hwm = new Hwm(
                                String.valueOf(hwmGbtRs.getLong(1)),
                                hwmGbtRs.getString(2),
                                hwmGbtRs.getString(3),
                                hwmGbtRs.getString(4),
                                hwmGbtRs.getString(5),
                                UtilityService.getFormattedDate(hwmGbtRs.getString(6)),
                                UtilityService.getFormattedDateIfInputDateIsValid(hwmGbtRs.getString(7),
                                        hwmGbtRs.getString(8)),
                                hwmGbtRs.getString(8)

                        );
                        hwmList.add(hwm);
                    }

                    break;
                case "rwt":
                    PreparedStatement hwmRwtApplication = con.prepareStatement(
                            "SELECT hasr.application_id, hasr.application_name, dm.district_name, " +
                                "irm.occ_name, hasr.application_type, CAST(hasr.application_receipt_date AS VARCHAR), " +
                                "CASE " +
                                "WHEN hasr.application_Status = 'pending' THEN '' " +
                                "ELSE CAST(hasr.pending_since AS VARCHAR) "+
                                "END, " +
                                "hasr.application_Status " +
                                "FROM hwm_all_summary_report AS hasr " +
                                "LEFT JOIN district_master AS dm ON (hasr.district_master_id = dm.id) " +
                                "LEFT JOIN industry_reg_master AS irm ON (irm.id = hasr.industry_reg_master_id) " +
                                "WHERE hasr.app_del = FALSE AND " +
                                "hasr.application_status = 'rejected' AND " +
                                "hasr.pending_since - hasr.application_receipt_date <= '120 days' AND " +
                                "hasr.application_receipt_date >= ? AND hasr.application_receipt_date <= ?"

                    );
                    hwmRwtApplication.setTimestamp(1, new java.sql.Timestamp(fromDate.getTime()));
                    hwmRwtApplication.setTimestamp(2, new java.sql.Timestamp(toDate.getTime()));

                    ResultSet hwmRwtRs = hwmRwtApplication.executeQuery();
                    while (hwmRwtRs.next()) {
                        hwm = new Hwm(
                                String.valueOf(hwmRwtRs.getLong(1)),
                                hwmRwtRs.getString(2),
                                hwmRwtRs.getString(3),
                                hwmRwtRs.getString(4),
                                hwmRwtRs.getString(5),
                                UtilityService.getFormattedDate(hwmRwtRs.getString(6)),
                                UtilityService.getFormattedDateIfInputDateIsValid(hwmRwtRs.getString(7),
                                        hwmRwtRs.getString(8)),
                                hwmRwtRs.getString(8)

                        );
                        hwmList.add(hwm);
                    }
                    break;
                case "rbt":
                    PreparedStatement hwmRbtApplication = con.prepareStatement(
                            "SELECT hasr.application_id, hasr.application_name, dm.district_name, " +
                                "irm.occ_name, hasr.application_type, CAST(hasr.application_receipt_date AS VARCHAR), " +
                                "CASE " +
                                "WHEN hasr.application_Status = 'pending' THEN '' " +
                                "ELSE CAST(hasr.pending_since AS VARCHAR) "+
                                "END, " +
                                "hasr.application_Status " +
                                "FROM hwm_all_summary_report AS hasr " +
                                "LEFT JOIN district_master AS dm ON (hasr.district_master_id = dm.id) " +
                                "LEFT JOIN industry_reg_master AS irm ON (irm.id = hasr.industry_reg_master_id) " +
                                "WHERE hasr.app_del = FALSE AND " +
                                "hasr.application_status = 'rejected' AND " +
                                "hasr.pending_since - hasr.application_receipt_date > '120 days' AND " +
                                "hasr.application_receipt_date >= ? AND hasr.application_receipt_date <= ?"

                    );
                    hwmRbtApplication.setTimestamp(1, new java.sql.Timestamp(fromDate.getTime()));
                    hwmRbtApplication.setTimestamp(2, new java.sql.Timestamp(toDate.getTime()));

                    ResultSet hwmRbtRs = hwmRbtApplication.executeQuery();
                    while (hwmRbtRs.next()) {
                        hwm = new Hwm(
                                String.valueOf(hwmRbtRs.getLong(1)),
                                hwmRbtRs.getString(2),
                                hwmRbtRs.getString(3),
                                hwmRbtRs.getString(4),
                                hwmRbtRs.getString(5),
                                UtilityService.getFormattedDate(hwmRbtRs.getString(6)),
                                UtilityService.getFormattedDateIfInputDateIsValid(hwmRbtRs.getString(7),
                                        hwmRbtRs.getString(8)),
                                hwmRbtRs.getString(8)

                        );
                        hwmList.add(hwm);
                    }
                    break;
                case "pwt":
                    PreparedStatement hwmPwtApplication = con.prepareStatement(
                            "SELECT hasr.application_id, hasr.application_name, dm.district_name, " +
                                    "irm.occ_name, hasr.application_type, CAST(hasr.application_receipt_date AS VARCHAR), " +
                                    "CASE " +
                                    "WHEN hasr.application_Status = 'pending' THEN '' " +
                                    "ELSE CAST(hasr.pending_since AS VARCHAR) "+
                                    "END, " +
                                    "hasr.application_Status " +
                                    "FROM hwm_all_summary_report AS hasr " +
                                    "LEFT JOIN district_master AS dm ON (hasr.district_master_id = dm.id) " +
                                    "LEFT JOIN industry_reg_master AS irm ON (irm.id = hasr.industry_reg_master_id) " +
                                    "WHERE hasr.app_del = FALSE AND " +
                                    "hasr.application_status = 'pending' AND " +
                                    "hasr.application_receipt_date >= ? AND hasr.application_receipt_date <= ? AND " +
                                    "hasr.application_receipt_date >= ? AND hasr.application_receipt_date <= ?"

                    );
                    hwmPwtApplication.setTimestamp(1, new java.sql.Timestamp(today120.getTime()));
                    hwmPwtApplication.setTimestamp(2, new java.sql.Timestamp(today.getTime()));
                    hwmPwtApplication.setTimestamp(3, new java.sql.Timestamp(fromDate.getTime()));
                    hwmPwtApplication.setTimestamp(4, new java.sql.Timestamp(toDate.getTime()));

                    ResultSet hwmPwtRs = hwmPwtApplication.executeQuery();
                    while (hwmPwtRs.next()) {
                        hwm = new Hwm(
                                String.valueOf(hwmPwtRs.getLong(1)),
                                hwmPwtRs.getString(2),
                                hwmPwtRs.getString(3),
                                hwmPwtRs.getString(4),
                                hwmPwtRs.getString(5),
                                UtilityService.getFormattedDate(hwmPwtRs.getString(6)),
                                UtilityService.getFormattedDateIfInputDateIsValid(hwmPwtRs.getString(7),
                                        hwmPwtRs.getString(8)),
                                hwmPwtRs.getString(8)

                        );
                        hwmList.add(hwm);
                    }

                    break;
                case "pbt":
                    PreparedStatement hwmPbtApplication = con.prepareStatement(
                            "SELECT hasr.application_id, hasr.application_name, dm.district_name, " +
                                    "irm.occ_name, hasr.application_type, CAST(hasr.application_receipt_date AS VARCHAR), " +
                                    "CASE " +
                                    "WHEN hasr.application_Status = 'pending' THEN '' " +
                                    "ELSE CAST(hasr.pending_since AS VARCHAR) "+
                                    "END, " +
                                    "hasr.application_Status " +
                                    "FROM hwm_all_summary_report AS hasr " +
                                    "LEFT JOIN district_master AS dm ON (hasr.district_master_id = dm.id) " +
                                    "LEFT JOIN industry_reg_master AS irm ON (irm.id = hasr.industry_reg_master_id) " +
                                    "WHERE hasr.app_del = FALSE AND " +
                                    "hasr.application_status = 'pending' AND " +
                                    "hasr.application_receipt_date < ? AND " +
                                    "hasr.application_receipt_date >= ? AND hasr.application_receipt_date <= ?"

                    );
                    hwmPbtApplication.setTimestamp(1, new java.sql.Timestamp(today120.getTime()));
                    hwmPbtApplication.setTimestamp(2, new java.sql.Timestamp(fromDate.getTime()));
                    hwmPbtApplication.setTimestamp(3, new java.sql.Timestamp(toDate.getTime()));
                    ResultSet hwmPbtRs = hwmPbtApplication.executeQuery();
                    while (hwmPbtRs.next()) {
                        hwm = new Hwm(
                                String.valueOf(hwmPbtRs.getLong(1)),
                                hwmPbtRs.getString(2),
                                hwmPbtRs.getString(3),
                                hwmPbtRs.getString(4),
                                hwmPbtRs.getString(5),
                                UtilityService.getFormattedDate(hwmPbtRs.getString(6)),
                                UtilityService.getFormattedDateIfInputDateIsValid(hwmPbtRs.getString(7),
                                        hwmPbtRs.getString(8)),
                                hwmPbtRs.getString(8)

                        );
                        hwmList.add(hwm);
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

        return hwmList;
    }




}
