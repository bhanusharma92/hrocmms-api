package in.nic.hrocmms.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class WasteTrack {

    private String indName;
    private String wasteType;
    private String sourceName;
    private String mfQty;
    private String tsdfIndustry;
    private String vehicleNo;

    public WasteTrack(){}

    public WasteTrack(String indName, String wasteType, String sourceName,
                      String mfQty, String tsdfIndustry, String vehicleNo) {
        this.indName = indName;
        this.wasteType = wasteType;
        this.sourceName = sourceName;
        this.mfQty = mfQty;
        this.tsdfIndustry = tsdfIndustry;
        this.vehicleNo = vehicleNo;
    }

    public String getIndName() {
        return indName;
    }

    public void setIndName(String indName) {
        this.indName = indName;
    }

    public String getWasteType() {
        return wasteType;
    }

    public void setWasteType(String wasteType) {
        this.wasteType = wasteType;
    }

    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

    public String getMfQty() {
        return mfQty;
    }

    public void setMfQty(String mfQty) {
        this.mfQty = mfQty;
    }

    public String getTsdfIndustry() {
        return tsdfIndustry;
    }

    public void setTsdfIndustry(String tsdfInd) {
        this.tsdfIndustry = tsdfInd;
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public void setVehicleNo(String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }

}
