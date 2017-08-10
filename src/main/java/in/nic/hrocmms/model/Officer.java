package in.nic.hrocmms.model;

public class Officer {
    String officerId;
    String officerName;
    String officerEmail;
    String officerMobile;
    String officerDesignation;

    public Officer() {
        this.officerId = "";
        this.officerName = "";
        this.officerEmail = "";
        this.officerMobile = "";
        this.officerDesignation = "";
    }

    public Officer(String officerId, String officerName, String officerEmail,
                   String officerMobile, String officerDesignation) {
        this.officerId = officerId;
        this.officerName = officerName;
        this.officerEmail = officerEmail;
        this.officerMobile = officerMobile;
        this.officerDesignation = officerDesignation;
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

    public String getOfficerEmail() {
        return officerEmail;
    }

    public void setOfficerEmail(String officerEmail) {
        this.officerEmail = officerEmail;
    }

    public String getOfficerMobile() {
        return officerMobile;
    }

    public void setOfficerMobile(String officerMobile) {
        this.officerMobile = officerMobile;
    }

    public String getOfficerDesignation() {
        return officerDesignation;
    }

    public void setOfficerDesignation(String officerDesignation) {
        this.officerDesignation = officerDesignation;
    }
}
