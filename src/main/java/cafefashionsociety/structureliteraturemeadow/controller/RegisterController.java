package cafefashionsociety.structureliteraturemeadow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cafefashionsociety.structureliteraturemeadow.model.forms.RegistrationForm;
import cafefashionsociety.structureliteraturemeadow.service.UserService;

@Controller
@RequestMapping(path = "/register")
public class RegisterController {

    @Autowired
    UserService userService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @GetMapping
    public String registerGet() {
        return "register";
    }

    @PostMapping
    public String processRegistration(RegistrationForm form) {
        userService.save(form.toUser(passwordEncoder));
        return "redirect:/login";
    }
}
