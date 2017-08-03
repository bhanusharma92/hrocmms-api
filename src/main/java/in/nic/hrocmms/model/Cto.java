package in.nic.hrocmms.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Cto {
    private String applicationNo;
    private String industryName;
    private String district;
    private String nameOfOwner;
    private String typeOfApplication;
    private String dateOfReceivingApplicaton;
    private String DateOfGrantReject;
    private String status;

    public Cto() {
    }

    public Cto(String applicationNo, String industryName, String district, String nameOfOwner,
               String typeOfApplication, String dateOfReceivingApplicaton, String dateOfGrantReject, String status) {
        this.applicationNo = applicationNo;
        this.industryName = industryName;
        this.district = district;
        this.nameOfOwner = nameOfOwner;
        this.typeOfApplication = typeOfApplication;
        this.dateOfReceivingApplicaton = dateOfReceivingApplicaton;
        DateOfGrantReject = dateOfGrantReject;
        this.status = status;
    }

    public String getApplicationNo() {
        return applicationNo;
    }

    public void setApplicationNo(String applicationNo) {
        this.applicationNo = applicationNo;
    }

    public String getIndustryName() {
        return industryName;
    }

    public void setIndustryName(String industryName) {
        this.industryName = industryName;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getNameOfOwner() {
        return nameOfOwner;
    }

    public void setNameOfOwner(String nameOfOwner) {
        this.nameOfOwner = nameOfOwner;
    }

    public String getTypeOfApplication() {
        return typeOfApplication;
    }

    public void setTypeOfApplication(String typeOfApplication) {
        this.typeOfApplication = typeOfApplication;
    }

    public String getDateOfReceivingApplicaton() {
        return dateOfReceivingApplicaton;
    }

    public void setDateOfReceivingApplicaton(String dateOfReceivingApplicaton) {
        this.dateOfReceivingApplicaton = dateOfReceivingApplicaton;
    }

    public String getDateOfGrantReject() {
        return DateOfGrantReject;
    }

    public void setDateOfGrantReject(String dateOfGrantReject) {
        DateOfGrantReject = dateOfGrantReject;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
