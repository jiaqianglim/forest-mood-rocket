package cafefashionsociety.structureliteraturemeadow.model;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

@RedisHash
public class Profile {

    @Id
    private String id;
    private String displayName;
    private String organisationEmail;
    @Indexed
    private String organisationName;
    private String organisationRole;
    @Indexed
    private String organisationId;
    private Boolean organisationSearchable = false;
    private String pictureURL;
    @Indexed
    private String userAccId;
    private Boolean currentlyActive;
    private List<Report> createdReports;
    private List<Report> sharedReports;

    public Profile() {
    }

    // Registered at User creation
    public Profile(String displayName, String userAccId) {
        this.id = "p" + UUID.randomUUID().toString();
        this.displayName = displayName + "\'s personal account";
        this.organisationEmail = "";
        this.organisationName = "Personal";
        this.organisationRole = "";
        this.organisationId = "";
        this.organisationSearchable = false;
        this.pictureURL = "";
        this.userAccId = userAccId;
        this.currentlyActive = true;
        this.createdReports = new LinkedList<>();
        this.sharedReports = new LinkedList<>();
    }

    // Add new Profile, take userAccId from user
    public Profile(String displayName, String organisationEmail, String organisationName, String organisationRole,
            String organisationId, Boolean organisationSearchable, String pictureURL, String userAccId,
            Boolean currentlyActive) {
        this.id = "p" + UUID.randomUUID().toString();
        this.displayName = displayName;
        this.organisationEmail = organisationEmail;
        this.organisationName = organisationName;
        this.organisationRole = organisationRole;
        this.organisationId = organisationId;
        this.organisationSearchable = organisationSearchable;
        this.pictureURL = pictureURL;
        this.userAccId = userAccId;
        this.currentlyActive = currentlyActive;
        this.createdReports = new LinkedList<>();
        this.sharedReports = new LinkedList<>();
    }

    // From repo
    public Profile(String id, String displayName, String organisationEmail, String organisationName,
            String organisationRole,
            String organisationId, Boolean organisationSearchable, String pictureURL, String userAccId,
            Boolean currentlyActive, List<Report> createdReports, List<Report> sharedReports) {
        this.id = id;
        this.displayName = displayName;
        this.organisationEmail = organisationEmail;
        this.organisationName = organisationName;
        this.organisationRole = organisationRole;
        this.organisationId = organisationId;
        this.organisationSearchable = organisationSearchable;
        this.pictureURL = pictureURL;
        this.userAccId = userAccId;
        this.currentlyActive = currentlyActive;
        this.createdReports = createdReports;
        this.sharedReports = sharedReports;
    }

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

    public String getOrganisationRole() {
        return organisationRole;
    }

    public void setOrganisationRole(String organisationRole) {
        this.organisationRole = organisationRole;
    }

    public Boolean getOrganisationSearchable() {
        return organisationSearchable;
    }

    public void setOrganisationSearchable(Boolean organisationSearchable) {
        this.organisationSearchable = organisationSearchable;
    }

    public String getOrganisationId() {
        return organisationId;
    }

    public void setOrganisationId(String organisationId) {
        this.organisationId = organisationId;
    }

    public String getPictureURL() {
        return pictureURL;
    }

    public void setPictureURL(String pictureURL) {
        this.pictureURL = pictureURL;
    }

    public String getUserAccId() {
        return userAccId;
    }

    public void setUserAccId(String userAccId) {
        this.userAccId = userAccId;
    }

    public List<Report> getCreatedReports() {
        return createdReports;
    }

    public void setCreatedReports(List<Report> createdReports) {
        this.createdReports = createdReports;
    }

    public List<Report> getSharedReports() {
        return sharedReports;
    }

    public void setSharedReports(List<Report> sharedReports) {
        this.sharedReports = sharedReports;
    }

    public Boolean getCurrentlyActive() {
        return currentlyActive;
    }

    public void setCurrentlyActive(Boolean currentlyActive) {
        this.currentlyActive = currentlyActive;
    }

}
