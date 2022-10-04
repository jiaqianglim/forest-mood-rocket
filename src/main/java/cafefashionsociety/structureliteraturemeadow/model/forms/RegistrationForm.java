package cafefashionsociety.structureliteraturemeadow.model.forms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import cafefashionsociety.structureliteraturemeadow.config.UtilityBeans;
import cafefashionsociety.structureliteraturemeadow.model.User;

public class RegistrationForm {

    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String userEmail;

    @Autowired
    UtilityBeans projectConfig;

    public User toUser(PasswordEncoder passwordEncoder) {

        return new User(projectConfig.createUUIDString(), username, passwordEncoder.encode(password), firstName,
                lastName, userEmail);
    }
}
