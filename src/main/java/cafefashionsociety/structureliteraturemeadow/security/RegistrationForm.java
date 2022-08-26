package cafefashionsociety.structureliteraturemeadow.security;

import org.springframework.security.crypto.password.PasswordEncoder;

import cafefashionsociety.structureliteraturemeadow.model.User;

public class RegistrationForm {

    private String username;
    private String password;
    private String fullname;
    private String userEmail;

    public User toUser(PasswordEncoder passwordEncoder) {
        return new User(username, passwordEncoder.encode(password), fullname, userEmail);
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

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    
}
