package cafefashionsociety.structureliteraturemeadow.controller;

import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cafefashionsociety.structureliteraturemeadow.service.LoginService;
import cafefashionsociety.structureliteraturemeadow.service.UserDashboardService;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    LoginService loginService;

    private final UserDashboardService userDashboardService;

    public LoginController(UserDashboardService userDashboardService) {
        this.userDashboardService = userDashboardService;
    }

    @GetMapping
    public String loginPage() {
        return "user/login";
    }

    @GetMapping("/logout")
    public String logoutPage(Model model) {
        userDashboardService.setUsername(null);
        model.addAttribute("message", "You have been logged out.");
        return "user/login";
    }

    @PostMapping
    public String loginResult(
            @RequestParam String username,
            @RequestParam String password,
            Model model) throws NoSuchAlgorithmException {

        boolean logInResult = loginService.login(username, password);
        if (logInResult) {
            userDashboardService.setUsername(username);
            return "redirect:/dashboard";
        } else {
            model.addAttribute("message", "Log in failed");
            return "user/login";
        }
    }
}
