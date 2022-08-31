package cafefashionsociety.structureliteraturemeadow.controller.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cafefashionsociety.structureliteraturemeadow.config.Layout;
import cafefashionsociety.structureliteraturemeadow.model.User;
import cafefashionsociety.structureliteraturemeadow.model.forms.ReportForm;
import cafefashionsociety.structureliteraturemeadow.service.ReportService;
import cafefashionsociety.structureliteraturemeadow.service.UserService;

@Layout
@Controller
@RequestMapping(path = "/r")
public class ReportController {

    @Autowired
    ReportService reportService;

    @Autowired
    UserService userService;

    @GetMapping("/all")
    public String allReportsPage(Model model) {

        return "allreports";
    }

    @GetMapping(path = "/{reportid}")
    public String reportInfoPage(@PathVariable(required = true) String reportid,
            Model model) {
        return "report";
    }

    @GetMapping("/new")
    public String createReportPage(Model model, Authentication authentication) {
        User user = userService.findByUsername(authentication.getName());
        ReportForm reportForm = new ReportForm();
        model.addAttribute("user", user);
        model.addAttribute("reportForm", reportForm);
        model.addAttribute("title", "Create a new report");
        return "client/createreport";
    }

    @PostMapping(path = "/new", consumes = "application/x-www-form-urlencoded", produces = "text/html")
    public String postNewReport(@ModelAttribute ReportForm reportForm, Model model) {

        return "reports";
    }
}
