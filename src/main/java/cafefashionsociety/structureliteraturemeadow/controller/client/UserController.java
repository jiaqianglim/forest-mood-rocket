package cafefashionsociety.structureliteraturemeadow.controller.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cafefashionsociety.structureliteraturemeadow.config.Layout;
import cafefashionsociety.structureliteraturemeadow.model.Quote;
import cafefashionsociety.structureliteraturemeadow.model.User;
import cafefashionsociety.structureliteraturemeadow.model.UserList;
import cafefashionsociety.structureliteraturemeadow.service.ProfileService;
import cafefashionsociety.structureliteraturemeadow.service.QuoteService;
import cafefashionsociety.structureliteraturemeadow.service.UserListService;
import cafefashionsociety.structureliteraturemeadow.service.NoteService;
import cafefashionsociety.structureliteraturemeadow.service.UserService;

@Layout
@Controller
@RequestMapping(path = "/u")
public class UserController {

    Logger logger = LoggerFactory.getLogger(UserController.class);
    
    @Autowired
    ProfileService profileService;

    @Autowired
    NoteService noteService;

    @Autowired
    UserService userService;

    @Autowired
    UserListService userListService;

    @Autowired
    QuoteService quoteService;

    @GetMapping(path = "/view") //Done
    public String viewUserPage(Model model, Authentication authentication) {
        User user = userService.findByUsername(authentication.getName());
        UserList userList = userListService.findById("l" + user.getUsername());
        Quote quote = quoteService.getRandomQuote();
        logger.info(Integer.toString(userList.getNoteIds().size()));
        model.addAttribute("quote", quote);
        model.addAttribute("user", user);
        model.addAttribute("userList", userList);
        model.addAttribute("title", "Your details");
        return "client/user";
    }
}
