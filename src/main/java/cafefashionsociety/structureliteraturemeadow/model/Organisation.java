package cafefashionsociety.structureliteraturemeadow.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@RedisHash
public class Organisation {

    @Id
    private String id;
    private String displayName;
    private String organisationEmail;
    private String organisationName;
    private String pictureURL;
    private List<Profile> userProfiles;
    private List<Profile> previousUserProfiles;
    private List<Profile> adminProfiles;
    private List<Report> flaggedReports;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getOrganisationEmail() {
        return organisationEmail;
    }

    public void setOrganisationEmail(String organisationEmail) {
        this.organisationEmail = organisationEmail;
    }

    public String getOrganisationName() {
        return organisationName;
    }

    public void setOrganisationName(String organisationName) {
        this.organisationName = organisationName;
    }

    public String getPictureURL() {
        return pictureURL;
    }

    public void setPictureURL(String pictureURL) {
        this.pictureURL = pictureURL;
    }

    public List<Profile> getUserProfiles() {
        return userProfiles;
    }

    public void setUserProfiles(List<Profile> userProfiles) {
        this.userProfiles = userProfiles;
    }

    public List<Profile> getPreviousUserProfiles() {
        return previousUserProfiles;
    }

    public void setPreviousUserProfiles(List<Profile> previousUserProfiles) {
        this.previousUserProfiles = previousUserProfiles;
    }

    public List<Profile> getAdminProfiles() {
        return adminProfiles;
    }

    public void setAdminProfiles(List<Profile> adminProfiles) {
        this.adminProfiles = adminProfiles;
    }

    public List<Report> getFlaggedReports() {
        return flaggedReports;
    }

    public void setFlaggedReports(List<Report> flaggedReports) {
        this.flaggedReports = flaggedReports;
    }

}
