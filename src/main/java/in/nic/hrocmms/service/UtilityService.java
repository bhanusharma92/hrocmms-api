package in.nic.hrocmms.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UtilityService {
    public static boolean validDateSuppliedCheck(String fromDate, String toDate){
        if(fromDate == null || toDate == null){
            return false;
        }
        Date date1 = null;
        Date date2 = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");
            date1 = sdf.parse(fromDate);
            if (!fromDate.equals(sdf.format(date1))) {
                date1 = null;
            }
            date2 = sdf.parse(toDate);
            if (!toDate.equals(sdf.format(date2))) {
                date2 = null;
            }
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        if (date1 == null || date2 == null) {
            return false;
        } else {
            return true;
        }
    }

    static public String getChoice(String ra, String gwt, String gbt, String rwt, String rbt, String pwt, String pbt){
        if(ra != null && ra.equals("1")){
            return "ra";
        }else if(gwt != null && gwt.equals("1")){
            return "gwt";
        }else if(gbt != null && gbt.equals("1")){
            return "gbt";
        }else if(rwt != null && rwt.equals("1")){
            return "rwt";
        }else if(rbt != null && rbt.equals("1")){
            return "rbt";
        }else if(pwt != null && pwt.equals("1")){
            return "pwt";
        }else if(pbt != null && pbt.equals("1")){
            return "pbt";
        }else{
            return "ra";
        }
    }

    public static String getFormattedDateIfInputDateIsValid(String inputDate, String applicationStatus){
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
        Date outputDate;
        try{
            if(applicationStatus.equals("pending")){
                return "";
            }else{
                outputDate = sdf2.parse(inputDate);
                return sdf1.format(outputDate);
            }
        }catch (Exception e){
            e.printStackTrace();
                return "";
        }
    }

    public static String getFormattedDate(String inputDate){
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
        Date outputDate;
        try{
                outputDate = sdf2.parse(inputDate);
                return sdf1.format(outputDate);
        }catch (Exception e){
            e.printStackTrace();
            return "";
        }
    }


}
