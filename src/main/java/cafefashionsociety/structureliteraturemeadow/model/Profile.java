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
    private List<String> createdReportsIds;
    private List<String> sharedReportsIds;

    public Profile() {
    }

    // Registered at User creation
    public Profile(String displayName, String userAccId) {
        this.id = "p" + UUID.randomUUID().toString();
        this.displayName = "Your personal account";
        this.organisationEmail = "";
        this.organisationName = "Personal and Private";
        this.organisationRole = "";
        this.organisationId = "";
        this.organisationSearchable = false;
        this.pictureURL = "";
        this.userAccId = userAccId;
        this.currentlyActive = true;
        this.createdReportsIds = new LinkedList<>();
        this.sharedReportsIds = new LinkedList<>();
        createdReportsIds.add("r00000000-00000000-00000000-00000000");
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
        this.createdReportsIds = new LinkedList<>();
        this.sharedReportsIds = new LinkedList<>();
    }

    // From repo
    public Profile(String id, String displayName, String organisationEmail, String organisationName,
            String organisationRole,
            String organisationId, Boolean organisationSearchable, String pictureURL, String userAccId,
            Boolean currentlyActive, List<String> createdReportsIds, List<String> sharedReportsIds) {
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
        this.createdReportsIds = createdReportsIds;
        this.sharedReportsIds = sharedReportsIds;
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

    public Boolean getCurrentlyActive() {
        return currentlyActive;
    }

    public void setCurrentlyActive(Boolean currentlyActive) {
        this.currentlyActive = currentlyActive;
    }

    public List<String> getCreatedReportsIds() {
        return createdReportsIds;
    }

    public void setCreatedReportsIds(List<String> createdReportsIds) {
        this.createdReportsIds = createdReportsIds;
    }

    public List<String> getSharedReportsIds() {
        return sharedReportsIds;
    }

    public void setSharedReportsIds(List<String> sharedReportsIds) {
        this.sharedReportsIds = sharedReportsIds;
    }

}
