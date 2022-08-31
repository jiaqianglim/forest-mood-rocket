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

import cafefashionsociety.structureliteraturemeadow.config.Layout;
import cafefashionsociety.structureliteraturemeadow.model.Profile;
import cafefashionsociety.structureliteraturemeadow.model.User;
import cafefashionsociety.structureliteraturemeadow.model.forms.ProfileForm;
import cafefashionsociety.structureliteraturemeadow.service.ProfileService;

@Layout
@Controller
@RequestMapping(path = "/p")
public class ProfileController {

    @Autowired
    ProfileService profileService;

    @GetMapping(path = "/all")
    public String allProfilesPage(Model model) {
        return "allprofiles";
    }

    @GetMapping(path = "/{pathid}")
    public String profileInfoPage(@PathVariable(required = true) String pathid,
            Model model) {

        Profile profile = new Profile();
        model.addAttribute("profile", profile);
        return "profile";
    }

    @GetMapping(path = "/new")
    public String createProfilePage(Model model) {
        return "createprofile";
    }

    @PostMapping(path = "/new", consumes = "application/x-www-form-urlencoded", produces = "text/html")
    public String postNewProfile(@ModelAttribute ProfileForm profileForm,
            Model model) {

        return "profiles";
    }
}
