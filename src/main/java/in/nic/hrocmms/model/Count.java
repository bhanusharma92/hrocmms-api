package in.nic.hrocmms.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Count {

    private Long ctoRa;
    private Long ctoGwt;
    private Long ctoGbt;
    private Long ctoRwt;
    private Long ctoRbt;
    private Long ctoPwt;
    private Long ctoPbt;

    private Long hwmRa;
    private Long hwmGwt;
    private Long hwmGbt;
    private Long hwmRwt;
    private Long hwmRbt;
    private Long hwmPwt;
    private Long hwmPbt;

    private Long bmwRa;
    private Long bmwGwt;
    private Long bmwGbt;
    private Long bmwRwt;
    private Long bmwRbt;
    private Long bmwPwt;
    private Long bmwPbt;

    public Count(){
        this.ctoRa = 0L;
        this.ctoGwt = 0L;
        this.ctoGbt = 0L;
        this.ctoRwt = 0L;
        this.ctoRbt = 0L;
        this.ctoPwt = 0L;
        this.ctoPbt = 0L;
        this.hwmRa = 0L;
        this.hwmGwt = 0L;
        this.hwmGbt = 0L;
        this.hwmRwt = 0L;
        this.hwmRbt = 0L;
        this.hwmPwt = 0L;
        this.hwmPbt = 0L;
        this.bmwRa = 0L;
        this.bmwGwt = 0L;
        this.bmwGbt = 0L;
        this.bmwRwt = 0L;
        this.bmwRbt = 0L;
        this.bmwPwt = 0L;
        this.bmwPbt = 0L;
    }

    public Count(Long ctoRa, Long ctoGwt, Long ctoGbt, Long ctoRwt, Long ctoRbt, Long ctoPwt, Long ctoPbt,
                 Long hwmRa, Long hwmGwt, Long hwmGbt, Long hwmRwt, Long hwmRbt, Long hwmPwt, Long hwmPbt,
                 Long bmwRa, Long bmwGwt, Long bmwGbt, Long bmwRwt, Long bmwRbt, Long bmwPwt, Long bmwPbt) {
        this.ctoRa = ctoRa;
        this.ctoGwt = ctoGwt;
        this.ctoGbt = ctoGbt;
        this.ctoRwt = ctoRwt;
        this.ctoRbt = ctoRbt;
        this.ctoPwt = ctoPwt;
        this.ctoPbt = ctoPbt;
        this.hwmRa = hwmRa;
        this.hwmGwt = hwmGwt;
        this.hwmGbt = hwmGbt;
        this.hwmRwt = hwmRwt;
        this.hwmRbt = hwmRbt;
        this.hwmPwt = hwmPwt;
        this.hwmPbt = hwmPbt;
        this.bmwRa = bmwRa;
        this.bmwGwt = bmwGwt;
        this.bmwGbt = bmwGbt;
        this.bmwRwt = bmwRwt;
        this.bmwRbt = bmwRbt;
        this.bmwPwt = bmwPwt;
        this.bmwPbt = bmwPbt;
    }

    public Long getCtoRa() {
        return ctoRa;
    }

    public void setCtoRa(Long ctoRa) {
        this.ctoRa = ctoRa;
    }

    public Long getCtoGwt() {
        return ctoGwt;
    }

    public void setCtoGwt(Long ctoGwt) {
        this.ctoGwt = ctoGwt;
    }

    public Long getCtoGbt() {
        return ctoGbt;
    }

    public void setCtoGbt(Long ctoGbt) {
        this.ctoGbt = ctoGbt;
    }

    public Long getCtoRwt() {
        return ctoRwt;
    }

    public void setCtoRwt(Long ctoRwt) {
        this.ctoRwt = ctoRwt;
    }

    public Long getCtoRbt() {
        return ctoRbt;
    }

    public void setCtoRbt(Long ctoRbt) {
        this.ctoRbt = ctoRbt;
    }

    public Long getCtoPwt() {
        return ctoPwt;
    }

    public void setCtoPwt(Long ctoPwt) {
        this.ctoPwt = ctoPwt;
    }

    public Long getCtoPbt() {
        return ctoPbt;
    }

    public void setCtoPbt(Long ctoPbt) {
        this.ctoPbt = ctoPbt;
    }

    public Long getHwmRa() {
        return hwmRa;
    }

    public void setHwmRa(Long hwmRa) {
        this.hwmRa = hwmRa;
    }

    public Long getHwmGwt() {
        return hwmGwt;
    }

    public void setHwmGwt(Long hwmGwt) {
        this.hwmGwt = hwmGwt;
    }

    public Long getHwmGbt() {
        return hwmGbt;
    }

    public void setHwmGbt(Long hwmGbt) {
        this.hwmGbt = hwmGbt;
    }

    public Long getHwmRwt() {
        return hwmRwt;
    }

    public void setHwmRwt(Long hwmRwt) {
        this.hwmRwt = hwmRwt;
    }

    public Long getHwmRbt() {
        return hwmRbt;
    }

    public void setHwmRbt(Long hwmRbt) {
        this.hwmRbt = hwmRbt;
    }

    public Long getHwmPwt() {
        return hwmPwt;
    }

    public void setHwmPwt(Long hwmPwt) {
        this.hwmPwt = hwmPwt;
    }

    public Long getHwmPbt() {
        return hwmPbt;
    }

    public void setHwmPbt(Long hwmPbt) {
        this.hwmPbt = hwmPbt;
    }

    public Long getBmwRa() {
        return bmwRa;
    }

    public void setBmwRa(Long bmwRa) {
        this.bmwRa = bmwRa;
    }

    public Long getBmwGwt() {
        return bmwGwt;
    }

    public void setBmwGwt(Long bmwGwt) {
        this.bmwGwt = bmwGwt;
    }

    public Long getBmwGbt() {
        return bmwGbt;
    }

    public void setBmwGbt(Long bmwGbt) {
        this.bmwGbt = bmwGbt;
    }

    public Long getBmwRwt() {
        return bmwRwt;
    }

    public void setBmwRwt(Long bmwRwt) {
        this.bmwRwt = bmwRwt;
    }

    public Long getBmwRbt() {
        return bmwRbt;
    }

    public void setBmwRbt(Long bmwRbt) {
        this.bmwRbt = bmwRbt;
    }

    public Long getBmwPwt() {
        return bmwPwt;
    }

    public void setBmwPwt(Long bmwPwt) {
        this.bmwPwt = bmwPwt;
    }

    public Long getBmwPbt() {
        return bmwPbt;
    }

    public void setBmwPbt(Long bmwPbt) {
        this.bmwPbt = bmwPbt;
    }
}
