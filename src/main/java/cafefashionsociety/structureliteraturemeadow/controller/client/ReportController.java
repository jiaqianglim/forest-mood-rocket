package cafefashionsociety.structureliteraturemeadow.controller.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cafefashionsociety.structureliteraturemeadow.model.User;
import cafefashionsociety.structureliteraturemeadow.model.forms.ReportForm;
import cafefashionsociety.structureliteraturemeadow.service.ReportService;

@Controller
@RequestMapping(path = "/r")
public class ReportController {

    @Autowired
    ReportService reportService;

    @GetMapping
    public String allReportsPage(@AuthenticationPrincipal User user, Model model) {
        
        model.addAttribute("user", user);
        return "allreports";
    }

    @GetMapping(path = "/{reportid}")
    public String reportInfoPage(@PathVariable(required = true) String reportid, @AuthenticationPrincipal User user,
            Model model) {
        return "report";
    }

    @GetMapping
    public String createReportPage(Model model, @AuthenticationPrincipal User user) {
        return "createreport";
    }

    @PostMapping(consumes = "application/x-www-form-urlencoded", produces = "text/html")
    public String postNewReport(@ModelAttribute ReportForm reportForm, @AuthenticationPrincipal User user,
            Model model) {

        return "reports";
    }
}
