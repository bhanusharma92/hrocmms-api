package in.nic.hrocmms.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Test {
    private String actionTaken;
    private String commentByUserLogin;
    private String commentDate;
    private String comments;
    private String id;
    private String projectid;
    private String serviceid;

    public Test(){

    }

    public Test(String actionTaken, String commentByUserLogin, String commentDate, String comments, String id, String projectid, String serviceid) {
        this.actionTaken = actionTaken;
        this.commentByUserLogin = commentByUserLogin;
        this.commentDate = commentDate;
        this.comments = comments;
        this.id = id;
        this.projectid = projectid;
        this.serviceid = serviceid;
    }

    public String getActionTaken() {
        return actionTaken;
    }

    public void setActionTaken(String actionTaken) {
        this.actionTaken = actionTaken;
    }

    public String getCommentByUserLogin() {
        return commentByUserLogin;
    }

    public void setCommentByUserLogin(String commentByUserLogin) {
        this.commentByUserLogin = commentByUserLogin;
    }

    public String getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(String commentDate) {
        this.commentDate = commentDate;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProjectid() {
        return projectid;
    }

    public void setProjectid(String projectid) {
        this.projectid = projectid;
    }

    public String getServiceid() {
        return serviceid;
    }

    public void setServiceid(String serviceid) {
        this.serviceid = serviceid;
    }
}
