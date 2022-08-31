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
import cafefashionsociety.structureliteraturemeadow.model.Profile;
import cafefashionsociety.structureliteraturemeadow.model.Report;
import cafefashionsociety.structureliteraturemeadow.model.User;
import cafefashionsociety.structureliteraturemeadow.model.forms.ReportForm;
import cafefashionsociety.structureliteraturemeadow.service.ProfileService;
import cafefashionsociety.structureliteraturemeadow.service.ReportService;
import cafefashionsociety.structureliteraturemeadow.service.UserService;

@Layout
@Controller
@RequestMapping(path = "/r")
public class ReportController {

    @Autowired
    ProfileService profileService;

    @Autowired
    ReportService reportService;

    @Autowired
    UserService userService;

    @GetMapping("/all")
    public String allReportsPage(Model model, Authentication authentication) {
        User user = userService.findByUsername(authentication.getName());
        model.addAttribute("user", user);
        model.addAttribute("title", "View all reports");
        return "allreports";
    }

    @GetMapping(path = "/{pathid}")
    public String reportInfoPage(@PathVariable(required = true) String pathid,
            Model model, Authentication authentication) {
        User user = userService.findByUsername(authentication.getName());
        if (!user.getReportIdsAndTitle().containsKey(pathid))
            return "error/permissionerror";
        Report report = reportService.findById(pathid);
        if(report==null)
                return "error/resourceerror";
        model.addAttribute("user", user);
        model.addAttribute("report", report);
        model.addAttribute("title", report.getTitle());
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
    public String postNewReport(@ModelAttribute ReportForm reportForm, Model model, Authentication authentication) {
        User user = userService.findByUsername(authentication.getName());
        Report newReport = reportForm.toReport();
        Profile profile = profileService.findById(newReport.getProfileId());
        user = userService.addReportToProfileToUser(newReport, profile, user);
        reportService.save(newReport);
        profileService.save(profile);
        userService.save(user);
        model.addAttribute("user", user);
        model.addAttribute("title", "All reports");
        return "allreports";
    }
}
