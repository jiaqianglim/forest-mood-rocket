package cafefashionsociety.structureliteraturemeadow.controller.client;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import cafefashionsociety.structureliteraturemeadow.config.UtilityBeans;
import cafefashionsociety.structureliteraturemeadow.model.Dossier;
import cafefashionsociety.structureliteraturemeadow.model.Note;
import cafefashionsociety.structureliteraturemeadow.model.User;
import cafefashionsociety.structureliteraturemeadow.model.forms.DossierCreationDTO;
import cafefashionsociety.structureliteraturemeadow.service.DossierService;
import cafefashionsociety.structureliteraturemeadow.service.UserService;

@Controller
public class DossierController {
    @Autowired
    UserService userService;

    @Autowired
    DossierService dossierService;

    @Autowired
    UtilityBeans utilityBeans;

    @PostMapping(path = "/newdossier", consumes = "application/json", produces = "text/html")
    public String postNewDossier(Model model, Authentication authentication, @ModelAttribute DossierCreationDTO form) {
        User user = userService.findByUsername(authentication.getName());
        List<Note> noteList = form.getDossier();
        List<String> noteIdList = new LinkedList<>();
        for (Note note : noteList) {
            noteIdList.add(note.getId());
        }
        Dossier dossier = new Dossier(utilityBeans.createUUIDString(), noteIdList);
        dossierService.save(dossier);
        model.addAttribute("dossier", dossier);
        return "client/dossier";
    }

}
