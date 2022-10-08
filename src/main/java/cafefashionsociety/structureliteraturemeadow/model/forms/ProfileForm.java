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

}
