package in.nic.hrocmms.model;

public class CountSingleModule {
    private String servicename;
    private Long approved_beyond_time;
    private Long approved_within_time;
    private Long pending_beyond_time;
    private Long pending_with_applicant;
    private Long pending_within_time;
    private Long total_approved;
    private Long total_pending;
    private Long total_recieved;

    public CountSingleModule() {
        this.servicename = "";
        this.approved_beyond_time = 0L;
        this.approved_within_time = 0L;
        this.pending_beyond_time = 0L;
        this.pending_with_applicant = 0L;
        this.pending_within_time = 0L;
        this.total_approved = 0L;
        this.total_pending = 0L;
        this.total_recieved = 0L;
    }

    public CountSingleModule(String servicename, Long approved_beyond_time, Long approved_within_time,
                             Long pending_beyond_time, Long pending_with_applicant, Long pending_within_time,
                             Long total_approved, Long total_pending, Long total_recieved) {
        this.servicename = servicename;
        this.approved_beyond_time = approved_beyond_time;
        this.approved_within_time = approved_within_time;
        this.pending_beyond_time = pending_beyond_time;
        this.pending_with_applicant = pending_with_applicant;
        this.pending_within_time = pending_within_time;
        this.total_approved = total_approved;
        this.total_pending = total_pending;
        this.total_recieved = total_recieved;
    }
}
