package cafefashionsociety.structureliteraturemeadow.service;

import java.security.NoSuchAlgorithmException;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;

import cafefashionsociety.structureliteraturemeadow.config.UserConfig;

@Service
@RequestScope
public class LoginService {

    private final UserDashboardService userDashboardService;

    private String inputUsername;
    private String inputPassword;

    public LoginService(UserDashboardService userDashboardService) {
        this.userDashboardService = userDashboardService;
    }

    public boolean login(String inputUsername, String inputPassword) throws NoSuchAlgorithmException {
        inputUsername = this.inputUsername;
        inputPassword = this.inputPassword;
        boolean loginResult = false;
        try {
            String encryptedInputPassword = UserConfig.encryptPassword(inputPassword);
            String dbPassword = findPasswordById(inputUsername);
            if (encryptedInputPassword.equals(dbPassword)) {
                loginResult = true;
                userDashboardService.setUsername(inputUsername);
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return loginResult;
    }

    private String findPasswordById(String inputUsername) {
        String dbPassword = "";
        // TODO
        return dbPassword;
    }
}
