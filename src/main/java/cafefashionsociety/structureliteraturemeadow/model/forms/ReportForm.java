package cafefashionsociety.structureliteraturemeadow.model.forms;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;

import cafefashionsociety.structureliteraturemeadow.config.ProjectConfig;
import cafefashionsociety.structureliteraturemeadow.model.Report;

public class ReportForm {

    private String userAccId;
    private String profileId;
    private LocalDate incidentDate;
    private String title;
    private String what;
    private String soWhat;
    private String tags;

    @Autowired
    ProjectConfig projectConfig;

    public Report toReport() {
        return new Report(projectConfig.createUUIDString(), userAccId, profileId, incidentDate, title, what,
                soWhat, tags);
    }

    public String getProfileId() {
        return profileId;
    }

    public void setProfileId(String profileId) {
        this.profileId = profileId;
    }

    public LocalDate getIncidentDate() {
        return incidentDate;
    }

    public void setIncidentDate(LocalDate incidentDate) {
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

}
