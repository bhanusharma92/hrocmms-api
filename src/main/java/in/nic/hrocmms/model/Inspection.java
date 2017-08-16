package in.nic.hrocmms.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Inspection {
    private String factoryUniqueId;
    private String inspectionDate;
    private String officerId;
    private String officerName;
    private String officerMobile;
    private String officerEmail;
    private String officerDesignation;
    private String loginId;

    public Inspection() {
        this.factoryUniqueId = "";
        this.inspectionDate = "";
        this.officerId = "";
        this.officerName = "";
        this.officerMobile = "";
        this.officerEmail = "";
        this.officerEmail = "";
        this.officerDesignation = "";
        this.loginId = "";
    }

    public Inspection(String factoryUniqueId, String inspectionDate, String officerId, String officerName,
                      String officerMobile, String officerEmail, String officerDesignation, String loginId) {
        this.factoryUniqueId = factoryUniqueId;
        this.inspectionDate = inspectionDate;
        this.officerId = officerId;
        this.officerName = officerName;
        this.officerMobile = officerMobile;
        this.officerEmail = officerEmail;
        this.officerDesignation = officerDesignation;
        this.loginId = loginId;
    }

    public String getFactoryUniqueId() {
        return factoryUniqueId;
    }

    public void setFactoryUniqueId(String factoryUniqueId) {
        this.factoryUniqueId = factoryUniqueId;
    }

    public String getInspectionDate() {
        return inspectionDate;
    }

    public void setInspectionDate(String inspectionDate) {
        this.inspectionDate = inspectionDate;
    }

    public String getOfficerId() {
        return officerId;
    }

    public void setOfficerId(String officerId) {
        this.officerId = officerId;
    }

    public String getOfficerName() {
        return officerName;
    }

    public void setOfficerName(String officerName) {
        this.officerName = officerName;
    }

    public String getOfficerMobile() {
        return officerMobile;
    }

    public void setOfficerMobile(String officerMobile) {
        this.officerMobile = officerMobile;
    }

    public String getOfficerEmail() {
        return officerEmail;
    }

    public void setOfficerEmail(String officerEmail) {
        this.officerEmail = officerEmail;
    }

    public String getOfficerDesignation() {
        return officerDesignation;
    }

    public void setOfficerDesignation(String officerDesignation) {
        this.officerDesignation = officerDesignation;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }
}
