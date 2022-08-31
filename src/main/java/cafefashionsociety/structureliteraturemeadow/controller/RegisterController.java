package cafefashionsociety.structureliteraturemeadow.controller;

import java.time.LocalDate;
import java.util.LinkedHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cafefashionsociety.structureliteraturemeadow.config.Layout;
import cafefashionsociety.structureliteraturemeadow.config.ProjectConfig;
import cafefashionsociety.structureliteraturemeadow.model.Profile;
import cafefashionsociety.structureliteraturemeadow.model.Report;
import cafefashionsociety.structureliteraturemeadow.model.User;
import cafefashionsociety.structureliteraturemeadow.model.forms.RegistrationForm;
import cafefashionsociety.structureliteraturemeadow.service.ProfileService;
import cafefashionsociety.structureliteraturemeadow.service.ReportService;
import cafefashionsociety.structureliteraturemeadow.service.UserService;

@Layout
@Controller
@RequestMapping(path = "/register")
public class RegisterController {

    @Autowired
    ProjectConfig projectConfig;

    @Autowired
    UserService userService;

    @Autowired
    ProfileService profileService;

    @Autowired
    ReportService reportService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @GetMapping
    public String registerGet() {
        return "register";
    }

    @PostMapping
    public String processNewUserRegistration(RegistrationForm registrationForm) {

        User newUser = registrationForm.toUser(passwordEncoder);
        Profile newUserPersonalProfile = new Profile(projectConfig.createUUIDString(), newUser.getUsername(),
                newUser.getUserEmail(),
                "My Personal Profile",
                "Active Learner",
                "", false, "", newUser.getId(),
                true);
        Report newUserSampleReport = new Report(projectConfig.createUUIDString(), newUser.getId(),
                newUserPersonalProfile.getId(), LocalDate.now(), "My first sample report",
                "I created a new sample report!", "I made my first step in learning!", "Excited");
        newUserPersonalProfile = profileService.addReportToProfile(newUserPersonalProfile, newUserSampleReport);
        newUser = userService.addProfileToUser(newUser, newUserPersonalProfile);
        newUser = userService.addReportToUser(newUser, newUserSampleReport);
        reportService.save(newUserSampleReport);
        profileService.save(newUserPersonalProfile);
        userService.save(newUser);

        return "redirect:/login";
    }

}
