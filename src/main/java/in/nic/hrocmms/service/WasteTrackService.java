package in.nic.hrocmms.service;

import in.nic.hrocmms.database.ConnectionManager;
import in.nic.hrocmms.model.WasteTrack;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class WasteTrackService {

    private Connection con;

    public List<WasteTrack> getData(String vehicleNo){
        WasteTrack wasteTrack;
        con = ConnectionManager.getConnection();
        List<WasteTrack> wasteTrackList = new ArrayList<>();
        try{
            PreparedStatement wasteTrackApplication = con.prepareStatement(
                    "select ir.ind_name, i.waste_type, hs.name, i.qty_mt,i.tsdf_industry,i.trans_reg_number_withtsdf from waste_track_applicationdetails i Inner Join industry_reg_master ir on i.industry_reg_master_id = ir.id Inner Join hazardous_source_gen_master hs on hs.id = i.source_name_id where i.trans_reg_number_withtsdf='"
                            + vehicleNo + "'"
            );
            ResultSet wasteTrackApplicationRs = wasteTrackApplication.executeQuery();
            while (wasteTrackApplicationRs.next()) {
                wasteTrack = new WasteTrack(
                        String.valueOf(wasteTrackApplicationRs.getString(1)),
                        wasteTrackApplicationRs.getString(2),
                        wasteTrackApplicationRs.getString(3),
                        wasteTrackApplicationRs.getString(4),
                        wasteTrackApplicationRs.getString(5),
                        wasteTrackApplicationRs.getString(6)
                );
                wasteTrackList.add(wasteTrack);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return wasteTrackList;
    }
}
