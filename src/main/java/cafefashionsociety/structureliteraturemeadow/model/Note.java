package cafefashionsociety.structureliteraturemeadow.model;

import java.io.Serializable;
import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@RedisHash
public class Note implements Serializable {

    @Id
    private String id;
    private String userId;
    private String profileId;
    private LocalDate noteCreationDate;
    private LocalDate incidentDate;
    private String title;
    private String what;
    private String soWhat;
    private String tags;

    public Note() {
    }

    // New Note
    public Note(String id, String userId, String profileId, LocalDate incidentDate, String title, String what,
            String soWhat, String tags) {
        this.id = "n" + id;
        this.userId = userId;
        this.profileId = profileId;
        this.noteCreationDate = LocalDate.now();
        this.incidentDate = incidentDate;
        this.title = title;
        this.what = what;
        this.soWhat = soWhat;
        this.tags = tags;
    }

    // Full
    public Note(String id, String userId, String profileId, LocalDate noteCreationDate, LocalDate incidentDate,
            String title, String what, String soWhat, String tags) {
        this.id = id;
        this.userId = userId;
        this.profileId = profileId;
        this.noteCreationDate = noteCreationDate;
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

    public LocalDate getnoteCreationDate() {
        return noteCreationDate;
    }

    public void setnoteCreationDate(LocalDate noteCreationDate) {
        this.noteCreationDate = noteCreationDate;
    }

}
