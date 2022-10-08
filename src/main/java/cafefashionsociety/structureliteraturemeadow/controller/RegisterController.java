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
import cafefashionsociety.structureliteraturemeadow.model.UserList;
import cafefashionsociety.structureliteraturemeadow.model.forms.RegistrationForm;
import cafefashionsociety.structureliteraturemeadow.service.ProfileService;
import cafefashionsociety.structureliteraturemeadow.service.CreateService;
import cafefashionsociety.structureliteraturemeadow.service.NoteService;
import cafefashionsociety.structureliteraturemeadow.service.UserService;

@Layout
@Controller
@RequestMapping(path = "/register")
public class RegisterController {

    Logger logger = LoggerFactory.getLogger(RegisterController.class);

    @Autowired
    UserService userService;

    @Autowired
    ProfileService profileService;

    @Autowired
    NoteService noteService;

    @Autowired
    CreateService createService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @GetMapping
    public String registerGet() {
        return "register";
    }

    @PostMapping
    public String processNewUserRegistration(RegistrationForm registrationForm) {

        UtilityBeans utilityBeans = new UtilityBeans();

        User newUser = registrationForm.toUser(passwordEncoder);

        UserList newUserLists = new UserList().createUserList("l" + newUser.getUsername());

        Profile newPersonalProfile = new Profile(utilityBeans.createUUIDString(), newUser.getUsername(),
                "My Personal Profile", "Active Learner", "This is my personal profile for my personal notes!");

        utilityBeans = new UtilityBeans();
        Note newSampleNote = new Note(utilityBeans.createUUIDString(), newUser.getUsername(),
                newPersonalProfile.getId(), LocalDate.now().toString(), "My first sample note",
                "I created a new sample note!", "I made my first step in learning!", "Excited");

        createService.addAndSave(newSampleNote, newPersonalProfile, newUserLists);

        logger.info("new user " + newUser.getUsername() + " created");
        return "redirect:/login";
    }

}
