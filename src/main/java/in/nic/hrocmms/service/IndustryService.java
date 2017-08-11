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
                    "SELECT iu.id, " +
                            "  COALESCE(irm2.ind_name, irm.ind_name), " +
                            "  COALESCE(dm2.district_name , dm.district_name), " +
                            "  COALESCE(tm2.tehsil_name , tm.tehsil_name, ''), " +
                            "  COALESCE(irm2.ind_pin, irm.ind_pin), " +
                            "  COALESCE(irm2.ind_address, irm.ind_address), " +
                            "  COALESCE(irm2.occ_name, irm.occ_name), " +
                            "  COALESCE(irm2.occ_mobile, irm.occ_mobile), " +
                            "  COALESCE(irm2.occ_email, irm.occ_email), " +
                            "  COALESCE(itm2.industry_type , itm.industry_type), " +
                            "  CAST(irm.date_created AS VARCHAR), " +
                            "  CAST(rc.end_date AS VARCHAR), " +
                            "  iu.id " +
                            "FROM ind_user AS iu " +
                            "INNER JOIN industry_reg_master AS irm ON irm.id = iu.industry_reg_master_id " +
                            "LEFT JOIN district_master AS dm ON dm.id = irm.district_id " +
                            "LEFT JOIN tehsil_master AS tm ON tm.id = irm.tehsil_id " +
                            "LEFT JOIN industry_type_master AS itm ON itm.id = irm.industry_type_id " +
                            "LEFT JOIN ind_application_details AS iad ON ( " +
                            "    iad.id = ( " +
                            "      SELECT iad2.id FROM ind_application_details AS iad2 " +
                            "      WHERE iad2.ind_user_universal_id = iu.industry_reg_master_id " +
                            "      ORDER BY iad2.application_date " +
                            "      LIMIT 1 " +
                            "    ) " +
                            "    ) " +
                            "LEFT JOIN record_certificate AS rc ON ( " +
                            "    rc.id = ( " +
                            "      select rc2.id FROM record_certificate AS rc2 " +
                            "      WHERE rc2.application_id_id = iad.id " +
                            "      ORDER BY iu.date_created " +
                            "      LIMIT 1 " +
                            "    ) " +
                            "    ) " +
                            "LEFT JOIN industry_reg_master AS irm2 ON irm2.id = iad.ind_user_id " +
                            "LEFT JOIN district_master AS dm2 ON dm2.id = irm2.district_id " +
                            "LEFT JOIN tehsil_master AS tm2 ON tm2.id = irm2.tehsil_id " +
                            "LEFT JOIN industry_type_master AS itm2 ON itm2.id = irm2.industry_type_id;"
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
                        UtilityService.getFormattedDate(industryRs.getString(11)),
                        UtilityService.getFormattedDate(industryRs.getString(12)),
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

    public List<Industry> getDataByUserId(String userId){
        List<Industry> industryList = new ArrayList<>();
        con = ConnectionManager.getConnection();
        Industry industry;
        try{
            PreparedStatement industryPs = con.prepareStatement(
                    "SELECT iu.id, " +
                            "  COALESCE(irm2.ind_name, irm.ind_name), " +
                            "  COALESCE(dm2.district_name , dm.district_name), " +
                            "  COALESCE(tm2.tehsil_name , tm.tehsil_name, ''), " +
                            "  COALESCE(irm2.ind_pin, irm.ind_pin), " +
                            "  COALESCE(irm2.ind_address, irm.ind_address), " +
                            "  COALESCE(irm2.occ_name, irm.occ_name), " +
                            "  COALESCE(irm2.occ_mobile, irm.occ_mobile), " +
                            "  COALESCE(irm2.occ_email, irm.occ_email), " +
                            "  COALESCE(itm2.industry_type , itm.industry_type), " +
                            "  CAST(irm.date_created AS VARCHAR), " +
                            "  CAST(rc.end_date AS VARCHAR), " +
                            "  iu.id " +
                            "FROM ind_user AS iu " +
                            "INNER JOIN industry_reg_master AS irm ON irm.id = iu.industry_reg_master_id " +
                            "LEFT JOIN district_master AS dm ON dm.id = irm.district_id " +
                            "LEFT JOIN tehsil_master AS tm ON tm.id = irm.tehsil_id " +
                            "LEFT JOIN industry_type_master AS itm ON itm.id = irm.industry_type_id " +
                            "LEFT JOIN ind_application_details AS iad ON ( " +
                            "    iad.id = ( " +
                            "      SELECT iad2.id FROM ind_application_details AS iad2 " +
                            "      WHERE iad2.ind_user_universal_id = iu.industry_reg_master_id " +
                            "      ORDER BY iad2.application_date " +
                            "      LIMIT 1 " +
                            "    ) " +
                            "    ) " +
                            "LEFT JOIN record_certificate AS rc ON ( " +
                            "    rc.id = ( " +
                            "      select rc2.id FROM record_certificate AS rc2 " +
                            "      WHERE rc2.application_id_id = iad.id " +
                            "      ORDER BY iu.date_created " +
                            "      LIMIT 1 " +
                            "    ) " +
                            "    ) " +
                            "LEFT JOIN industry_reg_master AS irm2 ON irm2.id = iad.ind_user_id " +
                            "LEFT JOIN district_master AS dm2 ON dm2.id = irm2.district_id " +
                            "LEFT JOIN tehsil_master AS tm2 ON tm2.id = irm2.tehsil_id " +
                            "LEFT JOIN industry_type_master AS itm2 ON itm2.id = irm2.industry_type_id " +
                            "WHERE iu.id = ?"
            );
            industryPs.setString(1, userId);
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
                        UtilityService.getFormattedDate(industryRs.getString(11)),
                        UtilityService.getFormattedDate(industryRs.getString(12)),
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
