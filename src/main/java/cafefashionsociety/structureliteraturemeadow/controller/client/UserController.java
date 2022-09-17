package cafefashionsociety.structureliteraturemeadow.controller.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cafefashionsociety.structureliteraturemeadow.config.Layout;
import cafefashionsociety.structureliteraturemeadow.model.User;
import cafefashionsociety.structureliteraturemeadow.service.ProfileService;
import cafefashionsociety.structureliteraturemeadow.service.ReportService;
import cafefashionsociety.structureliteraturemeadow.service.UserService;

@Layout
@Controller
@RequestMapping(path = "/u")
public class UserController {
    @Autowired
    ProfileService profileService;

    @Autowired
    ReportService reportService;

    @Autowired
    UserService userService;

    @GetMapping(path = "/view")
    public String viewUserPage(Model model, Authentication authentication) {
        User user = userService.findByUsername(authentication.getName());
        model.addAttribute("user", user);
        model.addAttribute("title", user.getUsername().concat("'s details'"));
        return "user";
    }

    @GetMapping(path = "/edit")
    public String editUserPage(Model model, Authentication authentication) {
        User user = userService.findByUsername(authentication.getName());
        model.addAttribute("user", user);
        model.addAttribute("title", user.getUsername().concat("'s details'"));
        return "user";
    }

    @PutMapping(path = "/edit")
    public String saveEditedUserPage(Model model, Authentication authentication, @ModelAttribute User editedUser) {
        User user = userService.findByUsername(authentication.getName());
        if (user.getId().equals(editedUser.getId())) {
            userService.save(editedUser);
        }
        model.addAttribute("message", "New details have been saved");
        model.addAttribute("User", user);
        model.addAttribute("title", editedUser.getUsername().concat("'s details'"));
        return "user";
    }
}
