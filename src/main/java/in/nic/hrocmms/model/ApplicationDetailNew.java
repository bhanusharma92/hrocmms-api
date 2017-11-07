package in.nic.hrocmms.model;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ApplicationDetailNew {

    String applicationNo;
    String dateOfIssue;
    String validUpTo;
    String fileNo;
    String message;
    String link;

    public ApplicationDetailNew() {
    }


    public ApplicationDetailNew(String message)
    {
        this.message = message;

    }

    public ApplicationDetailNew(String applicationNo, String dateOfIssue, String validUpTo, String fileNo)
    {
        this.dateOfIssue = dateOfIssue;
        this.applicationNo = applicationNo;
        this.validUpTo = validUpTo;
        this.fileNo = fileNo;
    }

    public ApplicationDetailNew(String applicationNo, String dateOfIssue, String validUpTo, String fileNo, String link)
    {
        this.dateOfIssue = dateOfIssue;
        this.applicationNo = applicationNo;
        this.validUpTo = validUpTo;
        this.fileNo = fileNo;
        this.link = link;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getApplicationNo() {
        return applicationNo;
    }

    public void setApplicationNo(String applicationNo) {
        this.applicationNo = applicationNo;
    }

    public String getDateOfIssue() {
        return dateOfIssue;
    }

    public void setDateOfIssue(String dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
    }

    public String getValidUpTo() {
        return validUpTo;
    }

    public void setValidUpTo(String validUpTo) {
        this.validUpTo = validUpTo;
    }

    public String getFileNo() {
        return fileNo;
    }

    public void setFileNo(String fileNo) {
        this.fileNo = fileNo;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
