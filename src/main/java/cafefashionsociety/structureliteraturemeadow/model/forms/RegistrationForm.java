package cafefashionsociety.structureliteraturemeadow.model.forms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import cafefashionsociety.structureliteraturemeadow.config.ProjectConfig;
import cafefashionsociety.structureliteraturemeadow.model.User;

public class RegistrationForm {

    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String userEmail;

    @Autowired
    ProjectConfig projectConfig;

    public User toUser(PasswordEncoder passwordEncoder) {

        return new User(projectConfig.createUUIDString(), username, passwordEncoder.encode(password), firstName,
                lastName, userEmail);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}
