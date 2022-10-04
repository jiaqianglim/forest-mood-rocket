package cafefashionsociety.structureliteraturemeadow.model.forms;

import org.springframework.beans.factory.annotation.Autowired;

import cafefashionsociety.structureliteraturemeadow.config.UtilityBeans;
import cafefashionsociety.structureliteraturemeadow.model.Profile;

public class ProfileForm {

    private String displayName;
    private String organisationName;
    private String organisationRole;

    @Autowired
    UtilityBeans projectConfig;

    public Profile toProfile() {
        return new Profile(projectConfig.createUUIDString(), displayName, organisationName, organisationRole);
    }

}
