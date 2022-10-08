package cafefashionsociety.structureliteraturemeadow.controller.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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

@Controller
@RequestMapping("/d")
public class DossierController {
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

    @PostMapping(path = "/new", consumes = "application/json", produces = "text/html")
    public String postNewDossier(Model model, Authentication authentication, @ModelAttribute DossierForm form) {
        User user = userService.findByUsername(authentication.getName());
        Dossier dossier = form.toDossier();
        UserList userlist = userListService.findById("l" + user.getUsername());
        createService.addAndSave(dossier, userlist);
        List<String> noteIdList = dossier.getNoteIds();
        List<Note> notes = noteService.findAllById(noteIdList);
        model.addAttribute("dossierName", dossier.getName());
        model.addAttribute("notes", notes);
        model.addAttribute("user", user);
        model.addAttribute("title", "Dossier Json Preview");
        return "client/dossier";
    }

    @GetMapping(path = "/d/all")
    public String getAllDossiers(Model model, Authentication authentication) {
        User user = userService.findByUsername(authentication.getName());
        UserList userList = userListService.findById("l" + user.getUsername());
        List<Dossier> dossiers = dossierService.findAllById(userList.getDossierIds());
        model.addAttribute("dossiers", dossiers);
        model.addAttribute("user", user);
        model.addAttribute("title", "All Dossiers");
        return "client/dossier";
    }

}
