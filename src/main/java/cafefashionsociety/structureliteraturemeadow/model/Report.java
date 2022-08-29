package cafefashionsociety.structureliteraturemeadow.model;

import java.time.LocalDate;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

@RedisHash
public class Report {
    // Incident, Task, Reflection, Workshop
    @Id
    private String id;
    @Indexed
    private String userId;
    @Indexed
    private String profileId;
    private LocalDate reportCreationDate;
    private LocalDate incidentDate;
    private String title;
    private String what;
    private String soWhat;
    @Indexed
    private String tags;

    public Report() {
    }

    // Create new report from POST
    public Report(String userId, String profileId, LocalDate incidentDate, String title, String what, String soWhat,
            String tags) {
        this.id = "r" + UUID.randomUUID().toString();
        this.userId = userId;
        this.profileId = profileId;
        this.reportCreationDate = LocalDate.now();
        this.incidentDate = incidentDate;
        this.title = title;
        this.what = what;
        this.soWhat = soWhat;
        this.tags = tags;
    }

    // Create report from repo
    public Report(String id, String userId, String profileId, LocalDate reportCreationDate, LocalDate incidentDate,
            String title, String what, String soWhat, String tags) {
        this.id = id;
        this.userId = userId;
        this.profileId = profileId;
        this.reportCreationDate = reportCreationDate;
        this.incidentDate = incidentDate;
        this.title = title;
        this.what = what;
        this.soWhat = soWhat;
        this.tags = tags;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getProfileId() {
        return profileId;
    }

    public void setProfileId(String profileId) {
        this.profileId = profileId;
    }

    public LocalDate getincidentDate() {
        return incidentDate;
    }

    public void setincidentDate(LocalDate incidentDate) {
        this.incidentDate = incidentDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWhat() {
        return what;
    }

    public void setWhat(String what) {
        this.what = what;
    }

    public String getSoWhat() {
        return soWhat;
    }

    public void setSoWhat(String soWhat) {
        this.soWhat = soWhat;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public LocalDate getreportCreationDate() {
        return reportCreationDate;
    }

    public void setreportCreationDate(LocalDate reportCreationDate) {
        this.reportCreationDate = reportCreationDate;
    }

}
