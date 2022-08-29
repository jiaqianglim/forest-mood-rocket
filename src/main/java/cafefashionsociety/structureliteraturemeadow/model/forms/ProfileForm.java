package cafefashionsociety.structureliteraturemeadow.model.forms;

public class ProfileForm {
    private String displayName;
    private String organisationEmail;
    private String organisationName;
    private String organisationRole;
    private Boolean organisationSearchable=false;
    private String organisationId;
    private String pictureURL;
    private Boolean currentlyActive=false;

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

    public Boolean getCurrentlyActive() {
        return currentlyActive;
    }

    public void setCurrentlyActive(Boolean currentlyActive) {
        this.currentlyActive = currentlyActive;
    }

}
