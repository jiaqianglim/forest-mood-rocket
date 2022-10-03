package cafefashionsociety.structureliteraturemeadow.controller;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cafefashionsociety.structureliteraturemeadow.config.Layout;
import cafefashionsociety.structureliteraturemeadow.config.UtilityBeans;
import cafefashionsociety.structureliteraturemeadow.model.Profile;
import cafefashionsociety.structureliteraturemeadow.model.Note;
import cafefashionsociety.structureliteraturemeadow.model.User;
import cafefashionsociety.structureliteraturemeadow.model.forms.RegistrationForm;
import cafefashionsociety.structureliteraturemeadow.service.ProfileService;
import cafefashionsociety.structureliteraturemeadow.service.NoteService;
import cafefashionsociety.structureliteraturemeadow.service.UserService;

@Layout
@Controller
@RequestMapping(path = "/register")
public class RegisterController {

    Logger logger = LoggerFactory.getLogger(RegisterController.class);

    @Autowired
    UtilityBeans projectConfig;

    @Autowired
    UserService userService;

    @Autowired
    ProfileService profileService;

    @Autowired
    NoteService noteService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @GetMapping
    public String registerGet() {
        return "register";
    }

    @PostMapping
    public String processNewUserRegistration(RegistrationForm registrationForm) {

        User newUser = registrationForm.toUser(passwordEncoder);
        Profile newPersonalProfile = new Profile(projectConfig.createUUIDString(), newUser.getUsername(),
                newUser.getUserEmail(),
                "My Personal Profile",
                "Active Learner",
                "", false, "", newUser.getId(),
                true);
        Note newSampleNote = new Note(projectConfig.createUUIDString(), newUser.getId(),
                newPersonalProfile.getId(), LocalDate.now(), "My first sample note",
                "I created a new sample note!", "I made my first step in learning!", "Excited");

        newPersonalProfile = profileService.addNoteToProfile(newSampleNote, newPersonalProfile);
        newUser = userService.addNoteToProfileToUser(newSampleNote, newPersonalProfile, newUser);
        noteService.save(newSampleNote);
        profileService.save(newPersonalProfile);
        userService.save(newUser);
        logger.info("new user {user} saved", newUser.getUsername());
        return "redirect:/login";
    }

}
