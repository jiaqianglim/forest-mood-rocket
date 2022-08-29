package cafefashionsociety.structureliteraturemeadow.controller.client;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cafefashionsociety.structureliteraturemeadow.model.User;
import cafefashionsociety.structureliteraturemeadow.model.forms.ReportForm;

@Controller
@RequestMapping(path = "/reports")
public class ReportController {

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
