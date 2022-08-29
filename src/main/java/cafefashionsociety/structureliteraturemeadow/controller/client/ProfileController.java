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

import cafefashionsociety.structureliteraturemeadow.model.Profile;
import cafefashionsociety.structureliteraturemeadow.model.User;
import cafefashionsociety.structureliteraturemeadow.model.forms.ProfileForm;
import cafefashionsociety.structureliteraturemeadow.service.ProfileService;

@Controller
@RequestMapping(path = "/profiles")
public class ProfileController {

    @Autowired
    public ProfileService profileService;

    @GetMapping
    public String allProfilesPage(@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("user", user);
        return "allprofiles";
    }

    @GetMapping(path = "/{pathid}")
    public String profilesPage(@PathVariable String pathid, @AuthenticationPrincipal User user, Model model) {

        Profile profile = new Profile();
        model.addAttribute("profile", profile);
        return "profile";
    }

    @GetMapping(path = "/createnew")
    public String createProfilePage(@AuthenticationPrincipal User user, Model model) {
        return "createprofiles";
    }

    @PostMapping(path = "/createnew", consumes = "application/x-www-form-urlencoded", produces = "text/html")
    public String postNewProfile(@ModelAttribute ProfileForm profileForm, @AuthenticationPrincipal User user,
            Model model) {

        return "profiles";
    }
}
