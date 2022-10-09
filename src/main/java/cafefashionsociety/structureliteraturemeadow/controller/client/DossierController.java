package cafefashionsociety.structureliteraturemeadow.controller.client;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import cafefashionsociety.structureliteraturemeadow.config.Layout;
import cafefashionsociety.structureliteraturemeadow.model.Dossier;
import cafefashionsociety.structureliteraturemeadow.model.Note;
import cafefashionsociety.structureliteraturemeadow.model.User;
import cafefashionsociety.structureliteraturemeadow.model.UserList;
import cafefashionsociety.structureliteraturemeadow.model.forms.DossierForm;
import cafefashionsociety.structureliteraturemeadow.service.CreateService;
import cafefashionsociety.structureliteraturemeadow.service.DossierService;
import cafefashionsociety.structureliteraturemeadow.service.NoteService;
import cafefashionsociety.structureliteraturemeadow.service.UserListService;
import cafefashionsociety.structureliteraturemeadow.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;

@Layout
@Controller
@RequestMapping("/d")
public class DossierController {

    Logger logger = LoggerFactory.getLogger(DossierController.class);

    @Autowired
    UserService userService;

    @Autowired
    UserListService userListService;

    @Autowired
    DossierService dossierService;

    @Autowired
    NoteService noteService;

    @Autowired
    CreateService createService;

    @GetMapping("/new")
    public String createNewDossier(Model model, Authentication authentication) {
        User user = userService.findByUsername(authentication.getName());
        UserList userList = userListService.findById("l" + user.getUsername());
        List<Note> notes = noteService.findAllById(userList.getNoteIds());
        DossierForm dossierForm = new DossierForm();
        model.addAttribute("dossierForm", dossierForm);
        model.addAttribute("notes", notes);
        model.addAttribute("user", user);
        model.addAttribute("title", "Create a new dossier");
        return "client/dossiernew";
    }

    @PostMapping("/new")
    public String postNewDossier(Model model, Authentication authentication, DossierForm form) {
        User user = userService.findByUsername(authentication.getName());
        Dossier dossier = form.toDossier();
        UserList userList = userListService.findById("l" + user.getUsername());
        createService.addAndSave(dossier, userList);
        logger.info("dossier saved");
        user = userService.findByUsername(authentication.getName());
        userList = userListService.findById("l" + user.getUsername());
        List<Dossier> dossiers = dossierService.findAllById(userList.getDossierIds());
        model.addAttribute("dossiers", dossiers);
        model.addAttribute("user", user);
        model.addAttribute("title", "All Dossiers");
        return "client/dossierall";
    }

    @GetMapping(path = "/all")
    public String getAllDossiers(Model model, Authentication authentication) {
        User user = userService.findByUsername(authentication.getName());
        UserList userList = userListService.findById("l" + user.getUsername());
        List<Dossier> dossiers = dossierService.findAllById(userList.getDossierIds());
        model.addAttribute("dossiers", dossiers);
        model.addAttribute("user", user);
        model.addAttribute("title", "All Dossiers");
        return "client/dossierall";
    }

}
