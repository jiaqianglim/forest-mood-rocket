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
}
