package cafefashionsociety.structureliteraturemeadow.model.forms;

import cafefashionsociety.structureliteraturemeadow.config.UtilityBeans;
import cafefashionsociety.structureliteraturemeadow.model.Note;

public class NoteForm {

    String username;
    String profileId;
    String incidentDate;
    String title;
    String what;
    String soWhat;
    String tags;

    public NoteForm() {
    }

    public NoteForm(String username, String profileId, String incidentDate, String title, String what, String soWhat,
            String tags) {
        this.username = username;
        this.profileId = profileId;
        this.incidentDate = incidentDate;
        this.title = title;
        this.what = what;
        this.soWhat = soWhat;
        this.tags = tags;

    }

    public Note toNote() {
        UtilityBeans utilityBeans = new UtilityBeans();
        return new Note(utilityBeans.createUUIDString(),
                username, profileId, incidentDate, title, what,
                soWhat, tags);
    }

    public String getProfileId() {
        return profileId;
    }

    public void setProfileId(String profileId) {
        this.profileId = profileId;
    }

    public String getIncidentDate() {
        return incidentDate;
    }

    public void setIncidentDate(String incidentDate) {
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
