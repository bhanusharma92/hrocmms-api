package in.nic.hrocmms.model;


public class Industry {
    private String factoryUniqueId;
    private String establishmentName;
    private String district;
    private String tehsil;
    private String pinCode;
    private String address;
    private String occupierName;
    private String mobile;
    private String email;
    private String businessType;
    private String registrationDate;
    private String licenceValidDate;
    private String loginId;

    public Industry() {
        this.factoryUniqueId = "";
        this.establishmentName = "";
        this.district = "";
        this.tehsil = "";
        this.pinCode = "";
        this.address = "";
        this.occupierName = "";
        this.mobile = "";
        this.email = "";
        this.businessType = "";
        this.registrationDate = "";
        this.licenceValidDate = "";
        this.loginId = "";
    }

    public Industry(String factoryUniqueId, String establishmentName,
                    String district, String tehsil, String pinCode, String address,
                    String occupierName, String mobile, String email, String businessType,
                    String registrationDate, String licenceValidDate, String loginId) {
        this.factoryUniqueId = factoryUniqueId;
        this.establishmentName = establishmentName;
        this.district = district;
        this.tehsil = tehsil;
        this.pinCode = pinCode;
        this.address = address;
        this.occupierName = occupierName;
        this.mobile = mobile;
        this.email = email;
        this.businessType = businessType;
        this.registrationDate = registrationDate;
        this.licenceValidDate = licenceValidDate;
        this.loginId = loginId;
    }

    public String getFactoryUniqueId() {
        return factoryUniqueId;
    }

    public void setFactoryUniqueId(String factoryUniqueId) {
        this.factoryUniqueId = factoryUniqueId;
    }

    public String getEstablishmentName() {
        return establishmentName;
    }

    public void setEstablishmentName(String establishmentName) {
        this.establishmentName = establishmentName;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getTehsil() {
        return tehsil;
    }

    public void setTehsil(String tehsil) {
        this.tehsil = tehsil;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOccupierName() {
        return occupierName;
    }

    public void setOccupierName(String occupierName) {
        this.occupierName = occupierName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getLicenceValidDate() {
        return licenceValidDate;
    }

    public void setLicenceValidDate(String licenceValidDate) {
        this.licenceValidDate = licenceValidDate;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }
}
