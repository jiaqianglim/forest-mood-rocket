package cafefashionsociety.structureliteraturemeadow.controller;

import java.util.LinkedHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cafefashionsociety.structureliteraturemeadow.config.Layout;
import cafefashionsociety.structureliteraturemeadow.model.Profile;
import cafefashionsociety.structureliteraturemeadow.model.User;
import cafefashionsociety.structureliteraturemeadow.model.forms.RegistrationForm;
import cafefashionsociety.structureliteraturemeadow.service.ProfileService;
import cafefashionsociety.structureliteraturemeadow.service.UserService;

@Layout
@Controller
@RequestMapping(path = "/register")
public class RegisterController {

    @Autowired
    UserService userService;

    @Autowired
    ProfileService profileService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @GetMapping
    public String registerGet() {
        return "register";
    }

    @PostMapping
    public String processRegistration(RegistrationForm form, Model model) {
        User newUser = form.toUser(passwordEncoder);
        Profile newUserPersonalProfile = new Profile(newUser.getFullname(), newUser.getId());
        newUser = userService.addNewUserPersonalProfileToUser(newUserPersonalProfile.getId(), newUser);
        userService.save(newUser);
        profileService.save(newUserPersonalProfile);
        return "redirect:/login";
    }
}
