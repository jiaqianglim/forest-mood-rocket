package cafefashionsociety.structureliteraturemeadow.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cafefashionsociety.structureliteraturemeadow.repository.IUserRepository;

@Controller
@RequestMapping(path = "/register")
public class RegisterController {

    @Autowired
    IUserRepository iUserRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @GetMapping
    public String registerGet() {
        return "register";
    }

    @PostMapping
    public String processRegistration(RegistrationForm form) {
        iUserRepository.save(form.toUser(passwordEncoder));
        return "redirect:/login";
    }
}
