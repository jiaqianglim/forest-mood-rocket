package cafefashionsociety.structureliteraturemeadow.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@RedisHash
public class Report {
    // Incident, Task, Reflection, Workshop
    @Id
    private String id;
    private String userId;
    private String profileId;
    private Date creationDate;
    private Date incidentnDate;
    private String title;
    private String what;
    private String soWhat;
    private String tags;
    
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
    public Date getCreationDate() {
        return creationDate;
    }
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
    public Date getIncidentnDate() {
        return incidentnDate;
    }
    public void setIncidentnDate(Date incidentnDate) {
        this.incidentnDate = incidentnDate;
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

    
}
