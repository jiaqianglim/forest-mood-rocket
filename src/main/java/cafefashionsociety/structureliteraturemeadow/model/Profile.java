package cafefashionsociety.structureliteraturemeadow.model;

import java.util.Deque;
import java.util.LinkedList;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@RedisHash
public class Profile {

    @Id
    private String id;
    private String displayName;
    private String organisationEmail;
    private String organisationName;
    private String organisationRole;
    private String organisationId;
    private Boolean organisationSearchable = false;
    private String pictureURL;
    private String userAccId;
    private Boolean currentlyActive;
    private Deque<String> createdReports;
    private Deque<String> linkedProfiles;
    private Deque<String> sharedReports;

    public Profile() {
    }

    // Add Profile
    public Profile(String id, String displayName, String organisationEmail, String organisationName,
            String organisationRole,
            String organisationId, Boolean organisationSearchable, String pictureURL, String userAccId,
            Boolean currentlyActive) {
        this.id = "p" + id;
        this.displayName = displayName;
        this.organisationEmail = organisationEmail;
        this.organisationName = organisationName;
        this.organisationRole = organisationRole;
        this.organisationId = organisationId;
        this.organisationSearchable = organisationSearchable;
        this.pictureURL = pictureURL;
        this.userAccId = userAccId;
        this.currentlyActive = currentlyActive;
        this.createdReports = new LinkedList<String>();
        this.linkedProfiles = new LinkedList<String>();
        this.sharedReports = new LinkedList<String>();
    }

    // Full
    public Profile(String id, String displayName, String organisationEmail, String organisationName,
            String organisationRole,
            String organisationId, Boolean organisationSearchable, String pictureURL, String userAccId,
            Boolean currentlyActive, Deque<String> createdReports, Deque<String> linkedProfiles,
            Deque<String> sharedReports) {
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
        this.linkedProfiles = linkedProfiles;
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

    public Deque<String> getLinkedProfiles() {
        return linkedProfiles;
    }

    public void setLinkedProfiles(Deque<String> linkedProfiles) {
        this.linkedProfiles = linkedProfiles;
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

    public Boolean getCurrentlyActive() {
        return currentlyActive;
    }

    public void setCurrentlyActive(Boolean currentlyActive) {
        this.currentlyActive = currentlyActive;
    }

    public Deque<String> getCreatedReports() {
        return createdReports;
    }

    public void setCreatedReports(Deque<String> createdReports) {
        this.createdReports = createdReports;
    }

    public Deque<String> getSharedReports() {
        return sharedReports;
    }

    public void setSharedReports(Deque<String> sharedReports) {
        this.sharedReports = sharedReports;
    }

}
