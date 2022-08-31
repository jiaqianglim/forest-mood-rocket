package cafefashionsociety.structureliteraturemeadow.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import cafefashionsociety.structureliteraturemeadow.config.Layout;

@Layout
@Controller
public class LoginController {
    @GetMapping(path = "/login")
    public String loginGet(Model model) {
        model.addAttribute("title", "Login");
        return "login";
    }

}
