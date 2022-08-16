package cafefashionsociety.structureliteraturemeadow.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cafefashionsociety.structureliteraturemeadow.service.UserDashboardService;

@Controller
@RequestMapping("dashboard")
public class DashboardController {
    private final UserDashboardService userDashboardService;

    public DashboardController(UserDashboardService userDashboardService) {
        this.userDashboardService = userDashboardService;
    }

    @GetMapping
    public String dashboardPage(Model Model) {
        String username = userDashboardService.getUsername();
        if (username == null) {
            return "redirect:/user/login";
        }
        return "dashboard";
    }
}
