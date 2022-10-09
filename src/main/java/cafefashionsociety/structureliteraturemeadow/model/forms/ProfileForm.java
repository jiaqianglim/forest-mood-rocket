package cafefashionsociety.structureliteraturemeadow.model.forms;

import cafefashionsociety.structureliteraturemeadow.config.UtilityBeans;
import cafefashionsociety.structureliteraturemeadow.model.Profile;

public class ProfileForm {

    private String displayName;
    private String organisationName;
    private String organisationRole;
    private String profileDescription;

    public Profile toProfile() {
        UtilityBeans utilityBeans = new UtilityBeans();
        return new Profile(utilityBeans.createUUIDString(), displayName, organisationName, organisationRole,
                profileDescription);
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
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

    public String getProfileDescription() {
        return profileDescription;
    }

    public void setProfileDescription(String profileDescription) {
        this.profileDescription = profileDescription;
    }

    

}
