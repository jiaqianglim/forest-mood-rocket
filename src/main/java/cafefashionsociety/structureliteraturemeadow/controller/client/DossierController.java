package cafefashionsociety.structureliteraturemeadow.controller.client;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import cafefashionsociety.structureliteraturemeadow.config.UtilityBeans;
import cafefashionsociety.structureliteraturemeadow.model.Dossier;
import cafefashionsociety.structureliteraturemeadow.model.Note;
import cafefashionsociety.structureliteraturemeadow.model.User;
import cafefashionsociety.structureliteraturemeadow.model.forms.DossierCreationDTO;
import cafefashionsociety.structureliteraturemeadow.service.CreateService;
import cafefashionsociety.structureliteraturemeadow.service.DossierService;
import cafefashionsociety.structureliteraturemeadow.service.NoteService;
import cafefashionsociety.structureliteraturemeadow.service.UserService;

@Controller
public class DossierController {
    @Autowired
    UserService userService;

    @Autowired
    DossierService dossierService;

    @Autowired
    NoteService noteService;

    @Autowired
    CreateService createService;

    @Autowired
    UtilityBeans utilityBeans;

    @PostMapping(path = "/newdossier", consumes = "application/json", produces = "text/html")
    public String postNewDossier(Model model, Authentication authentication, @ModelAttribute DossierCreationDTO form) {
        User user = userService.findByUsername(authentication.getName());
        String name = form.getName();
        List<Note> noteList = form.getDossier();
        List<String> noteIdList = new LinkedList<>();
        for (Note note : noteList) {
            noteIdList.add(note.getId());
        }
        Dossier dossier = new Dossier(utilityBeans.createUUIDString(), name, noteIdList);
        createService.addAndSave(dossier, user);
        List<Note> notes = noteService.findAllById(noteIdList);
        model.addAttribute("dossierName", dossier.getName());
        model.addAttribute("notes", notes);
        model.addAttribute("user", user);
        model.addAttribute("title", "Dossier Json Preview");
        return "client/dossier";
    }

    @GetMapping(path = "/d/{pathid}")
    public String getDossier(Model model, Authentication authentication, @PathVariable String pathid) {
        User user = userService.findByUsername(authentication.getName());
        Dossier dossier = dossierService.getDossierById(pathid);
        List<Note> notes = noteService.findAllById(dossier.getNoteIds());
        model.addAttribute("dossierName", dossier.getName());
        model.addAttribute("notes", notes);
        model.addAttribute("user", user);
        model.addAttribute("title", "Dossier Json Preview");
        return "client/dossier";
    }

}
