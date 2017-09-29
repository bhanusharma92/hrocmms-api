package in.nic.hrocmms.service;


import in.nic.hrocmms.database.ConnectionManager;
import in.nic.hrocmms.model.CountSingleModule;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;

public class CountSingleModuleService {
    private CountSingleModule countSingleModule;
    private Connection con;

    public List<CountSingleModule> getAllCount(String moduleType){
        con = ConnectionManager.getConnection();
        List<CountSingleModule> countSingleModuleList = new ArrayList<>();

        Date today = new Date();
        Calendar cal = new GregorianCalendar();
        cal.setTime(today);
        cal.add(Calendar.DAY_OF_MONTH, -120);
        Date today120 = cal.getTime();

        Long ctoReceivedCount = 0L;
        Long ctoGrantedWithinTime = 0L;
        Long ctoGrantedBeyondTime = 0L;
        Long ctoRejectedWithinTime = 0L;
        Long ctoRejectedBeyondTime = 0L;
        Long ctoPendingWithinTime = 0L;
        Long ctoPendingBeyondTime = 0L;

        Long hwmReceivedCount = 0L;
        Long hwmGrantedWithinTime = 0L;
        Long hwmGrantedBeyondTime = 0L;
        Long hwmRejectedWithinTime = 0L;
        Long hwmRejectedBeyondTime = 0L;
        Long hwmPendingWithinTime = 0L;
        Long hwmPendingBeyondTime = 0L;

        Long bmwReceivedCount = 0L;
        Long bmwGrantedWithinTime = 0L;
        Long bmwGrantedBeyondTime = 0L;
        Long bmwRejectedWithinTime = 0L;
        Long bmwRejectedBeyondTime = 0L;
        Long bmwPendingWithinTime = 0L;
        Long bmwPendingBeyondTime = 0L;

        try{

            // =============================================== CTO =====================================================
            PreparedStatement ctoGrantedWithinTimePs = con.prepareStatement("SELECT COUNT (*) FROM all_summary_report WHERE " +
                    "application_type = 'CTO' AND app_del = FALSE AND application_status = 'approved' AND " +
                    "pending_since - all_summary_report.application_reciept_date <= '120 days'");
            PreparedStatement ctoGrantedBeyondTimePs = con.prepareStatement("SELECT COUNT (*) FROM all_summary_report WHERE " +
                    "application_type = 'CTO' AND app_del = FALSE AND application_status = 'approved' AND " +
                    "pending_since - all_summary_report.application_reciept_date > '120 days'");
            PreparedStatement ctoRejectedWithinTimePs = con.prepareStatement("SELECT COUNT (*) FROM all_summary_report WHERE " +
                    "application_type = 'CTO' AND app_del = FALSE AND application_status = 'rejected' AND " +
                    "pending_since - all_summary_report.application_reciept_date <= '120 days'");
            PreparedStatement ctoRejectedBeyondTimePs = con.prepareStatement("SELECT COUNT (*) FROM all_summary_report WHERE " +
                    "application_type = 'CTO' AND app_del = FALSE AND application_status = 'rejected' AND " +
                    "pending_since - all_summary_report.application_reciept_date > '120 days'");
            PreparedStatement ctoPendingWithinTimePs = con.prepareStatement("SELECT COUNT (*) FROM all_summary_report WHERE " +
                    "application_type = 'CTO' AND app_del = FALSE AND application_status = 'pending' " +
                    "and application_reciept_date >=  ? and application_reciept_date <=  ?");
            ctoPendingWithinTimePs.setTimestamp(1, new java.sql.Timestamp(today120.getTime()));
            ctoPendingWithinTimePs.setTimestamp(2, new java.sql.Timestamp(today.getTime()));
            PreparedStatement ctoPendingBeyondTimePs = con.prepareStatement("SELECT COUNT (*) FROM all_summary_report WHERE " +
                    "application_type = 'CTO' AND app_del = FALSE AND application_status = 'pending' AND " +
                    " application_reciept_date < ?");
            ctoPendingBeyondTimePs.setTimestamp(1, new java.sql.Timestamp(today120.getTime()));

            ResultSet ctoGrantedWithinTimeRs = ctoGrantedWithinTimePs.executeQuery();
            ResultSet ctoGrantedBeyondTimeRs = ctoGrantedBeyondTimePs.executeQuery();
            ResultSet ctoRejectedWithinTimeRs = ctoRejectedWithinTimePs.executeQuery();
            ResultSet ctoRejectedBeyondTimeRs = ctoRejectedBeyondTimePs.executeQuery();
            ResultSet ctoPendingWithinTimeRs = ctoPendingWithinTimePs.executeQuery();
            ResultSet ctoPendingBeyondTimeRs = ctoPendingBeyondTimePs.executeQuery();

            if(ctoGrantedWithinTimeRs.next()){
                ctoGrantedWithinTime = ctoGrantedWithinTimeRs.getLong(1);
            }
            if(ctoGrantedBeyondTimeRs.next()){
                ctoGrantedBeyondTime = ctoGrantedBeyondTimeRs.getLong(1);
            }
            if(ctoRejectedWithinTimeRs.next()){
                ctoRejectedWithinTime = ctoRejectedWithinTimeRs.getLong(1);
            }
            if(ctoRejectedBeyondTimeRs.next()){
                ctoRejectedBeyondTime = ctoRejectedBeyondTimeRs.getLong(1);
            }
            if(ctoPendingWithinTimeRs.next()){
                ctoPendingWithinTime = ctoPendingWithinTimeRs.getLong(1);
            }
            if(ctoPendingBeyondTimeRs.next()){
                ctoPendingBeyondTime = ctoPendingBeyondTimeRs.getLong(1);
            }
            ctoReceivedCount = ctoGrantedWithinTime + ctoGrantedBeyondTime +  ctoRejectedWithinTime + ctoRejectedBeyondTime + ctoPendingWithinTime+ ctoPendingBeyondTime;

            // ============================================= CTO ENDS ==================================================

            // ============================================== HWM ======================================================
            PreparedStatement hwmGrantedWithinTimePs = con.prepareStatement("SELECT COUNT (*) FROM hwm_all_summary_report WHERE " +
                    " app_del = FALSE and application_status = 'approved' AND pending_since - application_receipt_date  <= '120 days' ");
            PreparedStatement hwmGrantedBeyondTimePs = con.prepareStatement("SELECT COUNT (*) FROM hwm_all_summary_report WHERE " +
                    " app_del = FALSE and application_status = 'approved' AND pending_since - application_receipt_date  > '120 days' ");
            PreparedStatement hwmRejectedWithinTimePs = con.prepareStatement("SELECT COUNT (*) FROM hwm_all_summary_report WHERE " +
                    " app_del = FALSE and application_status = 'rejected' AND pending_since - application_receipt_date  <= '120 days' ");
            PreparedStatement hwmRejectedBeyondTimePs = con.prepareStatement("SELECT COUNT (*) FROM hwm_all_summary_report WHERE " +
                    " app_del = FALSE and application_status = 'rejected' AND pending_since - application_receipt_date  > '120 days' ");
            PreparedStatement hwmPendingWithinTimePs = con.prepareStatement("SELECT COUNT (*) FROM hwm_all_summary_report WHERE " +
                    " app_del = FALSE and application_status = 'pending' AND application_receipt_date >= ? AND application_receipt_date <= ?");
            hwmPendingWithinTimePs.setTimestamp(1, new java.sql.Timestamp(today120.getTime()));
            hwmPendingWithinTimePs.setTimestamp(2, new java.sql.Timestamp(today.getTime()));
            PreparedStatement hwmPendingBeyondTimePs = con.prepareStatement("SELECT COUNT (*) FROM hwm_all_summary_report WHERE " +
                    " app_del = FALSE and application_status = 'pending' AND application_receipt_date < ?");
            hwmPendingBeyondTimePs.setTimestamp(1, new java.sql.Timestamp(today120.getTime()));

            ResultSet hwmGrantedWithinTimeRs = hwmGrantedWithinTimePs.executeQuery();
            ResultSet hwmGrantedBeyondTimeRs = hwmGrantedBeyondTimePs.executeQuery();
            ResultSet hwmRejectedWithinTimeRs = hwmRejectedWithinTimePs.executeQuery();
            ResultSet hwmRejectedBeyondTimeRs = hwmRejectedBeyondTimePs.executeQuery();
            ResultSet hwmPendingWithinTimeRs = hwmPendingWithinTimePs.executeQuery();
            ResultSet hwmPendingBeyondTimeRs = hwmPendingBeyondTimePs.executeQuery();

            if(hwmGrantedWithinTimeRs.next()){
                hwmGrantedWithinTime = hwmGrantedWithinTimeRs.getLong(1);
            }
            if(hwmGrantedBeyondTimeRs.next()){
                hwmGrantedBeyondTime = hwmGrantedBeyondTimeRs.getLong(1);
            }
            if(hwmRejectedWithinTimeRs.next()){
                hwmRejectedWithinTime = hwmRejectedWithinTimeRs.getLong(1);
            }
            if(hwmRejectedBeyondTimeRs.next()){
                hwmRejectedBeyondTime = hwmRejectedBeyondTimeRs.getLong(1);
            }
            if(hwmPendingWithinTimeRs.next()){
                hwmPendingWithinTime = hwmPendingWithinTimeRs.getLong(1);
            }
            if(hwmPendingBeyondTimeRs.next()){
                hwmPendingBeyondTime = hwmPendingBeyondTimeRs.getLong(1);
            }
            hwmReceivedCount = hwmGrantedWithinTime + hwmGrantedBeyondTime +  hwmRejectedWithinTime + hwmRejectedBeyondTime + hwmPendingWithinTime+ hwmPendingBeyondTime;
            // ============================================== HWM ENDS =================================================

            // ============================================== BMW ======================================================
            PreparedStatement bmwGrantedWithinTimePs = con.prepareStatement("SELECT COUNT (*) FROM bmw_all_summary_report WHERE " +
                    " app_del = FALSE and application_status = 'approved' AND pending_since - application_receipt_date  <= '120 days' ");
            PreparedStatement bmwGrantedBeyondTimePs = con.prepareStatement("SELECT COUNT (*) FROM bmw_all_summary_report WHERE " +
                    " app_del = FALSE and application_status = 'approved' AND pending_since - application_receipt_date  > '120 days' ");
            PreparedStatement bmwRejectedWithinTimePs = con.prepareStatement("SELECT COUNT (*) FROM bmw_all_summary_report WHERE " +
                    " app_del = FALSE and application_status = 'rejected' AND pending_since - application_receipt_date  <= '120 days' ");
            PreparedStatement bmwRejectedBeyondTimePs = con.prepareStatement("SELECT COUNT (*) FROM bmw_all_summary_report WHERE " +
                    " app_del = FALSE and application_status = 'rejected' AND pending_since - application_receipt_date  > '120 days' ");
            PreparedStatement bmwPendingWithinTimePs = con.prepareStatement("SELECT COUNT (*) FROM bmw_all_summary_report WHERE " +
                    " app_del = FALSE and application_status = 'pending' AND application_receipt_date >= ? AND application_receipt_date <= ?");
            bmwPendingWithinTimePs.setTimestamp(1, new java.sql.Timestamp(today120.getTime()));
            bmwPendingWithinTimePs.setTimestamp(2, new java.sql.Timestamp(today.getTime()));
            PreparedStatement bmwPendingBeyondTimePs = con.prepareStatement("SELECT COUNT (*) FROM bmw_all_summary_report WHERE " +
                    " app_del = FALSE and application_status = 'pending' AND application_receipt_date < ?");
            bmwPendingBeyondTimePs.setTimestamp(1, new java.sql.Timestamp(today120.getTime()));

            ResultSet bmwGrantedWithinTimeRs = bmwGrantedWithinTimePs.executeQuery();
            ResultSet bmwGrantedBeyondTimeRs = bmwGrantedBeyondTimePs.executeQuery();
            ResultSet bmwRejectedWithinTimeRs = bmwRejectedWithinTimePs.executeQuery();
            ResultSet bmwRejectedBeyondTimeRs = bmwRejectedBeyondTimePs.executeQuery();
            ResultSet bmwPendingWithinTimeRs = bmwPendingWithinTimePs.executeQuery();
            ResultSet bmwPendingBeyondTimeRs = bmwPendingBeyondTimePs.executeQuery();

            if(bmwGrantedWithinTimeRs.next()){
                bmwGrantedWithinTime = bmwGrantedWithinTimeRs.getLong(1);
            }
            if(bmwGrantedBeyondTimeRs.next()){
                bmwGrantedBeyondTime = bmwGrantedBeyondTimeRs.getLong(1);
            }
            if(bmwRejectedWithinTimeRs.next()){
                bmwRejectedWithinTime = bmwRejectedWithinTimeRs.getLong(1);
            }
            if(bmwRejectedBeyondTimeRs.next()){
                bmwRejectedBeyondTime = bmwRejectedBeyondTimeRs.getLong(1);
            }
            if(bmwPendingWithinTimeRs.next()){
                bmwPendingWithinTime = bmwPendingWithinTimeRs.getLong(1);
            }
            if(bmwPendingBeyondTimeRs.next()){
                bmwPendingBeyondTime = bmwPendingBeyondTimeRs.getLong(1);
            }
            bmwReceivedCount = bmwGrantedWithinTime + bmwGrantedBeyondTime +  bmwRejectedWithinTime + bmwRejectedBeyondTime + bmwPendingWithinTime+ bmwPendingBeyondTime;
            // ==============================================BMW ENDS ==================================================

            if(moduleType.equals("cto")){
                countSingleModule = new CountSingleModule("cto", ctoGrantedBeyondTime, ctoGrantedWithinTime,
                        ctoPendingBeyondTime, 0L, ctoPendingWithinTime, ctoGrantedBeyondTime+ctoGrantedWithinTime,
                        ctoPendingBeyondTime+ctoPendingWithinTime, ctoReceivedCount);
            }else if(moduleType.equals("hwm")){
                countSingleModule = new CountSingleModule("hwm", hwmGrantedBeyondTime, hwmGrantedWithinTime,
                        hwmPendingBeyondTime, 0L, hwmPendingWithinTime, hwmGrantedBeyondTime+hwmGrantedWithinTime,
                        hwmPendingBeyondTime+hwmPendingWithinTime, hwmReceivedCount);

            }else if(moduleType.equals("bmw")){
                countSingleModule = new CountSingleModule("bmw", bmwGrantedBeyondTime, bmwGrantedWithinTime,
                        bmwPendingBeyondTime, 0L, bmwPendingWithinTime, bmwGrantedBeyondTime+bmwGrantedWithinTime,
                        bmwPendingBeyondTime+bmwPendingWithinTime, bmwReceivedCount);
            }else if(moduleType.equals("all")){
                countSingleModule = new CountSingleModule("cto", ctoGrantedBeyondTime, ctoGrantedWithinTime,
                        ctoPendingBeyondTime, 0L, ctoPendingWithinTime, ctoGrantedBeyondTime+ctoGrantedWithinTime,
                        ctoPendingBeyondTime+ctoPendingWithinTime, ctoReceivedCount);
                countSingleModuleList.add(countSingleModule);
                countSingleModule = new CountSingleModule("hwm", hwmGrantedBeyondTime, hwmGrantedWithinTime,
                        hwmPendingBeyondTime, 0L, hwmPendingWithinTime, hwmGrantedBeyondTime+hwmGrantedWithinTime,
                        hwmPendingBeyondTime+hwmPendingWithinTime, hwmReceivedCount);
                countSingleModuleList.add(countSingleModule);
                countSingleModule = new CountSingleModule("bmw", bmwGrantedBeyondTime, bmwGrantedWithinTime,
                        bmwPendingBeyondTime, 0L, bmwPendingWithinTime, bmwGrantedBeyondTime+bmwGrantedWithinTime,
                        bmwPendingBeyondTime+bmwPendingWithinTime, bmwReceivedCount);
                countSingleModuleList.add(countSingleModule);

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

        if(!moduleType.equals("all")){
            countSingleModuleList.add(countSingleModule);
        }

        return countSingleModuleList;
    }


    public List<CountSingleModule> getAllCountDate(String moduleType, String fromDateStr, String toDateStr){

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        List<CountSingleModule> countSingleModuleList = new ArrayList<>();
        Date fromDate = null;
        Date toDate = null;
        try{
            fromDate = sdf.parse(fromDateStr);
            toDate = sdf.parse(toDateStr);
        } catch (Exception e){
            e.printStackTrace();
            List<CountSingleModule> ExceptionCountList = new ArrayList<>();
            ExceptionCountList.add(new CountSingleModule());
            return ExceptionCountList;
        }

        con = ConnectionManager.getConnection();

        Date today = new Date();
        Calendar cal = new GregorianCalendar();
        cal.setTime(today);
        cal.add(Calendar.DAY_OF_MONTH, -120);
        Date today120 = cal.getTime();

        Long ctoReceivedCount = 0L;
        Long ctoGrantedWithinTime = 0L;
        Long ctoGrantedBeyondTime = 0L;
        Long ctoRejectedWithinTime = 0L;
        Long ctoRejectedBeyondTime = 0L;
        Long ctoPendingWithinTime = 0L;
        Long ctoPendingBeyondTime = 0L;

        Long hwmReceivedCount = 0L;
        Long hwmGrantedWithinTime = 0L;
        Long hwmGrantedBeyondTime = 0L;
        Long hwmRejectedWithinTime = 0L;
        Long hwmRejectedBeyondTime = 0L;
        Long hwmPendingWithinTime = 0L;
        Long hwmPendingBeyondTime = 0L;

        Long bmwReceivedCount = 0L;
        Long bmwGrantedWithinTime = 0L;
        Long bmwGrantedBeyondTime = 0L;
        Long bmwRejectedWithinTime = 0L;
        Long bmwRejectedBeyondTime = 0L;
        Long bmwPendingWithinTime = 0L;
        Long bmwPendingBeyondTime = 0L;

        try{
            // =============================================== CTO =====================================================
            PreparedStatement ctoGrantedWithinTimePs = con.prepareStatement("SELECT COUNT (*) FROM all_summary_report WHERE " +
                    "application_type = 'CTO' AND app_del = FALSE AND application_status = 'approved' AND " +
                    "pending_since - all_summary_report.application_reciept_date <= '120 days' AND " +
                    "application_reciept_date >=  ? AND application_reciept_date <=  ?");
            ctoGrantedWithinTimePs.setTimestamp(1, new java.sql.Timestamp(fromDate.getTime()));
            ctoGrantedWithinTimePs.setTimestamp(2, new java.sql.Timestamp(toDate.getTime()));
            PreparedStatement ctoGrantedBeyondTimePs = con.prepareStatement("SELECT COUNT (*) FROM all_summary_report WHERE " +
                    "application_type = 'CTO' AND app_del = FALSE AND application_status = 'approved' AND " +
                    "pending_since - all_summary_report.application_reciept_date > '120 days' AND "+
                    "application_reciept_date >=  ? AND application_reciept_date <=  ?");
            ctoGrantedBeyondTimePs.setTimestamp(1, new java.sql.Timestamp(fromDate.getTime()));
            ctoGrantedBeyondTimePs.setTimestamp(2, new java.sql.Timestamp(toDate.getTime()));
            PreparedStatement ctoRejectedWithinTimePs = con.prepareStatement("SELECT COUNT (*) FROM all_summary_report WHERE " +
                    "application_type = 'CTO' AND app_del = FALSE AND application_status = 'rejected' AND " +
                    "pending_since - all_summary_report.application_reciept_date <= '120 days' AND " +
                    "application_reciept_date >=  ? AND application_reciept_date <=  ?");
            ctoRejectedWithinTimePs.setTimestamp(1, new java.sql.Timestamp(fromDate.getTime()));
            ctoRejectedWithinTimePs.setTimestamp(2, new java.sql.Timestamp(toDate.getTime()));
            PreparedStatement ctoRejectedBeyondTimePs = con.prepareStatement("SELECT COUNT (*) FROM all_summary_report WHERE " +
                    "application_type = 'CTO' AND app_del = FALSE AND application_status = 'rejected' AND " +
                    "pending_since - all_summary_report.application_reciept_date > '120 days' AND " +
                    "application_reciept_date >=  ? AND application_reciept_date <=  ?");
            ctoRejectedBeyondTimePs.setTimestamp(1, new java.sql.Timestamp(fromDate.getTime()));
            ctoRejectedBeyondTimePs.setTimestamp(2, new java.sql.Timestamp(toDate.getTime()));
            PreparedStatement ctoPendingWithinTimePs = con.prepareStatement("SELECT COUNT (*) FROM all_summary_report WHERE " +
                    "application_type = 'CTO' AND app_del = FALSE AND application_status = 'pending' " +
                    "and application_reciept_date >=  ? and application_reciept_date <=  ? AND " +
                    "application_reciept_date >=  ? AND application_reciept_date <=  ?");
            ctoPendingWithinTimePs.setTimestamp(1, new java.sql.Timestamp(today120.getTime()));
            ctoPendingWithinTimePs.setTimestamp(2, new java.sql.Timestamp(today.getTime()));
            ctoPendingWithinTimePs.setTimestamp(3, new java.sql.Timestamp(fromDate.getTime()));
            ctoPendingWithinTimePs.setTimestamp(4, new java.sql.Timestamp(toDate.getTime()));
            PreparedStatement ctoPendingBeyondTimePs = con.prepareStatement("SELECT COUNT (*) FROM all_summary_report WHERE " +
                    "application_type = 'CTO' AND app_del = FALSE AND application_status = 'pending' AND " +
                    " application_reciept_date < ? AND " +
                    "application_reciept_date >=  ? AND application_reciept_date <=  ?");
            ctoPendingBeyondTimePs.setTimestamp(1, new java.sql.Timestamp(today120.getTime()));
            ctoPendingBeyondTimePs.setTimestamp(2, new java.sql.Timestamp(fromDate.getTime()));
            ctoPendingBeyondTimePs.setTimestamp(3, new java.sql.Timestamp(toDate.getTime()));

            ResultSet ctoGrantedWithinTimeRs = ctoGrantedWithinTimePs.executeQuery();
            ResultSet ctoGrantedBeyondTimeRs = ctoGrantedBeyondTimePs.executeQuery();
            ResultSet ctoRejectedWithinTimeRs = ctoRejectedWithinTimePs.executeQuery();
            ResultSet ctoRejectedBeyondTimeRs = ctoRejectedBeyondTimePs.executeQuery();
            ResultSet ctoPendingWithinTimeRs = ctoPendingWithinTimePs.executeQuery();
            ResultSet ctoPendingBeyondTimeRs = ctoPendingBeyondTimePs.executeQuery();

            if(ctoGrantedWithinTimeRs.next()){
                ctoGrantedWithinTime = ctoGrantedWithinTimeRs.getLong(1);
            }
            if(ctoGrantedBeyondTimeRs.next()){
                ctoGrantedBeyondTime = ctoGrantedBeyondTimeRs.getLong(1);
            }
            if(ctoRejectedWithinTimeRs.next()){
                ctoRejectedWithinTime = ctoRejectedWithinTimeRs.getLong(1);
            }
            if(ctoRejectedBeyondTimeRs.next()){
                ctoRejectedBeyondTime = ctoRejectedBeyondTimeRs.getLong(1);
            }
            if(ctoPendingWithinTimeRs.next()){
                ctoPendingWithinTime = ctoPendingWithinTimeRs.getLong(1);
            }
            if(ctoPendingBeyondTimeRs.next()){
                ctoPendingBeyondTime = ctoPendingBeyondTimeRs.getLong(1);
            }
            ctoReceivedCount = ctoGrantedWithinTime + ctoGrantedBeyondTime +  ctoRejectedWithinTime + ctoRejectedBeyondTime + ctoPendingWithinTime+ ctoPendingBeyondTime;

            // ============================================= CTO ENDS ==================================================

            // ============================================== HWM ======================================================
            PreparedStatement hwmGrantedWithinTimePs = con.prepareStatement("SELECT COUNT (*) FROM hwm_all_summary_report WHERE " +
                    " app_del = FALSE and application_status = 'approved' AND pending_since - application_receipt_date  <= '120 days' AND " +
                    "application_receipt_date >= ? AND application_receipt_date <= ?");
            hwmGrantedWithinTimePs.setTimestamp(1, new java.sql.Timestamp(fromDate.getTime()));
            hwmGrantedWithinTimePs.setTimestamp(2, new java.sql.Timestamp(toDate.getTime()));
            PreparedStatement hwmGrantedBeyondTimePs = con.prepareStatement("SELECT COUNT (*) FROM hwm_all_summary_report WHERE " +
                    " app_del = FALSE and application_status = 'approved' AND pending_since - application_receipt_date  > '120 days' AND " +
                    "application_receipt_date >= ? AND application_receipt_date <= ?");
            hwmGrantedBeyondTimePs.setTimestamp(1, new java.sql.Timestamp(fromDate.getTime()));
            hwmGrantedBeyondTimePs.setTimestamp(2, new java.sql.Timestamp(toDate.getTime()));
            PreparedStatement hwmRejectedWithinTimePs = con.prepareStatement("SELECT COUNT (*) FROM hwm_all_summary_report WHERE " +
                    " app_del = FALSE and application_status = 'rejected' AND pending_since - application_receipt_date  <= '120 days' AND " +
                    "application_receipt_date >= ? AND application_receipt_date <= ?");
            hwmRejectedWithinTimePs.setTimestamp(1, new java.sql.Timestamp(fromDate.getTime()));
            hwmRejectedWithinTimePs.setTimestamp(2, new java.sql.Timestamp(toDate.getTime()));
            PreparedStatement hwmRejectedBeyondTimePs = con.prepareStatement("SELECT COUNT (*) FROM hwm_all_summary_report WHERE " +
                    " app_del = FALSE and application_status = 'rejected' AND pending_since - application_receipt_date  > '120 days' AND " +
                    "application_receipt_date >= ? AND application_receipt_date <= ?");
            hwmRejectedBeyondTimePs.setTimestamp(1, new java.sql.Timestamp(fromDate.getTime()));
            hwmRejectedBeyondTimePs.setTimestamp(2, new java.sql.Timestamp(toDate.getTime()));
            PreparedStatement hwmPendingWithinTimePs = con.prepareStatement("SELECT COUNT (*) FROM hwm_all_summary_report WHERE " +
                    " app_del = FALSE and application_status = 'pending' AND application_receipt_date >= ? AND application_receipt_date <= ? AND " +
                    "application_receipt_date >= ? AND application_receipt_date <= ?");
            hwmPendingWithinTimePs.setTimestamp(1, new java.sql.Timestamp(today120.getTime()));
            hwmPendingWithinTimePs.setTimestamp(2, new java.sql.Timestamp(today.getTime()));
            hwmPendingWithinTimePs.setTimestamp(3, new java.sql.Timestamp(fromDate.getTime()));
            hwmPendingWithinTimePs.setTimestamp(4, new java.sql.Timestamp(toDate.getTime()));
            PreparedStatement hwmPendingBeyondTimePs = con.prepareStatement("SELECT COUNT (*) FROM hwm_all_summary_report WHERE " +
                    " app_del = FALSE and application_status = 'pending' AND application_receipt_date < ? AND " +
                    "application_receipt_date >= ? AND application_receipt_date <= ?");
            hwmPendingBeyondTimePs.setTimestamp(1, new java.sql.Timestamp(today120.getTime()));
            hwmPendingBeyondTimePs.setTimestamp(2, new java.sql.Timestamp(fromDate.getTime()));
            hwmPendingBeyondTimePs.setTimestamp(3, new java.sql.Timestamp(toDate.getTime()));

            ResultSet hwmGrantedWithinTimeRs = hwmGrantedWithinTimePs.executeQuery();
            ResultSet hwmGrantedBeyondTimeRs = hwmGrantedBeyondTimePs.executeQuery();
            ResultSet hwmRejectedWithinTimeRs = hwmRejectedWithinTimePs.executeQuery();
            ResultSet hwmRejectedBeyondTimeRs = hwmRejectedBeyondTimePs.executeQuery();
            ResultSet hwmPendingWithinTimeRs = hwmPendingWithinTimePs.executeQuery();
            ResultSet hwmPendingBeyondTimeRs = hwmPendingBeyondTimePs.executeQuery();

            if(hwmGrantedWithinTimeRs.next()){
                hwmGrantedWithinTime = hwmGrantedWithinTimeRs.getLong(1);
            }
            if(hwmGrantedBeyondTimeRs.next()){
                hwmGrantedBeyondTime = hwmGrantedBeyondTimeRs.getLong(1);
            }
            if(hwmRejectedWithinTimeRs.next()){
                hwmRejectedWithinTime = hwmRejectedWithinTimeRs.getLong(1);
            }
            if(hwmRejectedBeyondTimeRs.next()){
                hwmRejectedBeyondTime = hwmRejectedBeyondTimeRs.getLong(1);
            }
            if(hwmPendingWithinTimeRs.next()){
                hwmPendingWithinTime = hwmPendingWithinTimeRs.getLong(1);
            }
            if(hwmPendingBeyondTimeRs.next()){
                hwmPendingBeyondTime = hwmPendingBeyondTimeRs.getLong(1);
            }
            hwmReceivedCount = hwmGrantedWithinTime + hwmGrantedBeyondTime +  hwmRejectedWithinTime + hwmRejectedBeyondTime + hwmPendingWithinTime+ hwmPendingBeyondTime;
            // ============================================== HWM ENDS =================================================

            // ============================================== BMW ======================================================
            PreparedStatement bmwGrantedWithinTimePs = con.prepareStatement("SELECT COUNT (*) FROM bmw_all_summary_report WHERE " +
                    " app_del = FALSE and application_status = 'approved' AND pending_since - application_receipt_date  <= '120 days' AND " +
                    "application_receipt_date >= ? AND application_receipt_date <= ?");
            bmwGrantedWithinTimePs.setTimestamp(1, new java.sql.Timestamp(fromDate.getTime()));
            bmwGrantedWithinTimePs.setTimestamp(2, new java.sql.Timestamp(toDate.getTime()));
            PreparedStatement bmwGrantedBeyondTimePs = con.prepareStatement("SELECT COUNT (*) FROM bmw_all_summary_report WHERE " +
                    " app_del = FALSE and application_status = 'approved' AND pending_since - application_receipt_date  > '120 days' AND " +
                    "application_receipt_date >= ? AND application_receipt_date <= ?");
            bmwGrantedBeyondTimePs.setTimestamp(1, new java.sql.Timestamp(fromDate.getTime()));
            bmwGrantedBeyondTimePs.setTimestamp(2, new java.sql.Timestamp(toDate.getTime()));
            PreparedStatement bmwRejectedWithinTimePs = con.prepareStatement("SELECT COUNT (*) FROM bmw_all_summary_report WHERE " +
                    " app_del = FALSE and application_status = 'rejected' AND pending_since - application_receipt_date  <= '120 days' AND " +
                    "application_receipt_date >= ? AND application_receipt_date <= ?");
            bmwRejectedWithinTimePs.setTimestamp(1, new java.sql.Timestamp(fromDate.getTime()));
            bmwRejectedWithinTimePs.setTimestamp(2, new java.sql.Timestamp(toDate.getTime()));
            PreparedStatement bmwRejectedBeyondTimePs = con.prepareStatement("SELECT COUNT (*) FROM bmw_all_summary_report WHERE " +
                    " app_del = FALSE and application_status = 'rejected' AND pending_since - application_receipt_date  > '120 days' AND " +
                    "application_receipt_date >= ? AND application_receipt_date <= ?");
            bmwRejectedBeyondTimePs.setTimestamp(1, new java.sql.Timestamp(fromDate.getTime()));
            bmwRejectedBeyondTimePs.setTimestamp(2, new java.sql.Timestamp(toDate.getTime()));
            PreparedStatement bmwPendingWithinTimePs = con.prepareStatement("SELECT COUNT (*) FROM bmw_all_summary_report WHERE " +
                    " app_del = FALSE and application_status = 'pending' AND application_receipt_date >= ? AND application_receipt_date <= ? AND " +
                    "application_receipt_date >= ? AND application_receipt_date <= ?");
            bmwPendingWithinTimePs.setTimestamp(1, new java.sql.Timestamp(today120.getTime()));
            bmwPendingWithinTimePs.setTimestamp(2, new java.sql.Timestamp(today.getTime()));
            bmwPendingWithinTimePs.setTimestamp(3, new java.sql.Timestamp(fromDate.getTime()));
            bmwPendingWithinTimePs.setTimestamp(4, new java.sql.Timestamp(toDate.getTime()));
            PreparedStatement bmwPendingBeyondTimePs = con.prepareStatement("SELECT COUNT (*) FROM bmw_all_summary_report WHERE " +
                    " app_del = FALSE and application_status = 'pending' AND application_receipt_date < ? AND " +
                    "application_receipt_date >= ? AND application_receipt_date <= ?");
            bmwPendingBeyondTimePs.setTimestamp(1, new java.sql.Timestamp(today120.getTime()));
            bmwPendingBeyondTimePs.setTimestamp(2, new java.sql.Timestamp(fromDate.getTime()));
            bmwPendingBeyondTimePs.setTimestamp(3, new java.sql.Timestamp(toDate.getTime()));

            ResultSet bmwGrantedWithinTimeRs = bmwGrantedWithinTimePs.executeQuery();
            ResultSet bmwGrantedBeyondTimeRs = bmwGrantedBeyondTimePs.executeQuery();
            ResultSet bmwRejectedWithinTimeRs = bmwRejectedWithinTimePs.executeQuery();
            ResultSet bmwRejectedBeyondTimeRs = bmwRejectedBeyondTimePs.executeQuery();
            ResultSet bmwPendingWithinTimeRs = bmwPendingWithinTimePs.executeQuery();
            ResultSet bmwPendingBeyondTimeRs = bmwPendingBeyondTimePs.executeQuery();

            if(bmwGrantedWithinTimeRs.next()){
                bmwGrantedWithinTime = bmwGrantedWithinTimeRs.getLong(1);
            }
            if(bmwGrantedBeyondTimeRs.next()){
                bmwGrantedBeyondTime = bmwGrantedBeyondTimeRs.getLong(1);
            }
            if(bmwRejectedWithinTimeRs.next()){
                bmwRejectedWithinTime = bmwRejectedWithinTimeRs.getLong(1);
            }
            if(bmwRejectedBeyondTimeRs.next()){
                bmwRejectedBeyondTime = bmwRejectedBeyondTimeRs.getLong(1);
            }
            if(bmwPendingWithinTimeRs.next()){
                bmwPendingWithinTime = bmwPendingWithinTimeRs.getLong(1);
            }
            if(bmwPendingBeyondTimeRs.next()){
                bmwPendingBeyondTime = bmwPendingBeyondTimeRs.getLong(1);
            }
            bmwReceivedCount = bmwGrantedWithinTime + bmwGrantedBeyondTime +  bmwRejectedWithinTime + bmwRejectedBeyondTime + bmwPendingWithinTime+ bmwPendingBeyondTime;
            // ==============================================BMW ENDS ==================================================

            if(moduleType.equals("cto")){
                countSingleModule = new CountSingleModule("cto", ctoGrantedBeyondTime, ctoGrantedWithinTime,
                        ctoPendingBeyondTime, 0L, ctoPendingWithinTime, ctoGrantedBeyondTime+ctoGrantedWithinTime,
                        ctoPendingBeyondTime+ctoPendingWithinTime, ctoReceivedCount);
            }else if(moduleType.equals("hwm")){
                countSingleModule = new CountSingleModule("hwm", hwmGrantedBeyondTime, hwmGrantedWithinTime,
                        hwmPendingBeyondTime, 0L, hwmPendingWithinTime, hwmGrantedBeyondTime+hwmGrantedWithinTime,
                        hwmPendingBeyondTime+hwmPendingWithinTime, hwmReceivedCount);

            }else if(moduleType.equals("bmw")){
                countSingleModule = new CountSingleModule("bmw", bmwGrantedBeyondTime, bmwGrantedWithinTime,
                        bmwPendingBeyondTime, 0L, bmwPendingWithinTime, bmwGrantedBeyondTime+bmwGrantedWithinTime,
                        bmwPendingBeyondTime+bmwPendingWithinTime, bmwReceivedCount);
            }else if(moduleType.equals("all")){
                countSingleModule = new CountSingleModule("cto", ctoGrantedBeyondTime, ctoGrantedWithinTime,
                        ctoPendingBeyondTime, 0L, ctoPendingWithinTime, ctoGrantedBeyondTime+ctoGrantedWithinTime,
                        ctoPendingBeyondTime+ctoPendingWithinTime, ctoReceivedCount);
                countSingleModuleList.add(countSingleModule);
                countSingleModule = new CountSingleModule("hwm", hwmGrantedBeyondTime, hwmGrantedWithinTime,
                        hwmPendingBeyondTime, 0L, hwmPendingWithinTime, hwmGrantedBeyondTime+hwmGrantedWithinTime,
                        hwmPendingBeyondTime+hwmPendingWithinTime, hwmReceivedCount);
                countSingleModuleList.add(countSingleModule);
                countSingleModule = new CountSingleModule("bmw", bmwGrantedBeyondTime, bmwGrantedWithinTime,
                        bmwPendingBeyondTime, 0L, bmwPendingWithinTime, bmwGrantedBeyondTime+bmwGrantedWithinTime,
                        bmwPendingBeyondTime+bmwPendingWithinTime, bmwReceivedCount);
                countSingleModuleList.add(countSingleModule);

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


        if(!moduleType.equals("all")){
            countSingleModuleList.add(countSingleModule);
        }
        return countSingleModuleList;
    }
}
