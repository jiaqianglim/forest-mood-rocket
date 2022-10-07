package cafefashionsociety.structureliteraturemeadow.controller.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cafefashionsociety.structureliteraturemeadow.config.Layout;
import cafefashionsociety.structureliteraturemeadow.model.Quote;
import cafefashionsociety.structureliteraturemeadow.model.User;
import cafefashionsociety.structureliteraturemeadow.service.ProfileService;
import cafefashionsociety.structureliteraturemeadow.service.QuoteService;
import cafefashionsociety.structureliteraturemeadow.service.NoteService;
import cafefashionsociety.structureliteraturemeadow.service.UserService;

@Layout
@Controller
@RequestMapping(path = "/u")
public class UserController {
    @Autowired
    ProfileService profileService;

    @Autowired
    NoteService noteService;

    @Autowired
    UserService userService;

    @Autowired
    QuoteService quoteService;

    @GetMapping(path = "/view")
    public String viewUserPage(Model model, Authentication authentication) {
        User user = userService.findByUsername(authentication.getName());
        Quote quote = quoteService.getRandomQuote();
        model.addAttribute("quote", quote);
        model.addAttribute("user", user);
        model.addAttribute("title", user.getUsername().concat("'s details'"));
        return "user";
    }
}
