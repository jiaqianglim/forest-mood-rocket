package cafefashionsociety.structureliteraturemeadow.controller.client;

import java.util.LinkedList;

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
import cafefashionsociety.structureliteraturemeadow.service.CreateService;
import cafefashionsociety.structureliteraturemeadow.service.NoteService;
import cafefashionsociety.structureliteraturemeadow.service.UserService;

@Layout
@Controller
@RequestMapping(path = "/p")
public class ProfileController {

    @Autowired
    ProfileService profileService;

    @Autowired
    NoteService noteService;

    @Autowired
    UserService userService;

    @Autowired
    CreateService createService;

    @GetMapping(path = "/all")
    public String allProfilesPage(Model model, Authentication authentication) {
        User user = userService.findByUsername(authentication.getName());
        LinkedList<Profile> allProfiles = (LinkedList<Profile>) profileService.findAllById(user.getProfileIds());
        model.addAttribute("allProfiles", allProfiles);
        model.addAttribute("user", user);
        model.addAttribute("title", "View all profiles");
        return "client/allprofiles";
    }

    @GetMapping(path = "/{pathid}")
    public String profileInfoPage(@PathVariable(required = true) String pathid,
            Model model, Authentication authentication) {
        User user = userService.findByUsername(authentication.getName());
        Profile profile = profileService.findById(pathid);
        if (profile == null)
            return "error/resourceerror";
        if (!user.getProfileIds().contains(profile.getId())) {
            return "error/permissionerror";
        }
        model.addAttribute("user", user);
        model.addAttribute("profile", profile);
        model.addAttribute("title", profile.getDisplayName());
        return "client/profile";
    }

    // New profile creation
    @GetMapping(path = "/new")
    public String createProfilePage(Model model, Authentication authentication) {
        User user = userService.findByUsername(authentication.getName());
        ProfileForm profileForm = new ProfileForm();
        model.addAttribute("user", user);
        model.addAttribute("profileForm", profileForm);
        model.addAttribute("title", "Create a new note");
        return "client/createprofile";
    }

    @PostMapping(path = "/new", consumes = "application/x-www-form-urlencoded", produces = "text/html")
    public String postNewProfile(@ModelAttribute ProfileForm profileForm,
            Model model, Authentication authentication) {
        User user = userService.findByUsername(authentication.getName());
        Profile newProfile = profileForm.toProfile();
        createService.addAndSave(newProfile, user);
        model.addAttribute("user", user);
        model.addAttribute("title", "All profiles");
        return "client/allprofiles";
    }
}
