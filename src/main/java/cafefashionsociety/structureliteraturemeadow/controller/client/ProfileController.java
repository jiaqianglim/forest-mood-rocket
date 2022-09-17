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
import cafefashionsociety.structureliteraturemeadow.model.User;
import cafefashionsociety.structureliteraturemeadow.model.forms.ProfileForm;
import cafefashionsociety.structureliteraturemeadow.service.ProfileService;
import cafefashionsociety.structureliteraturemeadow.service.ReportService;
import cafefashionsociety.structureliteraturemeadow.service.UserService;

@Layout
@Controller
@RequestMapping(path = "/p")
public class ProfileController {

    @Autowired
    ProfileService profileService;

    @Autowired
    ReportService reportService;

    @Autowired
    UserService userService;

    @GetMapping(path = "/all")
    public String allProfilesPage(Model model, Authentication authentication) {
        User user = userService.findByUsername(authentication.getName());
        model.addAttribute("user", user);
        model.addAttribute("title", "View all profiles");
        return "allprofiles";
    }

    @GetMapping(path = "/{pathid}")
    public String profileInfoPage(@PathVariable(required = true) String pathid,
            Model model, Authentication authentication) {
        User user = userService.findByUsername(authentication.getName());
        Profile profile = profileService.findById(pathid);
        if (profile == null)
            return "error/resourceerror";
        model.addAttribute("user", user);
        model.addAttribute("profile", profile);
        model.addAttribute("title", profile.getDisplayName());
        return "profile";
    }

    @GetMapping(path = "/new")
    public String createProfilePage(Model model, Authentication authentication) {
        User user = userService.findByUsername(authentication.getName());
        ProfileForm profileForm = new ProfileForm();
        model.addAttribute("user", user);
        model.addAttribute("profileForm", profileForm);
        model.addAttribute("title", "Create a new report");
        return "createprofile";
    }

    @PostMapping(path = "/new", consumes = "application/x-www-form-urlencoded", produces = "text/html")
    public String postNewProfile(@ModelAttribute ProfileForm profileForm,
            Model model, Authentication authentication) {
        User user = userService.findByUsername(authentication.getName());
        Profile newProfile = profileForm.toProfile();
        user = userService.addProfileToUser(newProfile, user);
        profileService.save(newProfile);
        userService.save(user);
        model.addAttribute("user", user);
        model.addAttribute("title", "All profiles");
        return "allprofiles";
    }
}
